package study.internet.cache;

import org.jboss.netty.util.internal.ConcurrentHashMap;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Map;

/**
 * 存储在内存中的 URI 缓存头信息
 */
public class MemoryCache extends ResponseCache{
    private final Map<URI, SimpleCacheResponse> responses = new ConcurrentHashMap<>();
    private final int maxEntries;

    public MemoryCache() {
        this(100);
    }

    public MemoryCache(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    @Override
    public CacheResponse get(URI uri, String requestMethod, Map<String, List<String>> requestHeaders) throws IOException {
        if ("GET".equals(requestMethod)) {
            SimpleCacheResponse response = this.responses.get(uri);
            if (response != null && response.isExpiried()) {
//                过期之后在缓存中删除
                responses.remove(uri);
                response = null;
            }
            return response;
        }
        return null;
    }

    @Override
    public CacheRequest put(URI uri, URLConnection conn) throws IOException {
        CacheControl control = new CacheControl(conn.getHeaderField("Cache-Control"));
        if (control.isNoCache() || control.isNoStore()) {
            return null;
        } else if (!conn.getHeaderField(0).startsWith("GET")) {
//            只缓存GET方法
            return null;
        }
        SimpleCacheRequest request = new SimpleCacheRequest();
        SimpleCacheResponse response = new SimpleCacheResponse(request, conn, control);
        this.responses.put(uri, response);
        return request;
    }
}
