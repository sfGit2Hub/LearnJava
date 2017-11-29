package study.pattern;

/**
 * Created by SF on 2017/11/29.
 */
public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        // 过滤req.reqStr中的敏感词
        request.reqStr = request.reqStr.replace("敏感", "").replace("被就业", "就业");
        request.reqStr += "===SensitiveFilter";
        chain.doFilter(request, response);
        response.respStr += "===SensitiveFilter";
    }
}
