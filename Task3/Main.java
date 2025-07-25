package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;
public class Main {
    public static void main(String[] args) {
          SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
          Session session=null;
          Transaction transaction=null;

          try{
              session=sessionFactory.openSession();
              transaction=session.beginTransaction();
              //Create
              Customer customer =new Customer("Lalith","lalith@gmail.com");
              session.save(customer);

              System.out.println("Customer Saved Successfully");

              //Update
              Customer updateCustomer=session.get(Customer.class,2L);
              if(updateCustomer!=null){
                  System.out.println("Customer Found : "+ updateCustomer.getName());
                  updateCustomer.setName("satvik");
                  session.update(updateCustomer);

              }
              else{
                System.out.println("Customer details not found");
            }
              //Delete
              Customer deleteCustomer=session.get(Customer.class,9L);
              if(deleteCustomer!=null){
                  session.delete(deleteCustomer);
                  transaction.commit();
                  System.out.println("Customer Deleted");
              }
              else{
             System.out.println("Customer details not found ");
        }
              //Read
              Customer readCustmer=session.load(Customer.class,2L);
              System.out.println("Customer Found : "+readCustmer);
              String hql="from Customer";
              List<Customer> list=session.createQuery(hql,Customer.class).getResultList();
              for(Customer c:list){
                  System.out.println("Id : "+c.getId()+" "+"Name : "+c.getName()+" "+"Email : "+c.getEmail());
              }
              transaction.commit();
          } catch (Exception e) {
              if(transaction !=null){
                  transaction.rollback();
              }
              e.printStackTrace();
          }
          finally {

              if(session!=null){
                  session.close();
              }
              sessionFactory.close();
          }

    }
}