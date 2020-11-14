package controller;

import dao.PostDao;
import dao.UserDataAccessObject;
import model.Post;
import utils.Constants;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = ServletUrl.POST_SERVLET)
public class PostServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDao postDao = new PostDao();
        UserDataAccessObject userDao = new UserDataAccessObject();
        HttpSession session = req.getSession();

        String userEmail = (String) session.getAttribute(Constants.USER_EMAIL);
        int userId = userDao.getUserId(userEmail);

        if (userId > 0) {
            List<Post> postList = postDao.getPosts(userId);
            session.setAttribute("posts", postList);
            resp.sendRedirect("posts.jsp");
        } else {
            //Remove after uncommenting the auth-filter
        }

    }
}
