package study.pattern;

/**
 * Created by SF on 2017/11/29.
 */
public class HtmlFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //过滤req.reqStr中的HTML标记
        request.reqStr = request.reqStr.replace("<", "&lt;").replace(">", "&gt;");
        request.reqStr += "---HtmlFilter()---";
        chain.doFilter(request, response);
        response.respStr += "---HtmlFilter()---";
    }
}
