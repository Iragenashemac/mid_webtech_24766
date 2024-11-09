package util;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;

    static {
        try {
            // Create a configuration instance
            Configuration configuration = new Configuration();

            // Manually configure Hibernate properties
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/auca_library_db");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "shemac");

            // Hibernate settings
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update"); // Set to 'update' to update the schema
            configuration.setProperty("hibernate.show_sql", "true"); // Enable SQL logging for debugging
            configuration.setProperty("hibernate.format_sql", "true"); // Format the SQL for better readability

            // Register the entity classes manually
            configuration.addAnnotatedClass(Location.class);
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(MembershipType.class);
            configuration.addAnnotatedClass(Room.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Borrower.class);
            configuration.addAnnotatedClass(Membership.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Shelf.class);

            // Create service registry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // Build the SessionFactory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception ex) {
            logger.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    // Method to get the SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Convenience method for obtaining a session
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Shutdown method to close the SessionFactory and release resources
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
