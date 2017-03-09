package study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 一个基于通道的 chargen 客户端
 */
public class ChargenClient {
    public static int DEFAULT_PORT = 19;
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java ChargenClient host [port]");
            return;
        }

        int port = 0;
        try {
            Integer.valueOf(args[1]);
        } catch (RuntimeException e) {
            e.printStackTrace();
            port = DEFAULT_PORT;
        }

        try {
            SocketAddress address = new InetSocketAddress(args[0], port);
            SocketChannel channel = SocketChannel.open(address);

            ByteBuffer buffer = ByteBuffer.allocate(74);
            WritableByteChannel out = Channels.newChannel(System.out);

//            while (channel.read(buffer) != -1) {
//                buffer.flip();
//                out.write(buffer);
//                buffer.clear();
//            }
            while (true) {
//                在非阻塞模式下，read() 可能因为读不到任何数据而返回0
                int n = channel.read(buffer);
                if (n > 0) {
                    buffer.flip();
                    out.write(buffer);
                    buffer.clear();
                }  else if (n == -1) {
//                    这不应该发生，除非服务器故障
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
