package controller;



import service.BorrowService;
import model.BorrowRecord;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewAllFinedBooks")
public class ViewAllFinedBooksServlet extends HttpServlet {

    
	private static final long serialVersionUID = 1L;
	private BorrowService borrowService = new BorrowService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BorrowRecord> finedBooks = borrowService.getFinedBooks();
        request.setAttribute("finedBooks", finedBooks);
        request.getRequestDispatcher("viewAllFinedBooks.jsp").forward(request, response);
    }
}
