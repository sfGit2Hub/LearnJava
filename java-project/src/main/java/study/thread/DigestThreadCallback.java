package study.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * Created by Administrator on 2017/1/16.
 */
public class DigestThreadCallback {
    private byte[] digest;
    private String filename;

    public void calculateDigest() {
        DigestThread digestThread = new DigestThread(filename, this);
        Thread thread = new Thread(digestThread);
        thread.start();
    }

    public void receiveDigest(byte[] digest) {
        this.digest = digest;
        System.out.println(digest);
    }

    @Override
    public String toString() {
        String result = filename + ": ";
        if (digest != null) {
            result += DatatypeConverter.printHexBinary(digest);
        } else {
            result += "digest not available";
        }
        return result;
    }
}
