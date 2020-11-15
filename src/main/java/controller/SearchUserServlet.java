package controller;

import com.google.gson.Gson;
import dao.UserDataAccessObject;
import model.User;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = ServletUrl.SEARCH_USER_SERVLET)
public class SearchUserServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        UserDataAccessObject userDao = new UserDataAccessObject();
        List<User> userList = userDao.searchUser(query);

        resp.setContentType("application/json");
        Gson gson = new Gson();
        String jsonString = gson.toJson(userList);
        resp.getWriter().write(jsonString);
    }
}
