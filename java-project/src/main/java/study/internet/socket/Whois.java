package study.internet.socket;

import java.io.*;
import java.net.*;

/**
 * 简单的 Whois 协议类
 */
public class Whois {
    public final static int DEFAULT_PORT = 43;
    public final static String DEFAULT_HOST = "whois.internic.net";

    private int port = DEFAULT_PORT;
    private InetAddress host;

    public Whois(InetAddress host, int port) {
        this.port = port;
        this.host = host;
    }

    public Whois(InetAddress host) {
        this(host, DEFAULT_PORT);
    }

    public Whois(String hostname, int port) throws UnknownHostException {
        this(InetAddress.getByName(hostname), port);
    }

    public Whois(String hostname) throws UnknownHostException {
        this(hostname, DEFAULT_PORT);
    }

    public Whois() throws UnknownHostException {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public enum SearchFor {
//        搜索条目
        ANY("Any"),
        NETWORK("Network"),
        PERSON("Person"),
        HOST("Host"),
        DOMAIN("Domain"),
        ORGANIZATION("Organization"),
        GROUP("Group"),
        GATEWAY("Gateway"),
        ASN("ASN");

        private String label;

        private SearchFor(String label) {
            this.label = label;
        }
    }

    public enum SearchIn {
//        搜索的类别
        ALL(""),
        NAME("Name"),
        MAILBOX("Mailbox"),
        HANDLE("!");

        private String label;

        private SearchIn(String label) {
            this.label = label;
        }
    }

    public String lookUpNames(String target, SearchFor category, SearchIn group, boolean exactMatch) {
        String suffix = "";
        if (!exactMatch) {
            suffix = ".";
        }

        String prefix = category.label + " " + group.label;
        String query = prefix + target + suffix;

        try (Socket socket = new Socket()){
            SocketAddress address = new InetSocketAddress(this.host, this.port);
            socket.connect(address);
            Writer writer = new OutputStreamWriter(socket.getOutputStream(), "ASCII");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), "ASCII")
            );
            writer.write(query + "\r\n");
            writer.flush();

            StringBuilder response = new StringBuilder();
            String theLine = null;
            while ((theLine = in.readLine()) != null) {
                response.append(theLine);
                response.append("\r\n");
            }
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public InetAddress getHost() {
        return this.host;
    }

    public Whois setHost(String host) throws UnknownHostException {
        this.host = InetAddress.getByName(host);
        return this;
    }
}
