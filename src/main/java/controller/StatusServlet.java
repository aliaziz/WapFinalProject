package controller;

import dao.UserDataAccessObject;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = ServletUrl.STATUS_SERVLET)
public class StatusServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean status = Boolean.parseBoolean(req.getParameter("activate"));
        int userId = getSessionUserId(req);

        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        boolean inserted = userDataAccessObject.changeUserStatus(userId, status);

        if (inserted) {
            resp.getWriter().write("success");
        } else {
            resp.sendError(406);
        }
    }
}
