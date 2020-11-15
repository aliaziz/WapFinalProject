package controller;

import com.google.gson.Gson;
import dao.UserDataAccessObject;
import utils.Constants;
import utils.DomainUrl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BaseServlet extends HttpServlet {

    public static Gson gson = new Gson();
    public void setSessionData(String email, int roleId, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDataAccessObject userDao = new UserDataAccessObject();
        int userId = userDao.getUserId(email);
        HttpSession session = getSession(req);
        session.setAttribute(Constants.USER_EMAIL, email);
        session.setAttribute(Constants.USER_ID, userId);
        session.setAttribute(Constants.IS_LOGGED_IN, true);

        if (roleId == 1) resp.sendRedirect(DomainUrl.HOME_URL);
        else resp.sendRedirect(DomainUrl.ADMIN_URL);
    }

    public int getSessionUserId(HttpServletRequest request) {
        return (int) getSession(request).getAttribute(Constants.USER_ID);
    }

    public boolean isLoggedIn(HttpServletRequest request) {
        return (boolean) getSession(request).getAttribute(Constants.IS_LOGGED_IN);
    }

    public HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    public void clearAttributes(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}
