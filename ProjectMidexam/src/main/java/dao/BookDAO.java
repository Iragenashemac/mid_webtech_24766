package dao;



import model.Book;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class BookDAO {

    public Book getBookById(int bookId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book book = null;
        try {
            book = session.get(Book.class, bookId);
        } finally {
            session.close();
        }
        return book;
    }

    public void updateBook(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
