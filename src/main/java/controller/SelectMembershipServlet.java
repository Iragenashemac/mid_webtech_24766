package controller;



import dao.MembershipDAO;
import model.Membership;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/selectMembership")
public class SelectMembershipServlet extends HttpServlet {

   
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the selected membership type from the form
        String membershipType = request.getParameter("membershipType");

        // Get the current user session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");  // Assume the user is stored in the session

        if (user != null) {
            // Fetch the membership details based on the selected membership type
            MembershipDAO membershipDAO = new MembershipDAO();
            Membership membership = membershipDAO.getMembershipByType(membershipType);

            if (membership != null) {
                // Assign the membership to the user
                user.setMembership(membership);
                // Update the user in the database (if necessary)
                membershipDAO.updateUserMembership(user);

                // Redirect to the Student Dashboard or a confirmation page
                response.sendRedirect("studentDashboard.jsp?message=Membership Selected Successfully");
            } else {
                // Handle the case when the membership type is invalid
                request.setAttribute("errorMessage", "Invalid membership type.");
                request.getRequestDispatcher("/selectMembership.jsp").forward(request, response);
            }
        } else {
            // Handle the case when the user is not logged in
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the membership selection page if it's a GET request
        request.getRequestDispatcher("/selectMembership.jsp").forward(request, response);
    }
}
