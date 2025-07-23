package com.example;

import com.example.model.Address;
import com.example.model.User;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create a user with addresses
        User user = new User(1L, "Alice Smith", "alice@example.com");
        user.getAddresses().add(new Address("123 Main St", "New York"));
        user.getAddresses().add(new Address("456 Oak Ave", "Boston"));
        saveUser(user);

        // List all users
        listUsers();

        // Read the user
        User retrievedUser = getUser(1L);
        System.out.println("Retrieved: " + retrievedUser);

        // Update the user
        user.setName("Alice Johnson");
        updateUser(user);

        // Delete the user
        deleteUser(1L);

        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }

    public static void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            System.out.println("User saved: " + user);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static User getUser(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            User user = session.get(User.class, id);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
            System.out.println("User updated: " + user);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void deleteUser(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.remove(user);
                System.out.println("User deleted: " + user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void listUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<User> users = session.createQuery("FROM User", User.class).getResultList();
            System.out.println("All users:");
            users.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
