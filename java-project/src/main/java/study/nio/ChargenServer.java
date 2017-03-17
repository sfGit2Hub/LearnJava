package study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * 一个非阻塞的chargen服务器
 */
public class ChargenServer {
    private static final Logger logger = Logger.getLogger(ChargenServer.class.getSimpleName());
    public static int DEFAULT_PORT = 19;

    public static void main(String[] args) {
        int port;
        try {
            port = Integer.valueOf(args[0]);
        } catch (RuntimeException e) {
            port = DEFAULT_PORT;
        }
        logger.info("Listening for connections on port: " + port);

        byte[] rotation = new byte[95 * 2];
        for (byte i = ' '; i <= '~'; i++) {
            rotation[i - ' '] = i;
            rotation[i + 95 - ' '] = i;
        }

        try (ServerSocketChannel serverChannel = ServerSocketChannel.open();
             ServerSocket ss = serverChannel.socket();
             Selector selector = Selector.open()
        ) {
            InetSocketAddress address = new InetSocketAddress(port);
            ss.bind(address);
            serverChannel.configureBlocking(false);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();

                Set<SelectionKey> readyKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = readyKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    try {
                        if (key.isAcceptable()) {
                            ServerSocketChannel server = (ServerSocketChannel) key.channel();
                            SocketChannel client = server.accept();
                            logger.info("Accepted connection from " + client);
                            client.configureBlocking(false);
                            SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);
                            ByteBuffer buffer = ByteBuffer.allocate(74);
                            buffer.put(rotation, 0, 72);
                            buffer.put((byte) '\r');
                            buffer.put((byte) '\n');
                            buffer.flip();
                            key2.attach(buffer);
                        } else if (key.isWritable()) {
                            SocketChannel client = (SocketChannel) key.channel();
                            ByteBuffer buffer = (ByteBuffer) key.attachment();
                            if (!buffer.hasRemaining()) {
                                buffer.rewind();    //用下一行重新填充缓冲区
                                int first = buffer.get();   //得到上一次的首字符
                                buffer.rewind();
                                int position = first - ' ' + 1;     //寻找rotation中新的首字符的位置
                                buffer.put(rotation, position, 72); //将数据从rotation复制到缓冲区
                                buffer.put((byte) '\r');    //在缓冲区末尾填充一个行分隔符
                                buffer.put((byte) '\n');
                                buffer.flip();      //准备缓冲区进行写入
                            }
                            client.write(buffer);
                        }
                    }catch (IOException e) {
                        key.cancel();
                        key.channel().close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


    }
}
