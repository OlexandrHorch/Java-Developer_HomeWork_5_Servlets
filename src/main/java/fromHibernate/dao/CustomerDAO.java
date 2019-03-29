package fromHibernate.dao;

import fromHibernate.entity.Customer;
import fromHibernate.service.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAO {

    public void createCustomer(Customer customer) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }


    public Customer getCustomerById(long customerId) {
        Customer customer;

        Session session = Connection.getSessionFactory().openSession();
        customer = session.get(Customer.class, customerId);
        session.close();

        return customer;
    }


    public List<Customer> getAllCustomers() {
        List<Customer> result;

        Session session = Connection.getSessionFactory().openSession();
        result = session.createQuery("FROM Customer", Customer.class).list();
        session.close();

        return result;
    }


    public void updateCustomer(Customer customer) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }


    public void deleteCustomer(Customer customer) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
    }
}