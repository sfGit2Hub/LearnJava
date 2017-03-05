package study.internet.socket;

import java.io.*;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 处理HTTP 请求的 runnable 类
 */
public class RequestProcessor implements Runnable {
    private static final Logger logger = Logger.getLogger(RequestProcessor.class.getCanonicalName());

    private File rootDirectory;
    private String indexFileName = "hello.html";
    private Socket connection;

    public RequestProcessor(File rootDirectory, String indexFileName, Socket connection) {
        if (rootDirectory.isFile()) {
            throw new IllegalArgumentException("rootDirectory must be a directory, not be a file");
        }
        try {
//            使用规范文件路径
            rootDirectory = rootDirectory.getCanonicalFile();
        } catch (IOException e) {
//            不做处理
        }
        this.rootDirectory = rootDirectory;
        if (indexFileName != null) this.indexFileName = indexFileName;
        this.connection = connection;
    }
    @Override
    public void run() {
//        安全检查
        String root = this.rootDirectory.getPath();
        try (
                OutputStream raw = new BufferedOutputStream(this.connection.getOutputStream());
                Writer out = new OutputStreamWriter(raw);
                Reader in = new InputStreamReader(
                        new BufferedInputStream(this.connection.getInputStream()),
                        "US-ASCII"
                )
        ){
            StringBuilder requestLine = new StringBuilder();
            while (true) {
                int c = in.read();
                if (c == '\r' || c == '\n') break;
                requestLine.append((char) c);
            }

            String get = requestLine.toString();

            logger.info(connection.getRemoteSocketAddress() + " " + get);

            String[] tokens = get.split("\\s+");
            String method = tokens[0];
            String version = "";
            if (method.equals("GET")) {
                String fileName = tokens[1];
                if (fileName.endsWith("/")) fileName += indexFileName;
                String contentType =
                        URLConnection.getFileNameMap().getContentTypeFor(fileName);
                if (tokens.length > 2) {
                    version = tokens[2];
                }

                File theFile = new File(rootDirectory,
                        fileName.substring(1, fileName.length()));
                if (theFile.canRead() && theFile.getCanonicalPath().startsWith(root)) {
//                    不要让客户端访问超出文档根部
                    byte[] theData = Files.readAllBytes(theFile.toPath());
                    if (version.startsWith("HTTP/")) {
                        sendHeader(out, "HTTP/1.1 200 OK", contentType, theData.length);
                    }

//                    文件有可能是一个图像或者二进制文件，所以需要用底层输出流
//                    不能用Writer
                    raw.write(theData);
                    raw.flush();
                }else {
//                    没有找到对应文件
                    String body = new StringBuilder("<HTML>\r\n")
                            .append("<HEAD><TITLE>File Not Found</TITLE>\r\n")
                            .append("</HEAD>\r\n")
                            .append("<BODY>")
                            .append("<H1>HTTP Error 404: File Not Found</H1>\r\n")
                            .append("</BODY></HTML>\r\n").toString();
                    if (version.startsWith("HTTP/")) { // send a MIME header
                        sendHeader(out, "HTTP/1.1 404 File Not Found",
                                "text/html; charset=utf-8", body.length());
                    }
                    out.write(body);
                    out.flush();
                }
            } else {
//                访问方法不是GET
                String body = new StringBuilder("<HTML>\r\n")
                        .append("<HEAD><TITLE>Not Implemented</TITLE>\r\n")
                        .append("</HEAD>\r\n")
                        .append("<BODY>")
                        .append("<H1>HTTP Error 501: Not Implemented</H1>\r\n")
                        .append("</BODY></HTML>\r\n").toString();
                if (version.startsWith("HTTP/")) {
//                    发送一个MIME头部
                    sendHeader(out, "HTTP/1.0 501 Not Implemented",
                            "text/html; charset=utf-8", body.length());
                }
                out.write(body);
                out.flush();
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error talking to " + connection.getRemoteSocketAddress(), e);
        }
    }

    private void sendHeader(Writer out, String responseCode, String contentType, int length) throws IOException {
        out.write(responseCode + "\r\n");
        Date now = new Date();
        out.write("Date: " + now + "\r\n");
        out.write("Server: JHTTP 2.0\r\n");
        out.write("Content-length: " + length + "\r\n");
        out.write("Content-type: " + contentType + "\r\n\r\n");
        out.flush();
    }
}
