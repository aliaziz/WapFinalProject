package controller.adminServlet;

import controller.BaseServlet;
import dao.PostDao;
import dao.UserDataAccessObject;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {ServletUrl.DASHBOARD_SERVLET, "/admin"+ServletUrl.DASHBOARD_SERVLET, "/auth"+ServletUrl.DASHBOARD_SERVLET})
public class DashboardServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDao postDao = new PostDao();
        UserDataAccessObject userDao = new UserDataAccessObject();

        int censoredPostsCount = postDao.getUnhealthyPostCount();
        int allPostsCount = postDao.getPostCount();
        int disabledUserCount = userDao.getDisabledUsers().size();

        HttpSession session = req.getSession();
        session.setAttribute("censoredPostsCount", censoredPostsCount);
        session.setAttribute("allPostsCount", allPostsCount);
        session.setAttribute("disabledUserCount", disabledUserCount);

        if (req.getRequestURI().contains("auth")) {
            resp.sendRedirect("../admin/admin_dashboard.jsp");
        } else resp.sendRedirect("admin_dashboard.jsp");
    }
}
