import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Main {
    public static void main(String[] args) {
        // 1. Load the configuration and create a SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        Session session = null;
        Transaction transaction = null;
        try {
            // 2. Open a session
            session = sessionFactory.openSession();
            
            // 3. Begin a transaction
            transaction = session.beginTransaction();
            
            // 4. Create a new Customer object
            Customer customer = new Customer("John Doe", "john.doe@example.com");
            
            // 5. Save the object to the database
            session.save(customer);
            
            // 6. Commit the transaction
            transaction.commit();
            
            System.out.println("Customer saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // 7. Close the session and session factory
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
