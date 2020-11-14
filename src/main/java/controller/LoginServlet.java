package controller;

import dao.UserDataAccessObject;
import utils.Constants;
import utils.DomainUrl;
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

            HttpSession session = getSession(req);
            int loginAttempt = (Integer) session.getAttribute(Constants.LOGIN_ATTEMPT);
            if (loginAttempt >= 3) {
                int userId = userDao.getUserId(email);
                boolean deactivated = userDao.changeUserStatus(userId, false);
                if (deactivated) {
                    String errorMessage = ErrorType.getError(ErrorType.FAILED_ATTEMPT);
                    resp.sendRedirect("loginServlet?error=true&errorMessage="+errorMessage);
                }
            } else {
                session.setAttribute(Constants.LOGIN_ATTEMPT, ++loginAttempt);
            }

        } else {
            String errorMessage = ErrorType.getError(ErrorType.LOGIN_FAILED);
            resp.sendRedirect("loginServlet?error=true&errorMessage="+errorMessage);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
