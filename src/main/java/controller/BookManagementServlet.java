package controller;

import dao.BookDAO;
import model.Book;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/BookManagementServlet")
public class BookManagementServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	private final BookDAO bookDAO = new BookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            // Retrieve book data from form and create a new Book object
            // Call bookDAO.save() to add the book to the database
        } else if ("update".equals(action)) {
            // Retrieve book data and update the Book object
            // Call bookDAO.updateBook() to update the book in the database
        } else if ("delete".equals(action)) {
            // Retrieve book ID and call bookDAO.deleteBook()
        }
        response.sendRedirect("librarianDashboard.jsp");
    }
}
