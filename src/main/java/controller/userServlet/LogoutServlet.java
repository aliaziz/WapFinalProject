package controller.userServlet;

import controller.BaseServlet;
import utils.DomainUrl;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {ServletUrl.LOGOUT_SERVLET,
        "/user" + ServletUrl.LOGOUT_SERVLET,
        "/admin" + ServletUrl.LOGOUT_SERVLET,
        "/auth" + ServletUrl.LOGOUT_SERVLET,
        "/error-pages" + ServletUrl.LOGOUT_SERVLET})
public class LogoutServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clearAttributes(req);
        resp.sendRedirect("../" + DomainUrl.LOGIN_URL);
    }
}