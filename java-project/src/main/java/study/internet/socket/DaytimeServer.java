package study.internet.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 */
public class DaytimeServer {
    public final static int DEFAULT_PORT = 13;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(20);
        try (
                ServerSocket server = new ServerSocket(DEFAULT_PORT)
        ) {
            while (true) {
//                accept 没都会new 一个Socket
                try (Socket connect = server.accept()) {
                    pool.submit(new DayTimeTask(connect));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class DayTimeTask implements Callable<Void> {
        private Socket connect;

        DayTimeTask(Socket socket) {
            this.connect = socket;
        }

        @Override
        public Void call() throws Exception {
            Writer out = new OutputStreamWriter(this.connect.getOutputStream());
            Date now = new Date();
            out.write(now.toString() + "\r\n");
            out.flush();
            out.close();

            this.connect.close();
            return null;
        }
    }
}
