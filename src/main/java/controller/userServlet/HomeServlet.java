package controller.userServlet;

import controller.BaseServlet;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {ServletUrl.HOME_SERVLET, "/auth"+ServletUrl.HOME_SERVLET, "/user"+ServletUrl.HOME_SERVLET})
public class HomeServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("auth")) resp.sendRedirect("../user/home.jsp");
        else resp.sendRedirect("home.jsp");

    }
}
