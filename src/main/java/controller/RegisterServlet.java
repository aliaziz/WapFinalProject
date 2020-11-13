package controller;

import com.google.gson.Gson;
import dao.UserDataAccessObject;
import model.User;
import model.UserStatus;
import utils.ErrorType;
import utils.ServletUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.AUTH;

@WebServlet(urlPatterns = {ServletUrl.REGISTER_SERVLET, "/"+AUTH+ServletUrl.REGISTER_SERVLET})
public class RegisterServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email =  req.getParameter("email");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String state = req.getParameter("state");
        String fullName = req.getParameter("fullname");
        String street = req.getParameter("street");
        String city =  req.getParameter("city");
        String gender =  req.getParameter("gender");
        String status = "ACTIVE";
        String zipCode = req.getParameter("zipcode");
        User user = new User(email, userName, password, state,
                fullName, street, city, gender, UserStatus.valueOf(status),
                Integer.parseInt(zipCode));

        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        boolean inserted = userDataAccessObject.saveUser(user);

        if (inserted) {
            setSessionData(user.getUserName(), req, resp);
        } else {
            String errorMessage = ErrorType.getError(ErrorType.REGISTER_FAILED);
            resp.sendRedirect("registerServlet?error=true&errorMessage="+errorMessage);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }
}
