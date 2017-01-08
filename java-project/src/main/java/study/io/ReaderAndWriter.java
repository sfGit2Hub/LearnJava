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
    private BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
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


}
