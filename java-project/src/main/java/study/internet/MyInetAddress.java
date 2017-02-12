package study.internet;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class MyInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);
            InetAddress host = InetAddress.getByName(address.getHostAddress());
            System.out.println(host.getCanonicalHostName());
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            InetAddress localAddress = InetAddress.getByName("HY50-20151204ZX");
            System.out.println(localAddress);
            showInterFaceLister();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

//        SecurityManager securityManager = new SecurityManager();
//        securityManager.checkConnect("www.baidu.com", -1);
    }

    public static void showInterFaceLister() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            System.out.println(">>>>>>>>> Show NetworkInterface <<<<<<<<<<");
            while (interfaces.hasMoreElements()) {
                NetworkInterface interf = interfaces.nextElement();
                System.out.println(interf.getName());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * 确定IP地址是IPv4还是IPv6
     */
    public static int getVersion(InetAddress ia) {
        byte[] address = ia.getAddress();
        if (address.length == 4) return 4;
        else if (address.length == 16) return 6;
        else return -1;
    }
}
