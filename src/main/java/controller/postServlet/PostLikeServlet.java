package controller.postServlet;

import controller.BaseServlet;
import dao.PostDao;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user"+ServletUrl.LIKE_SERVLET)
public class PostLikeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        boolean shouldLike = Boolean.parseBoolean(req.getParameter("should_like"));
        PostDao postDao = new PostDao();
        int userId = getSessionUserId(req);
        int likesCount = postDao.likeOrUnlikePost(shouldLike, postId, userId);

        String jsonString = gson.toJson(likesCount);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonString);

    }
}
