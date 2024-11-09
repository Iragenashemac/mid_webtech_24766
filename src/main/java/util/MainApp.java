package util;


import org.hibernate.Session;

import util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // Test entity saving if needed
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}