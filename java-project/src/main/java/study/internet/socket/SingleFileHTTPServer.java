package study.internet.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 提供同一个文件的HTTP服务器
 */
public class SingleFileHTTPServer {
    private static final Logger logger = Logger.getLogger(SingleFileHTTPServer.class.getSimpleName());
    private static int DEFAULT_THREAD = 100;

    private final byte[] content;
    private final byte[] header;
    private final int port;
    private final String encoding;

    public SingleFileHTTPServer(byte[] data, String encoding, String mimeType, int port) {
        this.content = data;
        this.port = port;
        this.encoding = encoding;
        String header = "HTTP/1.0 200 OK\r\n"
                + "Server: OneFile 2.0\r\n"
                + "Content-length: " + this.content.length + "\r\n"
                + "Content-type: " + mimeType + "; charset=" + encoding + "\r\n\r\n";
        this.header = header.getBytes(Charset.forName("US-ASCII"));
    }

    public SingleFileHTTPServer(String data, String encoding, String mimeType, int port)
            throws UnsupportedEncodingException {
        this(data.getBytes(encoding), encoding, mimeType, port);
    }

    public void start() {
        ExecutorService pool = Executors.newFixedThreadPool(DEFAULT_THREAD);
        try (ServerSocket server = new ServerSocket(this.port)){
            logger.info("Accepting connections on port:" + server.getLocalPort());
            logger.info("Data to be sent:");
            logger.info(new String(this.content, encoding));

            while (true) {
                try {
                    Socket connection = server.accept();
                    pool.submit(new HttpHandler(connection));
                } catch (IOException e) {
                    logger.log(Level.WARNING, "Exception accepting connection ", e);
                } catch (RuntimeException re) {
                    logger.log(Level.WARNING, "Unexpected error", re);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not start server", e);
        }
    }

    private class HttpHandler implements Callable<Boolean> {
        private final Socket connection;

        HttpHandler(Socket socket) {
            this.connection = socket;
        }

        @Override
        public Boolean call() throws Exception {
            try (
                    OutputStream out = new BufferedOutputStream(connection.getOutputStream());
                    InputStream in = new BufferedInputStream(connection.getInputStream())
                    ){
//                只读取第一行，这是我们需要的全部内容
                StringBuilder request = new StringBuilder(80);
                while (true) {
                    int c = in.read();
                    if (c == '\r' || c == '\n' || c == -1) break;
                    request.append((char) c);
                }
//                如果是HTTP/1.0 或以后的版本， 则发送一个MIME首部
                if (request.toString().contains("HTTP/")) {
                    out.write(header);
                }
                out.write(content);
                out.flush();
            } catch (IOException e) {
                logger.log(Level.WARNING, "ERROR writing to client", e);
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int port;
        try {
            port = Integer.parseInt(args[1]);
            if (port < 1 || port > 65535) port = 80;
        } catch (RuntimeException ex) {
            port = 80;
        }

        String encoding = "UTF-8";
        if (args.length > 2) encoding = args[2];

        try {
            Path path = Paths.get(args[0]);
            byte[] data = Files.readAllBytes(path);

            String contentType = URLConnection.getFileNameMap().getContentTypeFor(args[0]);
            SingleFileHTTPServer server = new SingleFileHTTPServer(data, encoding,
                    contentType, port);
            server.start();

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(
                    "Usage: java SingleFileHTTPServer filename port encoding");
        } catch (IOException ex) {
            logger.severe(ex.getMessage());
        }
    }
}
