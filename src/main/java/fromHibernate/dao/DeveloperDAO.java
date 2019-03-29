package fromHibernate.dao;

import fromHibernate.entity.Developer;
import fromHibernate.service.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperDAO {

    public void createDeveloper(Developer developer) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        session.close();
    }


    public Developer getDeveloperById(long developerId) {
        Developer developer;

        Session session = Connection.getSessionFactory().openSession();
        developer = session.get(Developer.class, developerId);
        session.close();

        return developer;
    }


    public List<Developer> getAllDevelopers() {
        List<Developer> result;

        Session session = Connection.getSessionFactory().openSession();
        result = session.createQuery("FROM Developer", Developer.class).list();
        session.close();

        return result;
    }


    public void updateDeveloper(Developer developer) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(developer);
        transaction.commit();
        session.close();
    }


    public void deleteDeveloper(Developer developer) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(developer);
        transaction.commit();
        session.close();
    }
}