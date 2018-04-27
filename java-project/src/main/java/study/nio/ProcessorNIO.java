package study.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SF on 2018/4/25.
 */
public class ProcessorNIO {
    private static final ExecutorService service = Executors.newFixedThreadPool(10);

    public void handle(SelectionKey selectionKey) {
        service.submit(() -> {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            try {
                int count = socketChannel.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
