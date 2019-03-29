package fromHibernate.dao;

import fromHibernate.entity.Developer;
import fromHibernate.entity.Project;
import fromHibernate.service.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProjectDAO {

    public void createProject(Project project) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(project);
        transaction.commit();
        session.close();
    }


    public Project getProjectById(long projectId) {
        Project project;

        Session session = Connection.getSessionFactory().openSession();
        project = session.get(Project.class, projectId);
        session.close();

        return project;
    }


    public List<Project> getAllProjects() {
        List<Project> result;

        Session session = Connection.getSessionFactory().openSession();
        result = session.createQuery("FROM Project", Project.class).list();
        session.close();

        return result;
    }


    public void updateProjectById(Project project) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(project);
        transaction.commit();
        session.close();
    }


    public void deleteProject(Project project) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(project);
        transaction.commit();
        session.close();
    }


    public static void assignDeveloperToProject(Developer developer, Project project) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        developer.getProjects().add(project);
        session.update(developer);
        transaction.commit();
        session.close();
    }
}