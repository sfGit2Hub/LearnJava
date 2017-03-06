package study.internet.socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 查找本地端口
 */
public class LocalPortScanner {
    public static void main(String[] args) {
        for (int port = 1; port < 65535; port++) {
            try {
                ServerSocket server = new ServerSocket(port);
            } catch (IOException e) {
                System.out.println("There is a server on port " + port + ".");
            }
        }
    }
}
