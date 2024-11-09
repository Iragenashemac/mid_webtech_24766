package dao;



import model.BorrowedBook;
import util.HibernateUtil;

import org.hibernate.Session;

public class BorrowedBooksDAO {

    public void save(BorrowedBook borrowedBook) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(borrowedBook);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    
   }

    public List<BorrowedBook> getAllBorrowedBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<BorrowedBook> borrowedBooks = session.createQuery("FROM BorrowedBook WHERE returnDate IS NULL", BorrowedBook.class).list();
        session.close();
        return borrowedBooks;
    }







}



