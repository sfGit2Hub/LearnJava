package study.internet.ssl;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Arrays;

/**
 * 安全的服务器Socket，
 * 通过HTTPS访问
 * 通过SSL访问
 */
public class SecureServerSocket {
    public final static int PORT = 7000;
    public final static String algorithm = "SSL";

    public static void main(String [] args) {
        try {
            SSLServerSocket server = setupServer();

//            现在所有设置工作都已经完成了，可以集中进行实际通信了
            while (true) {
                try (
                        Socket connection = server.accept();
                        InputStream in = connection.getInputStream()){
                    int c;
                    while ((c = in.read()) != -1) {
                        System.out.write(c);
                    }
                }
            }
        } catch (NoSuchAlgorithmException
                | KeyManagementException
                | UnrecoverableKeyException
                | CertificateException
                | IOException
                | KeyStoreException e) {
            e.printStackTrace();
        }
    }

    private static SSLServerSocket setupServer() throws
            NoSuchAlgorithmException, KeyManagementException,
            UnrecoverableKeyException, CertificateException,
            IOException, KeyStoreException{
        SSLContext context = SSLContext.getInstance(algorithm);
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        KeyStore keyStore = KeyStore.getInstance("JKS");    //Oracle 默认密钥库类型

//            出于安全考虑，每个密钥库都必须要用口令短语加密
//            在从磁盘加载前必须提供这个口令，口令短语以char[] 数组形式存储，所以可以很快地从内存中擦除
//            而不是等待垃圾回收
        char[] password = "Aa123456".toCharArray();
        keyStore.load(new FileInputStream("mykey.keys"), password);
        keyManagerFactory.init(keyStore, password);
        context.init(keyManagerFactory.getKeyManagers(), null, null);

        Arrays.fill(password, '0');     //擦除口令
        SSLServerSocketFactory factory = context.getServerSocketFactory();
        SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(PORT);

//            增加匿名（未认证）密码组
        String[] supported = server.getSupportedCipherSuites();
        String[] anonCipherSuitesSupported = new String[supported.length];
        int numAnonCipherSuitesSupported = 0;
        for (int i = 0; i < supported.length; i++) {
            if (supported[i].indexOf("_anon_") > 0 ){
                anonCipherSuitesSupported[numAnonCipherSuitesSupported++] = supported[i];
            }
        }

        String[] oldEnabled = server.getEnabledCipherSuites();
        String[] newEnabled = new String[oldEnabled.length + numAnonCipherSuitesSupported];
        System.arraycopy(oldEnabled, 0, newEnabled, 0, oldEnabled.length);
        System.arraycopy(anonCipherSuitesSupported, 0, newEnabled, oldEnabled.length, numAnonCipherSuitesSupported);

        server.setEnabledCipherSuites(newEnabled);
        return server;
    }
}
