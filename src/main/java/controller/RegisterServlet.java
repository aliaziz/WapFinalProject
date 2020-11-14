package controller;

import com.google.gson.Gson;
import dao.UserDataAccessObject;
import model.User;
import utils.ErrorType;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import static utils.Constants.AUTH;

@WebServlet(urlPatterns = {ServletUrl.REGISTER_SERVLET, "/"+AUTH+ServletUrl.REGISTER_SERVLET})
public class RegisterServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String jsonString = req.getParameter("data");
        User user = gson.fromJson(jsonString, User.class);
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        boolean inserted = userDataAccessObject.saveUser(user);

        if (inserted) {
            setSessionData(user.getUserName(), req, resp);
        } else {
            resp.getWriter().write(ErrorType.getError(ErrorType.REGISTER_FAILED));
        }
    }
}
