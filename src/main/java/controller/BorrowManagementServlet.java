package controller;

import service.BorrowService;
import dao.UserDAO;
import dao.BookDAO;
import model.Book;
import model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/BorrowManagementServlet")
public class BorrowManagementServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	private final BorrowService borrowService;
    private final UserDAO userDAO;
    private final BookDAO bookDAO;

    public BorrowManagementServlet() {
        this.borrowService = new BorrowService();
        this.userDAO = new UserDAO();
        this.bookDAO = new BookDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String userId = request.getParameter("userId");
        String bookId = request.getParameter("bookId");

        try {
            User user = userDAO.findUserById(userId);
            Book book = bookDAO.getBookById(Integer.parseInt(bookId));
            
            if ("borrow".equals(action)) {
                borrowService.borrowBook(user, book);
            } else if ("return".equals(action)) {
                borrowService.returnBook(user, book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("librarianDashboard.jsp");
    }
}
