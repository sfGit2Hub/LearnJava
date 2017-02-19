package study.internet;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLConnectTest {
    private URL url;
    private URLConnection connection;

    public URLConnectTest(String url) throws IOException {
        this.url = new URL(url);
        this.connection = this.url.openConnection();
    }

    public String getWebPage() throws IOException {
        StringBuilder str = new StringBuilder();
        try (InputStream raw = this.connection.getInputStream()) {
            InputStream buffer = new BufferedInputStream(raw);
            Reader read = new InputStreamReader(buffer);
            int c;
            while ((c = read.read()) != -1) {
                str.append((char)c);
            }
            return str.toString();
        }
    }

    public Map<String, List<String>> getHeadFields() throws IOException {
        return this.connection.getHeaderFields();
    }

    public void saveBinaryFile() throws IOException {
        String type = this.connection.getContentType();
        int contentLength = this.connection.getContentLength();
        if (type.startsWith("text/") || contentLength == -1){
            throw new IOException("This is not a binary file!");
        }

        String filename = this.url.getFile();
        filename = filename.substring(filename.lastIndexOf("/") + 1);

        try(
                InputStream in = this.connection.getInputStream();
                FileOutputStream fileOut = new FileOutputStream(filename)
        ) {
            InputStream inBuf = new BufferedInputStream(in);
            byte[] data = new byte[contentLength];
            int offset = 0;
            while (offset < contentLength) {
                int bytesRead = inBuf.read(data, offset, data.length - offset);
                if (bytesRead == -1) break;
                offset += bytesRead;
            }

            if (offset != contentLength) {
                throw new IOException("Only read " + offset + " bytes; Expected " + contentLength + " bytes!");
            }

            fileOut.write(data);
            fileOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            URLConnectTest url = new URLConnectTest("http://www.baidu.com");
            URLConnectTest picUrl = new URLConnectTest("http://avatar.csdn.net/8/4/4/1_sf_cyl.jpg");
            System.out.println(url.getWebPage());
            Map<String, List<String>> headFields = url.getHeadFields();
            for (Map.Entry<String, List<String>> entry : headFields.entrySet()){
                final String[] value = {""};
                entry.getValue().forEach(temp -> value[0] += (temp + ";"));
                System.out.println(entry.getKey() + ":\t" + value[0]);
            }
            picUrl.saveBinaryFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
