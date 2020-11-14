package controller;

import dao.UserDataAccessObject;
import model.Profile;
import model.User;
import utils.Constants;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = ServletUrl.PROFILE_SERVLET)
public class ProfileServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute(Constants.USER_EMAIL);
        UserDataAccessObject userDao = new UserDataAccessObject();
        User user = userDao.getUser(email);

        //Redirect to login when no attribute
        Profile profile = user.getProfile();
        session.setAttribute("profile", profile);
        resp.sendRedirect("profile.jsp");
    }
}
