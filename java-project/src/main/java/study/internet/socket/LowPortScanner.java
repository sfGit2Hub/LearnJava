package study.internet.socket;

import java.io.IOException;
import java.net.*;

/**
 */
public class LowPortScanner {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        for (int i = 1; i < 1024; i++) {
            try (Socket socket = new Socket(host, i)){
                System.out.println("There is a server on port " + i + "of " + host);
            } catch (UnknownHostException e) {
                e.printStackTrace();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void socketAddress() throws IOException {
        Socket socket = new Socket();
        SocketAddress address = new InetSocketAddress("time.nist.gov", 13);
        socket.connect(address);
    }

    public Socket proxySocket() {
        SocketAddress proxyAddress = new InetSocketAddress("www.proxy.com", 1080);
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
        return new Socket(proxy);
    }
}
