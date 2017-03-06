package study.internet.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Echo 服务器
 */
public class EchoServer {
    public static int DEFAULT_PORT = 7;

    public static void main(String[] args) {
        int port;
        try {
            port = Integer.valueOf(args[0]);
        } catch (RuntimeException e) {
            port = DEFAULT_PORT;
        }
        System.out.println("Listening for connecting on port " + port);

        ServerSocketChannel serverChnnel;
        Selector selector;
        try {
            serverChnnel = ServerSocketChannel.open();
            ServerSocket serverSocket = serverChnnel.socket();
            InetSocketAddress address = new InetSocketAddress(port);
            serverSocket.bind(address);
            serverChnnel.configureBlocking(false);
            selector = Selector.open();
            serverChnnel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            for (SelectionKey readyKey : readyKeys) {
                readyKeys.remove(readyKey);
                try {
                    if (readyKey.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) readyKey.channel();
                        SocketChannel client = server.accept();
                        System.out.println("Accepted connection from " + client);
                        client.configureBlocking(false);
                        SelectionKey clientKey = client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        clientKey.attach(buffer);
                    }

                    if (readyKey.isReadable()) {
                        SocketChannel client = (SocketChannel) readyKey.channel();
                        ByteBuffer output = (ByteBuffer) readyKey.attachment();
                        client.read(output);
                    }

                    if (readyKey.isWritable()) {
                        SocketChannel client = (SocketChannel) readyKey.channel();
                        ByteBuffer output = (ByteBuffer) readyKey.attachment();
                        output.flip();
                        client.write(output);
                        output.compact();
                    }

                }catch (IOException e) {
                    readyKey.cancel();
                    try {
                        readyKey.channel().close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
