package controller.adminServlet;

import controller.BaseServlet;
import dao.UserDataAccessObject;
import model.User;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static utils.Constants.AUTH;

@WebServlet(urlPatterns = {ServletUrl.DISABLED_USER_SERVLET, "/"+AUTH + ServletUrl.DISABLED_USER_SERVLET, "/admin"+ServletUrl.DISABLED_USER_SERVLET})
public class DisabledUserServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDataAccessObject userDao = new UserDataAccessObject();
        List<User> userList = userDao.getDisabledUsers();
        req.getSession().setAttribute("userList", userList);

        resp.sendRedirect("deactivatedUsers.jsp");
    }
}
