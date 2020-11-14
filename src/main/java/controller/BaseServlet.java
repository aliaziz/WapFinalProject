package controller;

import dao.UserDataAccessObject;
import utils.Constants;
import utils.DomainUrl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BaseServlet extends HttpServlet {

    public void setSessionData(String email, int roleId, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDataAccessObject userDao = new UserDataAccessObject();
        int userId = userDao.getUserId(email);
        HttpSession session = req.getSession();
        session.setAttribute(Constants.USER_EMAIL, email);
        session.setAttribute(Constants.USER_ID, userId);
        session.setAttribute(Constants.IS_LOGGED_IN, true);

        if (roleId == 1) resp.sendRedirect(DomainUrl.HOME_URL);
        else resp.sendRedirect(DomainUrl.ADMIN_URL);
    }

    public void clearAttributes(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}
