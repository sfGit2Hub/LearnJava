package study.internet.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * daytime UDP 服务器
 */
public class DaytimeUDPServer {
    private static final int PORT = 13;
    private static final Logger audit = Logger.getLogger("request");
    private static final Logger errors = Logger.getLogger("errors");

    public static void main(String []args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            while (true) {
                try {
                    DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                    socket.receive(request);

                    String daytime = new Date().toString();
                    byte[] date = daytime.getBytes("US-ASCII");
                    DatagramPacket response = new DatagramPacket(date, date.length, request.getAddress(), request.getPort());
                    socket.send(response);
                    audit.info(daytime + " " + request.getAddress());
                } catch (IOException e) {
                    errors.log(Level.SEVERE, e.getMessage(), e);
                }
            }
        } catch (SocketException e) {
            errors.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
