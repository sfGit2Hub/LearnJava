package study.internet;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 每个虚拟机都只有一个 ProxySelector，要改变这个Selector，需要把新建的Selector传递到静态方法ProxySelector.setDefault();
 * ProxySelector.setDefault(localProxySelector);
 */
public class LocalProxySelector extends ProxySelector {
    private List<URI> fail = new ArrayList<>();
    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> result = new ArrayList<>();
        if (!fail.contains(uri) || !"http".equalsIgnoreCase(uri.getScheme())) {
            result.add(Proxy.NO_PROXY);
        } else {
            SocketAddress address = new InetSocketAddress("proxy.example.com", 8000);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
            result.add(proxy);
        }
        return result;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        fail.add(uri);
    }
}
