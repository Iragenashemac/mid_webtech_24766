package controller;

import service.BorrowService;
import model.BorrowRecord;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/FineManagementServlet")
public class FineManagementServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	private final BorrowService borrowService;

    public FineManagementServlet() {
        this.borrowService = new BorrowService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BorrowRecord> overdueRecords = borrowService.getOverdueBorrowRecords();
        request.setAttribute("overdueRecords", overdueRecords);
        request.getRequestDispatcher("overdueFines.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        borrowService.applyAutomaticFines();
        response.sendRedirect("librarianDashboard.jsp");
    }
}
