package nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SF on 2016/11/23.
 */
public class BioDemo {
    public static void init() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            while (Thread.currentThread().isInterrupted()) {
                Socket socket = serverSocket.accept();
                executorService.submit(new ConnectIOnHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
