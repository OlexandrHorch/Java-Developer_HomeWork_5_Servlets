package fromHibernate.dao;

import fromHibernate.entity.Company;
import fromHibernate.service.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDAO {

    public void createCompany(Company company) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(company);
        transaction.commit();
        session.close();
    }


    public Company getCompanyById(long companyId) {
        Company company;

        Session session = Connection.getSessionFactory().openSession();
        company = session.get(Company.class, companyId);
        session.close();

        return company;
    }


    public List<Company> getAllCompanies() {
        List<Company> result;

        Session session = Connection.getSessionFactory().openSession();
        result = session.createQuery("FROM Company", Company.class).list();
        session.close();

        return result;
    }


    public void updateCompany(Company company) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(company);
        transaction.commit();
        session.close();
    }


    public void deleteCompany(Company company) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(company);
        transaction.commit();
        session.close();
    }
}