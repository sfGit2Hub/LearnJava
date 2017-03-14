package study.internet.udp;

import java.io.IOException;
import java.net.*;

/**
 * UDP daytime 协议客户端
 */
public class DaytimeUDPClient {
    private static final int PORT = 13;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(0)) {
            socket.setSoTimeout(10000);
            InetAddress host = InetAddress.getByName(HOST);
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, PORT);
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.send(request);
            socket.receive(response);

            String result = new String(response.getData(), 0, response.getLength(), "US-ASCII");
            System.out.println(result);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
