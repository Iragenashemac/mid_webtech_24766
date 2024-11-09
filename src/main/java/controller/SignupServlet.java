package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import model.User;
import model.Role;
import model.Gender;
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;
import java.util.UUID;

import model.Location;
import service.LocationService;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            response.sendRedirect("signup.jsp?error=Passwords+do+not+match");
            return;
        }

        if (firstName == null || firstName.trim().isEmpty() ||
            lastName == null || lastName.trim().isEmpty() ||
            phoneNumber == null || phoneNumber.trim().isEmpty() ||
            username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            response.sendRedirect("signup.jsp?error=All+fields+are+required");
            return;
        }

        // Hash password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        Gender gender = Gender.valueOf(request.getParameter("gender").toUpperCase());
        Role role = Role.valueOf(request.getParameter("role").toUpperCase());

        LocationService locationService = new LocationService();
        Location location = null;
        String locationInput = request.getParameter("location");

        // Check if location is an ID or name and retrieve the Location accordingly
        if (locationInput != null) {
            // Try to fetch the village ID by name
            UUID villageId = locationService.getVillageIdByName(locationInput);
            if (villageId != null) {
                location = new Location();  // Assuming you have a Location constructor or set locationId directly
                location.setLocationId(villageId);  // Set the UUID instead of String
            } else {
                response.sendRedirect("signup.jsp?error=Location+not+found");
                return;
            }
        }

        // Check if user already exists
        UserDAO userDAO = new UserDAO();
        User existingUser = userDAO.findUserByPhoneNumber(phoneNumber);
        if (existingUser != null) {
            response.sendRedirect("signup.jsp?error=Phone+number+already+exists");
            return;
        }

        existingUser = userDAO.findUserByUsername(username);
        if (existingUser != null) {
            response.sendRedirect("signup.jsp?error=Username+already+exists");
            return;
        }

        // Create new User
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setUsername(username);
        newUser.setPassword(hashedPassword);
        newUser.setGender(gender);
        newUser.setRole(role);
        newUser.setVillage(location);

        try {
            userDAO.signUp(newUser);  // Save user to the database
        } catch (Exception e) {
            e.printStackTrace();  // Log the error
            response.sendRedirect("signup.jsp?error=Signup+failed+due+to+server+error");
            return;
        }

        // Redirect to a success page
        request.setAttribute("message", "Signup successful! Please log in.");
        request.getRequestDispatcher("/signup-success.jsp").forward(request, response);
    }
}
