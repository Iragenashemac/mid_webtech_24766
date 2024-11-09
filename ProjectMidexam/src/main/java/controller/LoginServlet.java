package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDAO;
import model.User;
import util.PasswordUtil;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        // Retrieve the user by phone number
        User user = new UserDAO().findUserByPhoneNumber(phoneNumber);

        // Verify password and login
        if (user != null && PasswordUtil.verifyPassword(password, user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            // Redirecting based on role with success message
            request.getRequestDispatcher(user.getRole().toString().toLowerCase() + "Dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp?error=Invalid+credentials");
        }
    }
}
