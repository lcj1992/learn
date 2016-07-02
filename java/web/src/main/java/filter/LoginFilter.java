package filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author chuangjian.li
 * @date 16-1-9
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Cookie[] cookies = ((HttpServletRequest) req).getCookies();
        cookies[0].setHttpOnly(true);
        HttpSession session = ((HttpServletRequest) req).getSession();

        System.out.println("filter");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
