package study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * 非阻塞的HTTP服务器，简单提供一个文件
 */
public class NonblockingSingleFileHttpServer {
    private static final Logger logger = Logger.getLogger(NonblockingSingleFileHttpServer.class.getSimpleName());

    private ByteBuffer contenBuffer;
    private int port;

    public NonblockingSingleFileHttpServer(
            ByteBuffer data, String encoding, String MIMEType, int port
    ) {
        this.port = port;
        String header = "HTTP/1.1 200 OK\r\n"
                + "Server: NonblockingSingleFileHTTPServer\r\n"
                + "Content-type: " + MIMEType + "\r\n"
                + "Content-length: " + data.limit() + "\r\n\r\n";
        byte[] headerData = header.getBytes(Charset.forName("US-ASCII"));

        ByteBuffer buffer = ByteBuffer.allocate(data.limit() + headerData.length);
        buffer.put(headerData);
        buffer.put(data);
        buffer.flip();
        this.contenBuffer = buffer;
    }

    public void run() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverChannel.socket();
        Selector selector = Selector.open();
        InetSocketAddress localPort = new InetSocketAddress(this.port);
        serverSocket.bind(localPort);
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel channel = server.accept();
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isWritable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        if (buffer.hasRemaining()) {
                            channel.write(buffer);
                        } else {
                            channel.close();
                        }
                    } else if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(4096);
                        channel.read(buffer);
                        key.interestOps(SelectionKey.OP_WRITE);
                        key.attach(this.contenBuffer.duplicate());
                    }
                } catch (IOException e) {
                    key.cancel();
                    key.channel().close();
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.info("Usage: java NonblockingSingleFileHttpServer file port encoding");
            return;
        }
        try {
            String contentType = URLConnection.getFileNameMap().getContentTypeFor(args[0]);
            Path file = FileSystems.getDefault().getPath(args[0]);
            byte[] data = Files.readAllBytes(file);
            ByteBuffer input = ByteBuffer.wrap(data);

            int port;
            try {
                port = Integer.parseInt(args[1]);
                if (port < 1 || port > 65535) port = 8080;
            } catch (RuntimeException e) {
                port = 8080;
            }
            String encoding = "UTF-8";
            if (args.length > 2) encoding = args[2];

            NonblockingSingleFileHttpServer server = new NonblockingSingleFileHttpServer(input, encoding, contentType, port);
            server.run();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
