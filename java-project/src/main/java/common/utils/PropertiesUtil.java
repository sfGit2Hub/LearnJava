package common.utils;

import java.io.*;
import java.net.URI;
import java.util.Properties;

/**
 * Created by Administrator on 2017/1/12.
 */
public class PropertiesUtil {
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("profile.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }

    public static boolean hasKey(String key) {
        return properties.stringPropertyNames().contains(key);
    }

    public static void store(String filePath, String key, String value) throws IOException {
        OutputStream fileOut = new FileOutputStream(filePath);
        properties.setProperty(key, value);
        properties.store(fileOut, "");
    }

    public static void copyProperties(String filePath) throws IOException {
        InputStream ins = PropertiesUtil.class.getClassLoader().getResourceAsStream("profile.properties");
        OutputStream outs = new FileOutputStream(filePath);
        int bytesRead = 0;
        byte[] temp = new byte[1024];
        while ((bytesRead = ins.read(temp, 0, 1024)) != -1) {
            outs.write(temp, 0, bytesRead);
        }
        outs.close();
        ins.close();
    }

    public static void main(String[] args) {
        System.out.println(String.format(getValue("hello"), "Li"));
        System.out.println(hasKey("hello"));
        try {
            copyProperties(System.getProperty("user.dir") + "/log/profile.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
