package controller;

import dao.UserDataAccessObject;
import utils.Constants;
import utils.ErrorType;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utils.Constants.AUTH;

@WebServlet(urlPatterns = {ServletUrl.LOGIN_SERVLET, "/"+AUTH+ServletUrl.LOGIN_SERVLET})
public class LoginServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String userPassword = req.getParameter("password");

        UserDataAccessObject userDao = new UserDataAccessObject();
        int roleId = userDao.verifyUser(email, userPassword);
        if (roleId > 0) {
            setSessionData(email, roleId, req, resp);
        } else if(roleId == -1) {
            handleLoginAttempt(req, resp, email, userDao);
        } else {
            errorRedirect(resp, ErrorType.LOGIN_FAILED);
        }
    }

    private void handleLoginAttempt(HttpServletRequest req, HttpServletResponse resp, String email, UserDataAccessObject userDao) throws IOException {
        HttpSession session = getSession(req);
        int loginAttempt = session.getAttribute(Constants.LOGIN_ATTEMPT) == null ?
                0 : (Integer)session.getAttribute(Constants.LOGIN_ATTEMPT);
        if (loginAttempt >= 3) {
            int userId = userDao.getUserId(email);
            boolean deactivated = userDao.deactivateUser(userId);
            if (deactivated) {
                errorRedirect(resp, ErrorType.ACCOUNT_BLOCKED_ERROR);
            }
        } else {
            session.setAttribute(Constants.LOGIN_ATTEMPT, ++loginAttempt);
            errorRedirect(resp, ErrorType.LOGIN_FAILED);
        }
    }

    private void errorRedirect(HttpServletResponse resp, ErrorType errorType) throws IOException {
        String errorMessage = ErrorType.getError(errorType);
        resp.sendRedirect("loginServlet?error=true&errorMessage="+errorMessage);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
