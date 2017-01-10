package study.io;

import java.io.*;
import java.util.Properties;

/**
 * Created by SF on 2016/12/30.
 */
public class PropertyFileUtils {
    //属性文件的路径
    static String source ="E:\\workspace\\dhplatform-kafka\\dhplatform-email-sender\\src\\main\\resources\\i18n\\email_";
    final static String[] language = {"en_GB", "en_US", "de_DE", "es_ES", "fr_FR", "in_ID", "it_IT", "ja_JP", "ko_KR", "pt_PT", "th_TH", "vi_VN", "zh_CN"};
    final static String suffix = ".properties";
    static String target = "E:\\workspace\\dhp\\dsone\\dsone\\dsone-engine\\src\\main\\resources\\i18n\\email_dsone_";

    /**
     * 采用静态方法
     */
    private static Properties sourceProperties = new Properties();
    private static Properties targetProperties = new Properties();


    public static void main(String []args) {
        for (String temp: language) {
            String sourceTemp = source + temp + suffix;
            String targetTemp = target + temp + suffix;
            try {
                sourceProperties.load(new FileInputStream(sourceTemp));
                targetProperties.load(new FileInputStream(targetTemp));
            } catch (IOException e) {
                e.printStackTrace();
            }
            sourceProperties.stringPropertyNames().forEach(key -> {
                String targetValue = targetProperties.getProperty(key);
                if (targetValue != null) {
                    updateProperties(sourceProperties, sourceTemp, key, targetValue);
                }
            });
        }
    }



    /**
     * 根据主键key读取主键的值value
     * @param filePath 属性文件路径
     * @param key 键名
     */
    public static String readValue(String filePath, String key) {
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(
                    filePath));
            props.load(in);
            String value = props.getProperty(key);
            System.out.println(key +"键的值是："+ value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 更新properties文件的键值对
     * 如果该主键已经存在，更新该主键的值；
     * 如果该主键不存在，则插件一对键值。
     * @param keyname 键名
     * @param keyvalue 键值
     */
    public static void updateProperties(Properties props, String profilepath, String keyname,String keyvalue) {
        try {
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(profilepath);
            props.setProperty(keyname, keyvalue);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.store(fos, "Update '" + keyname + "' value");
        } catch (IOException e) {
            System.err.println("属性文件更新错误");
        }
    }
}
