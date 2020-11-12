package controller;

import com.google.gson.Gson;
import dao.UserDataAccessObject;
import model.User;
import utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String jsonString = req.getParameter("data");
        User user = gson.fromJson(jsonString, User.class);
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(user);
        boolean inserted = userDataAccessObject.saveUser();

        if (inserted) {
            HttpSession session = req.getSession();
            session.setAttribute(Constants.IS_LOGGED_IN, true);
            session.setAttribute(Constants.USERNAME, user.getUserName());
            resp.sendRedirect("home.jsp");
        } else {
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            writer.print("{ 'error': 'Failed to login' }");
            writer.flush();
        }
    }
}
