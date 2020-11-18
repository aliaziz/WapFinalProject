package controller.userServlet;

import controller.BaseServlet;
import dao.FollowDao;
import model.Suggestion;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user"+ ServletUrl.FOLLOW_SERVLET)
public class FollowServlet extends BaseServlet {
    private FollowDao followDao = new FollowDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = getSessionUserId(req);
        List<Suggestion> list = followDao.getSuggestions(userId);

        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(list));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = getSessionUserId(req);
        int followedUserId = Integer.parseInt(req.getParameter("followedUserId"));
        boolean followed = followDao.follow(userId, followedUserId);

        if (followed) {
            resp.getWriter().write("success");
        } else {
            resp.sendError(406);
        }
    }
}
