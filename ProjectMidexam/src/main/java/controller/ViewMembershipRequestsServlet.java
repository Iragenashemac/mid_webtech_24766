package controller;



import dao.MembershipDAO;
import model.Membership;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewMembershipRequests")
public class ViewMembershipRequestsServlet extends HttpServlet {

   
	private static final long serialVersionUID = 1L;
	private MembershipDAO membershipDAO = new MembershipDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Membership> pendingRequests = membershipDAO.getPendingMembershipRequests();
        request.setAttribute("pendingRequests", pendingRequests);
        request.getRequestDispatcher("viewMembershipRequests.jsp").forward(request, response);
    }
}
