package filter;

import utils.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        Boolean isLogged = (Boolean) session.getAttribute(Constants.IS_LOGGED_IN);
        String loginJspUrl = "login.jsp";

        if (isLogged == null && !(request.getRequestURI().endsWith(loginJspUrl)
                || request.getRequestURI().endsWith(Constants.LOGIN_URL)
                || request.getRequestURI().endsWith(Constants.REGISTER_URL)
                || request.getRequestURI().contains("assets"))) {
            response.sendRedirect(loginJspUrl);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
