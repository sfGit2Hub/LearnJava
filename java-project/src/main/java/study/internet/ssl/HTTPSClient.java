package study.internet.ssl;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.UnknownHostException;

/**
 */
public class HTTPSClient {
    public static void main(String []args) {
        if (args.length == 0) {
            System.out.println("Usage: java HTTPS client2 host");
            return;
        }

        int port = 443;     //默认https端口
        String host = args[0];
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (
                SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
                ){
//            启用所有密码组
            String[] supported = socket.getSupportedCipherSuites();
            socket.setEnabledCipherSuites(supported);

            Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
//            https 在GET行中需要完全URL
            out.write("GET http://" + host + "/ HTTP/1.1\r\n");
            out.write("Host: " + host + "\r\n");
            out.write("\r\n");
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            读取首部
            String s;
            while ((s = in.readLine()).equals("")) {
                System.out.println(s);
            }
            System.out.println();

//            读取长度
            String contentLength = in.readLine();
            int length = Integer.MAX_VALUE;
            try {
                length = Integer.valueOf(contentLength.trim(), 16);
            } catch (NumberFormatException e) {
//                这个服务器在响应体的第一行，没有发送content-length
                e.printStackTrace();
            }
            System.out.println(contentLength);

            int c;
            int i= 0;
            while ((c = in.read()) != -1 && i++ < length) {
                System.out.write(c);
            }
            System.out.println();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
