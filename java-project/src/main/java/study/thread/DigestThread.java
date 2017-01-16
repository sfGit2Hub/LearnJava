package study.thread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/1/16.
 */
public class DigestThread implements Runnable{
    private String filename;
    private DigestThreadCallback callback;

    public DigestThread(String filename, DigestThreadCallback callback) {
        this.filename = filename;
        this.callback = callback;
    }

    public void digest() {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream digestIn = new DigestInputStream(fileIn, sha);
            while (digestIn.read() != -1);
            digestIn.close();
            byte[] digest = sha.digest();
            callback.receiveDigest(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.digest();
    }
}
