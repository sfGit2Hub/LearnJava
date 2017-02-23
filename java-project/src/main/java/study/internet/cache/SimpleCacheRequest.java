package study.internet.cache;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

/**
 * CacheRequest的一个具体子类
 * CacheRequest 是一个抽象类
 */
public class SimpleCacheRequest extends CacheRequest{
    ByteArrayOutputStream outCache = new ByteArrayOutputStream();
    @Override
    public OutputStream getBody() throws IOException {
        return outCache;
    }

    @Override
    public void abort() {
        this.outCache.reset();
    }

    public byte[] getData() {
        return outCache.size() == 0 ? null : outCache.toByteArray();
    }
}
