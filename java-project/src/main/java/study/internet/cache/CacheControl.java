package study.internet.cache;

import java.util.Date;
import java.util.Locale;

/**
 * 如何检查 Cache-Control 首部
 */
public class CacheControl {
    private Date maxAge = null;
    private Date sMaxAge = null;
    private boolean mustRevalidate = false;
    private boolean noCache = false;
    private boolean noStore = false;
    private boolean proxyRevalidate = false;
    private boolean publicCache = false;
    private boolean privateCache = false;

    public CacheControl(String s) {
        if (s == null || !s.startsWith(":")) {
//            默认策略
            return;
        }
        String value = s.split(":")[1].trim();
        String[] components = value.split(",");
        Date now = new Date();
        for (String component : components) {
            component = component.trim().toLowerCase(Locale.US);
            if (component.startsWith("max-age=")) {
                int secondsInTheFuture = Integer.valueOf(component.substring(8));
                this.maxAge = new Date(now.getTime() + 1000*secondsInTheFuture);
            } else if (component.startsWith("s-maxage=")) {
                int secondsInTheFuture = Integer.valueOf(component.substring(8));
                this.sMaxAge = new Date(now.getTime() + 1000*secondsInTheFuture);
            } else if (component.startsWith("must-revalidate")) {
                this.mustRevalidate = true;
            } else if (component.startsWith("proxy-revalidate")) {
                this.proxyRevalidate = true;
            } else if (component.startsWith("public")) {
                this.publicCache = true;
            } else if (component.startsWith("no-cache")) {
                this.noCache = true;
            } else if (component.startsWith("private")) {
                this.privateCache = true;
            }
        }
    }

    public Date getMaxAge() {
        return maxAge;
    }

    public Date getsMaxAge() {
        return sMaxAge;
    }

    public boolean isMustRevalidate() {
        return mustRevalidate;
    }

    public boolean isNoCache() {
        return noCache;
    }

    public boolean isNoStore() {
        return noStore;
    }

    public boolean isProxyRevalidate() {
        return proxyRevalidate;
    }

    public boolean isPublicCache() {
        return publicCache;
    }

    public boolean isPrivateCache() {
        return privateCache;
    }
}
