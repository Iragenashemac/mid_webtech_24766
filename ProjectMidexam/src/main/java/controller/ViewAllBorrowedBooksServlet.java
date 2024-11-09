package controller;



import dao.BorrowedBooksDAO;
import model.BorrowedBook;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewAllBorrowedBooks")
public class ViewAllBorrowedBooksServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BorrowedBooksDAO borrowedBooksDAO = new BorrowedBooksDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BorrowedBook> borrowedBooks = borrowedBooksDAO.getUnreturnedBooks();
        request.setAttribute("borrowedBooks", borrowedBooks);
        request.getRequestDispatcher("viewAllBorrowedBooks.jsp").forward(request, response);
    }
}
