package controller;

import dao.UserDataAccessObject;
import utils.Constants;
import utils.ErrorType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.LOGIN_URL)
public class LoginServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("password");

        UserDataAccessObject userDao = new UserDataAccessObject();
        if (userDao.verifyUser(userName, userPassword)) {
            setSessionData(userName, req, resp);
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
