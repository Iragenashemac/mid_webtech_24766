package controller;



import dao.BookDAO;
import dao.BorrowedBooksDAO;
import model.Book;
import model.User;
import model.BorrowedBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/borrowBook")
public class BorrowBookServlet extends HttpServlet {

    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the book ID from the form
        String bookIdStr = request.getParameter("bookId");
        
        if (bookIdStr != null && !bookIdStr.isEmpty()) {
            // Parse the book ID
            int bookId = Integer.parseInt(bookIdStr);

            // Get the current user session
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");  // Assume the user is stored in the session

            if (user != null) {
                // Fetch the book details from the database
                BookDAO bookDAO = new BookDAO();
                Book book = bookDAO.getBookById(bookId);

                if (book != null) {
                    // Check if the book is available for borrowing
                    if (book.getAvailability() > 0) {
                        // Borrow the book
                        BorrowedBooksDAO borrowedBooksDAO = new BorrowedBooksDAO();
                        BorrowedBook borrowedBook = new BorrowedBook();
                        borrowedBook.setUser(user);
                        borrowedBook.setBook(book);

                        // Add the borrowed book to the user's list of borrowed books
                        borrowedBooksDAO.save(borrowedBook);

                        // Update the book's availability
                        book.setAvailability(book.getAvailability() - 1);
                        bookDAO.updateBook(book);

                        // Redirect to the borrowed books page or show a confirmation
                        response.sendRedirect("studentDashboard.jsp?message=Book Borrowed Successfully");
                    } else {
                        // Handle case when the book is not available
                        request.setAttribute("errorMessage", "Book is not available.");
                        request.getRequestDispatcher("/borrowBook.jsp").forward(request, response);
                    }
                } else {
                    // Handle case when the book is not found
                    request.setAttribute("errorMessage", "Book not found.");
                    request.getRequestDispatcher("/borrowBook.jsp").forward(request, response);
                }
            } else {
                // Handle the case when the user is not logged in
                response.sendRedirect("login.jsp");
            }
        } else {
            // Handle case when no book ID is provided
            request.setAttribute("errorMessage", "Please provide a valid book ID.");
            request.getRequestDispatcher("/borrowBook.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the borrow book page if it's a GET request
        request.getRequestDispatcher("/borrowBook.jsp").forward(request, response);
    }
}
