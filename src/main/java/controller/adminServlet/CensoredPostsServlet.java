package controller.adminServlet;

import controller.BaseServlet;
import dao.PostDao;
import model.Post;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {ServletUrl.CENSORED_POST_SERVLET, "/admin" + ServletUrl.CENSORED_POST_SERVLET})
public class CensoredPostsServlet extends BaseServlet {
    private final PostDao postDao = new PostDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> postList = postDao.getUnhealthyPost();
        req.getSession().setAttribute("unhealthyPost", postList);

        resp.sendRedirect("censoredPosts.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        if(postDao.deleteUnhealthyPost(postId)) resp.getWriter().write("success");
        else resp.getWriter().write("failed");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        if(postDao.liveUnhealthyPost(postId)) resp.getWriter().write("success");
        else resp.getWriter().write("failed");
    }
}
