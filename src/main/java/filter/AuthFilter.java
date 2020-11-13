package filter;

import utils.Constants;
import utils.DomainUrl;
import utils.ServletUrl;

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
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();
//
//        Boolean isLogged = (Boolean) session.getAttribute(Constants.IS_LOGGED_IN);
//        String uri = request.getRequestURI();
//
//        if (isLogged == null && !(uri.endsWith(ServletUrl.LOGIN_SERVLET)
//                || uri.endsWith(ServletUrl.REGISTER_SERVLET)
//                || uri.contains(Constants.AUTH)
//                || uri.contains(Constants.ASSETS)
//                || uri.endsWith(ServletUrl.LOGOUT_SERVLET))) {
//            response.sendRedirect(DomainUrl.LOGIN_URL);
//        } else {
            filterChain.doFilter(servletRequest, servletResponse);
//        }
    }
}
