package study.internet.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 一个基于网络的 英语-拉丁语翻译程序
 */
public class DictClient {
    public static final String SERVER = "dict.org";
    public static final int PORT = 2628;
    public static final int TIMEOUT = 15000;

    static void define(String word, Writer writer, BufferedReader reader) throws IOException {
        writer.write("DEFINE eng-lat " + word + "\r\n");
        writer.flush();

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.startsWith("250 ")) {    //OK
                return;
            } else if (line.startsWith("552 ")) {
                System.out.println("No definition found for " + word);
                return;
            } else if (line.matches("\\d\\d\\d .*"))
                continue;
            else if (line.trim().equals("."))
                continue;
            else
                System.out.println(line);
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER, PORT)){
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            for (String word : args) {
                define(word, writer, reader);
            }

            writer.write("quit\r\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
