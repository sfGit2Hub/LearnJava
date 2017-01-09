package study.io;

import java.io.*;

/**
 * Created by Administrator on 2017/1/5.
 */
public class ReaderAndWriter {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private StringReader stringReader;
    private StringWriter stringWriter;
    private CharArrayReader charArrayReader;
    private CharArrayWriter charArrayWriter;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    protected ReaderAndWriter(){}
    protected ReaderAndWriter(Object lock){}

    public void write(char[] text, int offset, int length) throws IOException{
        fileWriter.write(text, offset, length);
        stringWriter.write(text, offset, length);
        charArrayWriter.write(text, offset, length);
    }

    public void write(int c) throws IOException{
        fileWriter.write(c);
        stringWriter.write(c);
        charArrayWriter.write(c);
    }

    public void write(char[] text) throws IOException {
        fileWriter.write(text);
        stringWriter.write(text);
        charArrayWriter.write(text);
    }

    public void write(String s) throws IOException {
        fileWriter.write(s);
        stringWriter.write(s);
        charArrayWriter.write(s);
    }

    public void write(String s, int offset, int length) throws IOException {
        fileWriter.write(s, offset, length);
        stringWriter.write(s, offset, length);
        charArrayWriter.write(s, offset, length);
    }

    public void flush() throws IOException {
        fileWriter.flush();
        stringWriter.flush();
        charArrayWriter.flush();
    }

    public void close() throws IOException {
        fileWriter.close();
        stringWriter.close();
        charArrayWriter.close();
    }

    public void read() throws IOException {
        fileReader.read();
        stringReader.read();
        charArrayReader.read();
    }

    public int read(char[] text, int offset, int length) throws IOException {
        stringReader.read(text, offset, length);
        return fileReader.read(text, offset, length);
    }

    public int read(char[] text) throws IOException {
        return fileReader.read(text);
    }

    public static void main(String[] args) {
        ReaderAndWriter readerAndWriter = new ReaderAndWriter();
        try {
            readerAndWriter.fileReader = new FileReader(new File("log/project.log"));
            readerAndWriter.fileWriter = new FileWriter(new File("log/project_1.log"));
//            readerAndWriter.fileReader.skip(10);
            int read = readerAndWriter.fileReader.read();
            while ( read > 0) {
                readerAndWriter.fileWriter.write(read);
                read = readerAndWriter.fileReader.read();
                readerAndWriter.fileWriter.flush();
            }
            /*char[] text = new char[1024];
            while (readerAndWriter.fileReader.read(text) > 0) {
                readerAndWriter.fileWriter.write(text);
                readerAndWriter.fileWriter.flush();
            }*/
//            readerAndWriter.fileReader.getEncoding();

//            fileStreamDemo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                readerAndWriter.fileWriter.close();
                readerAndWriter.fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileStreamDemo() throws IOException{
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("E:\\迅雷下载\\电影\\冲天破.mkv"));
            fileOutputStream = new FileOutputStream(new File("E:\\迅雷下载\\电影\\冲天破_1.mkv"));
            byte[] tempBytes = new byte[1024];
            while (fileInputStream.read(tempBytes) > 0) {
                fileOutputStream.write(tempBytes);
                fileOutputStream.flush();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
