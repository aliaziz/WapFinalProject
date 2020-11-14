package controller;

import com.google.gson.Gson;
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

        Gson gson = new Gson();
        String jsonString = gson.toJson(commentList);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        String commentString = req.getParameter("comment");
        int userId = getSessionUserId(req);

        Comment comment = new Comment(postId, userId, commentString);
        CommentDao commentDao = new CommentDao();

        boolean inserted = commentDao.saveComment(comment);

        if (inserted) {
            resp.getWriter().write("Success");
        } else {
            resp.sendError(406, "Failed to save comment");
        }
    }
}