package study.internet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 简单的链接 socket 服务器端获取时间
 */
public class DaytimeClient {
    public static void main(String[] args) {
        String hostname = args.length > 0 ? args[0] : "time.nist.gov";
        try (Socket socket = new Socket(hostname, 13)){
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuilder strBui = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int i = reader.read(); i != -1; i = reader.read()) {
                strBui.append((char) i);
            }
            System.out.println(strBui);
            in.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
