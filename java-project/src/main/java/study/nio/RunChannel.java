package study.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * Created by SF on 2016/11/23.
 */
public class RunChannel {
    private Channel fileChannel;
    private Channel datagramChannel;
    private Channel socketChannel;
    private Channel serverSocketChannel;

    public static void channelDemo_1() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\DT287\\Desktop\\email_html.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int byteBuffer = fileChannel.read(buffer);
        while (byteBuffer != -1) {
//            System.out.println("Read: " + byteBuffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                String str = String.valueOf((char) buffer.get());
                System.out.print(str);
            }

            buffer.clear();
            byteBuffer = fileChannel.read(buffer);
        }
        fileChannel.close();

    }
    public static void main(String[] args) {
        try {
            channelDemo_1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
