package study.internet.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 重定向服务器
 */
public class Redirector {
    private static final Logger logger = Logger.getLogger(Redirector.class.getSimpleName());

    private final int port;
    private final String newSite;

    public Redirector(String newSite, int port) {
        this.port = port;
        this.newSite = newSite;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)){
            logger.info("Redirecting connections on port " + server.getLocalPort() + " to " + newSite);

            while (true) {
                try {
                    Socket client = server.accept();
                    Thread thread = new RedirectThread(client);
                    thread.start();
                } catch (IOException e) {
                    logger.log(Level.WARNING, "Exception accepting connection.");
                } catch (RuntimeException e) {
                    logger.log(Level.SEVERE, "Unexpected error!", e);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not start server.", e);
        }
    }

    private class RedirectThread extends Thread {
        private final Socket client;

        public RedirectThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try(
                    Writer out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "US-ASCII"));
                    Reader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
            ) {
                StringBuilder request = new StringBuilder(80);
//                只读取第一行，这就是我们需要的全部内容
//                如果我们需要其他请求内容，可以进行扩展
                while (true) {
                    int c = in.read();
                    if (c == '\r' || c == '\n' || c == -1) break;
                    request.append((char) c);
                }
                String get = request.toString();
                String[] pieces = get.split("\\w*");
                String theFile = pieces[1];

//                如果是HTTP/1.0 或以后的版本，则发送一个MIME首部
                if (get.indexOf("HTTP") != -1) {
                    out.write("HTTP/1.1 302 FOUND\r\n");
                    Date now = new Date();
                    out.write("Date: " + now + "\r\n");
                    out.write("Server: Redirector 1.1\r\n");
                    out.write("Location: " + newSite + theFile + "\r\n");
                    out.write("Content-type: text/html\r\n\r\n");
                    out.flush();
                }

//                并不是所有浏览器都支持重定向，所以我们需要生产HTML指出文档转移到哪里
                out.write("<HTML><HEAD><TITLE>Document moved</TITLE></HEAD>\r\n");
                out.write("<BODY><H1>Document moved</H1>\r\n");
                out.write("The document " + theFile
                        + " has moved to\r\n<A HREF=\"" + newSite + theFile + "\">"
                        + newSite  + theFile
                        + "</A>.\r\n Please update your bookmarks<P>");
                out.write("</BODY></HTML>\r\n");
                out.flush();
                logger.log(Level.INFO,
                        "Redirected " + client.getRemoteSocketAddress());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    logger.log(Level.WARNING, "Close client connect error.", e);
                }
            }
        }
    }

    public static void main(String[] args) {

        int thePort;
        String theSite;

        try {
            theSite = args[0];
//            删除末尾的斜线
            if (theSite.endsWith("/")) {
                theSite = theSite.substring(0, theSite.length() - 1);
            }
            try {
                thePort = Integer.valueOf(args[1]);
            } catch (RuntimeException e) {
                thePort = 80;
            }
            Redirector redirector = new Redirector(theSite, thePort);
            redirector.start();
        } catch (RuntimeException ex) {
            System.out.println(
                    "Usage: java Redirector http://www.baidu.com");
            return;
        }

        try {
            thePort = Integer.parseInt(args[1]);
        } catch (RuntimeException ex) {
            thePort = 80;
        }

        Redirector redirector = new Redirector(theSite, thePort);
        redirector.start();
    }
}
