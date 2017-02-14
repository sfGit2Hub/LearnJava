package study.internet;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QueryString {
    private StringBuilder query = new StringBuilder();

    private synchronized QueryString add(String name, String value) {
        if (query.indexOf("&") != -1) {
            query.append("&");
        }
        try {
            query.append(URLEncoder.encode(name, "utf-8"))
                    .append("=")
                    .append(URLEncoder.encode(value, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    private synchronized String getQuery() {
        return query.toString();
    }

    @Override
    public String toString() {
        return this.getQuery();
    }
}
