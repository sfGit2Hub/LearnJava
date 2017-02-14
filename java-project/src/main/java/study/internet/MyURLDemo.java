package study.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Pattern;

public class MyURLDemo {

    public static boolean checkUrlFormat(String url) {
       Pattern pattern = Pattern.compile("^((https|http|ftp|rtsp|mms|mailto|telnet|file)?://)[\\w-\\.]+(?:/|(?:/[\\w\\.\\-]+)*(?:/[\\w\\.\\-]+))?$",
               Pattern.CASE_INSENSITIVE);
        return pattern.matcher(url).matches();
    }

    public static String testURLEncoder(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, "utf-8");
    }

    public static void main(String []args) {
        try {
//            URL url = new URL("file:///E:/Download/Java开发手册.pdf");
//            System.out.println(url.getContent());
            URL baiduUrl = new URL("https://www.baidu.com?name=aaa&id=9");
            System.out.println(baiduUrl.getQuery());
            try(InputStream inputStream = baiduUrl.openStream()) {
                int c;
                while ((c = inputStream.read()) != -1) {
                    //此处知道是文本，所以可以用write
                    //假如是图片或者二进制文件的话不能用write
                    System.out.write(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(testURLEncoder("This is url + encoder"));    //空格-> '+'      +号 -> '%2B'
            System.out.println(testURLEncoder("This is url + encoder + 中文"));
        } catch (MalformedURLException e) {
//            MalformedURLException 是IOException的子类
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
