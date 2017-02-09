package study.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

//        SecurityManager securityManager = new SecurityManager();
//        securityManager.checkConnect("www.baidu.com", -1);
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
