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
        HttpSession session = req.getSession();

        int userId = (int) session.getAttribute(Constants.USER_ID);

        if (userId > 0) {
            List<Post> postList = postDao.getPosts(userId);
            session.setAttribute("posts", postList);
            resp.sendRedirect("posts.jsp");
        } else {
            //Remove after uncommenting the auth-filter
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("postDescription");
        String image = req.getParameter("postImage");
        HttpSession session = req.getSession();

        int likes = Integer.parseInt(req.getParameter("likes"));
        int userId = (int) session.getAttribute(Constants.USER_ID);

        PostDao postDao = new PostDao();
        Post post = new Post(image, description, likes, userId);
        boolean inserted = postDao.savePost(post);

        if (inserted) {
            resp.getWriter().write("Success");
        } else {
            resp.sendError(406, "Failed to post");
        }
    }
}
