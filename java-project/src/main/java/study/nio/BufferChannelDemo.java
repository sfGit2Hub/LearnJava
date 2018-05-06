package study.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by SF on 2018/4/25.
 */
public class BufferChannelDemo {
    private static final String FILE_PATH = "log/hello.html";

    public static void printFile(String filePath) throws IOException {
        RandomAccessFile html = new RandomAccessFile(filePath, "rw");
        FileChannel fileChannel = html.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(256);
//        fileChannel ---> buffer
        int count = fileChannel.read(buffer);
        while (count != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            count = fileChannel.read(buffer);
//            fileChannel  <---  buffer
//            fileChannel.write(buffer);
        }
        html.close();
    }

    public static void printFileMultiBuffer(String filePath) throws IOException {
        RandomAccessFile html = new RandomAccessFile(filePath, "rw");
        FileChannel fileChannel = html.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(256);
        ByteBuffer buffer1 = ByteBuffer.allocate(256);
        ByteBuffer[] buffers = new ByteBuffer[]{buffer, buffer1};
//        fileChannel ---> buffer
        fileChannel.read(buffers);
        html.close();
    }

    public static void main(String[] args) throws IOException {
        printFile(FILE_PATH);
    }
}
