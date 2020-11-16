package controller.userServlet;

import controller.BaseServlet;
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

@WebServlet(urlPatterns = {ServletUrl.PROFILE_SERVLET,
        "/admin" + ServletUrl.PROFILE_SERVLET,
        "/auth" + ServletUrl.PROFILE_SERVLET,
        "/user" + ServletUrl.PROFILE_SERVLET})
public class ProfileServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute(Constants.USER_EMAIL);
        UserDataAccessObject userDao = new UserDataAccessObject();
        User user = userDao.getUser(email);

        Profile profile = user.getProfile();
        session.setAttribute("profile", profile);
        if (user.getRoleId() == 1) resp.sendRedirect("profile.jsp");
        else resp.sendRedirect("adminProf.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        String state = req.getParameter("state");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        int zipCode = Integer.parseInt(req.getParameter("zipCode"));

        Profile profile = new Profile(userName, gender, email,
                fullName, state, city, street, zipCode);
        UserDataAccessObject userDao = new UserDataAccessObject();
        boolean isUpdated = userDao.updateProfile(profile);

        resp.setContentType("text/plain");
        if (isUpdated) {
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("failed");
        }
    }
}
