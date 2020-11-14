package controller;

import dao.UserDataAccessObject;
import model.User;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {ServletUrl.CHECK_EMAIL_SERVLET, "/auth" + ServletUrl.CHECK_EMAIL_SERVLET})
public class CheckEmailServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        User user = userDataAccessObject.getUser(email);

        if (user != null) {
            resp.setContentType("text/plain");
            resp.sendError(406, "Email already exists");
        } else {
            resp.getWriter().write(200);
        }
    }

}
