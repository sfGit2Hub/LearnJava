package study.internet.dns;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import java.util.Properties;

/**
 * Created by chengyc on 2017/6/19.
 */
public class DNSUtil {

    private static Properties env;
    private static final String CNAME_ATTRIB = "CNAME";
    private static String[] CNAME_ATTRIBS = {CNAME_ATTRIB};

    static {
        env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
    }

    public static String getCNAME(String host) {
        try {
            return getCNAME(new InitialDirContext(env), host);
        } catch (NamingException e) {
            return "";
        }
    }

    private static String getCNAME(InitialDirContext idc, String host) throws NamingException {
        String cname = host;
        Attributes attrs = idc.getAttributes(host, CNAME_ATTRIBS);
        Attribute attr = attrs.get(CNAME_ATTRIB);

        if (attr != null) {
            int count = attr.size();
            if (count == 1) {
                cname = getCNAME(idc, (String) attr.get(0));
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    sb.append("-> " + attr.get(i) + "\n");
                }

                throw new NamingException("Unexpected count while looking for CNAME of " + host + ". Expected 1. Got " + count + ".\n"
                        + sb.toString());
            }
        }

        return cname;
    }

    public static boolean checkDNSRelation(String targetCname, String domain){
        String cname = getCNAME(domain);
        if (cname != null && cname.length() > 1 &&
                ".".equals(cname.substring(cname.length() - 1))) {
            cname = cname.substring(0, cname.length() - 1);
        }
        if (targetCname.equalsIgnoreCase(cname)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkDNSRelation("test.cname.baidu", "myhotel.dsonehotel.com"));
    }
}
