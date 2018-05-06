package study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by SF on 2018/4/25.
 * learn from blog
 * http://www.jasongj.com/java/nio_reactor/
 */
public class MultiThreadNIOServer {
    private static final Logger logger = Logger.getLogger(MultiThreadNIOServer.class.getSimpleName());

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            if (selector.selectNow() < 0) {
                continue;
            }

            Set<SelectionKey> keys = selector.keys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel acceptServerChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = acceptServerChannel.accept();
                    socketChannel.configureBlocking(false);
                    logger.log(Level.ALL, "Accept request from {}", socketChannel.getRemoteAddress());

                    SelectionKey readKey = socketChannel.register(selector, SelectionKey.OP_READ);
                    readKey.attach(new ProcessorNIO());
                }
            }
        }
    }
}
