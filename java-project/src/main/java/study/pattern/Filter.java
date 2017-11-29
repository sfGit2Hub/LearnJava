package study.pattern;

/**
 * Created by SF on 2017/11/29.
 * 责任链模式 接口
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);

    static void main(String[] main) {
        // 需要被过滤的语句
        String msg = "被就业了：），敏感信息，<script>";

        //创建Request、Response对象
        Request req = new Request();
        Response resp = new Response();
        req.reqStr = msg;
        resp.respStr = "response";

        //搞一个过滤链，链上有两个过滤器
        FilterChain chain = new FilterChain();
        chain.addFilter(new HtmlFilter())
                .addFilter(new SensitiveFilter());

        //开始过滤
        chain.doFilter(req, resp);

        System.out.println(req.reqStr);
        System.out.println(resp.respStr);
    }
}
