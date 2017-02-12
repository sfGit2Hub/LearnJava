package study.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 检查一个主机是否是垃圾邮件发送者
 */
public class SpamCheck {
    private static final String BLACKHOLE = "sbl.spamhaus.org";
    public static boolean isSpam(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet > 0 ? octet : octet + 256;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isSpam("207.34.56.23"));
    }
}
