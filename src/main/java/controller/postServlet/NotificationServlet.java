package controller.postServlet;

import controller.BaseServlet;
import dao.NotificationDao;
import model.Notification;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user"+ ServletUrl.NOTIFICATION_SERVLET)
public class NotificationServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = getSessionUserId(req);
        NotificationDao notificationDao = new NotificationDao();
        List<Notification> list = notificationDao.getNotification(userId);
        String jsonString = gson.toJson(list);

        resp.setContentType("application/json");
        resp.getWriter().write(jsonString);
    }
}
