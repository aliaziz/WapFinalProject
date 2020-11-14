package controller;

import dao.CommentDao;
import model.Comment;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = ServletUrl.COMMENT_SERVLET)
public class CommentServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postId = req.getParameter("postId");
        CommentDao commentDao = new CommentDao();
        List<Comment> commentList = commentDao.getComments(Integer.parseInt(postId));
        req.setAttribute("comments", commentList);
        req.getRequestDispatcher("comments.jsp").forward(req, resp);
    }
}
