package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import org.hibernate.query.Query;

public class UserDAO {

    // Method to save the User (sign up)
    public void signUp(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);  // Save the user object into the database
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Method to find a User by phone number (for login)
    public User findUserByPhoneNumber(String phoneNumber) {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE phoneNumber = :phoneNumber", User.class);
            query.setParameter("phoneNumber", phoneNumber);
            user = query.uniqueResult();  // Retrieve the user or null if not found
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Method to find a User by username (for checking if the username exists)
    public User findUserByUsername(String username) {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
            query.setParameter("username", username);
            user = query.uniqueResult();  // Retrieve the user or null if not found
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
