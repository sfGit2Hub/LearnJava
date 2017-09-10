package study.webDriver;

import net.anthavio.phanbedder.Phanbedder;

import java.io.*;

/**
 * Created by SF on 2017/6/19.
 */
public class PhantomUtils {
    private static final File phantomJs = Phanbedder.unpack();

    public static String getUrlContent(String url) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String[] params = new String[]{"console.log('!!!!')"};
        Process process = runtime.exec(phantomJs.getAbsolutePath(), params);
        InputStream in = process.getInputStream();
        BufferedReader buf = new BufferedReader(new InputStreamReader(in));
        StringBuilder sbf = new StringBuilder();
        String tmp = "";
        while((tmp = buf.readLine())!=null){
            sbf.append(tmp);
        }
        //System.out.println(sbf.toString());
        return sbf.toString();
    }

    public static void main(String[] args) {
//        System.out.println(phantomJs.getAbsolutePath());
        try {
            System.out.println(getUrlContent(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
