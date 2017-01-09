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
            System.out.println(System.getProperty("user.dir"));
//            InputStream inputStream = InputStreamDemo.class.getClassLoader().getResourceAsStream("log4j2.xml");
            FileInputStream fileIn = new FileInputStream("selenium-java-2.53.0.zip");
            FileOutputStream fileOut = new FileOutputStream("log/project_1.zip");
            byte[] input = new byte[1024];
            while (fileIn.read(input)>0){
                fileOut.write(input);
                fileOut.flush();
            }
//            bytesInputStream(fileIn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
