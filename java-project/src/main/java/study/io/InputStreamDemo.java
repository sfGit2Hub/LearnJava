package study.io;

import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class InputStreamDemo {
    private DataOutput dataOutput;
    private DataInputStream dataInputStream;
    private DigestInputStream digestInputStream;
    private MessageDigest messageDigest;
    private BufferedInputStream bufferedInputStream;
    private ByteArrayInputStream byteArrayInputStream;
    private InputStreamReader inputStreamReader;

    public static void bytesInputStream(InputStream in) throws IOException {
//        byte[] input = new byte[1024];
//        int bytesRead = in.read(input); //返回实际读取的字节数
//        System.out.println(bytesRead);
        int bytesRead = 0;
        int bytesToRead = 1024;
        byte[] input = new byte[bytesToRead];
        while (bytesRead < bytesToRead) {
            int result = in.read(input, bytesRead, bytesToRead-bytesRead);
            System.out.println("result: " + result);
            if (result == -1) break;    //流结束
            bytesRead += result;
        }
    }

    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("D:\\Project\\Redis\\redis.windows.conf");
//            byte[] input = new byte[1024];
//            fileIn.read(input);
//            FileOutputStream fileOut = new FileOutputStream("log/project.log");
//            fileOut.write(input);
            bytesInputStream(fileIn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
