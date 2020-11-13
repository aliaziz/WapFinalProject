package controller;

import utils.Constants;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BaseServlet extends HttpServlet {

    public void setSessionData(String userName, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.setAttribute(Constants.USERNAME, userName);
        session.setAttribute(Constants.IS_LOGGED_IN, true);
        resp.sendRedirect("home.jsp");
    }

    public void clearAttributes(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}
