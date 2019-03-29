package fromHibernate.dao;

import fromHibernate.entity.Developer;
import fromHibernate.entity.Skill;
import fromHibernate.service.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SkillDAO {

    public void createSkill(Skill skill) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(skill);
        transaction.commit();
        session.close();
    }


    public Skill getSkillById(long skillId) {
        Skill skill;

        Session session = Connection.getSessionFactory().openSession();
        skill = session.get(Skill.class, skillId);
        session.close();

        return skill;
    }


    public List<Skill> getAllSkills() {
        List<Skill> result;

        Session session = Connection.getSessionFactory().openSession();
        result = session.createQuery("FROM Skill", Skill.class).list();
        session.close();

        return result;
    }


    public void updateSkill(Skill skill) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(skill);
        transaction.commit();
        session.close();
    }


    public void deleteSkill(Skill skill) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(skill);
        transaction.commit();
        session.close();
    }


    public static void assignSkillToDeveloper(Developer developer, Skill skill) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        developer.getSkills().add(skill);

        session.update(developer);
        transaction.commit();
        session.close();
    }


    public List<Skill> getAllSkillsByArea(String skillArea) {
        List<Skill> result;

        Session session = Connection.getSessionFactory().openSession();
        result = session.createQuery("FROM Skill WHERE area='" + skillArea + "'", Skill.class).list();
        session.close();

        return result;
    }


    public List<Skill> getAllSkillsByLevel(String skillLevel) {
        List<Skill> result;

        Session session = Connection.getSessionFactory().openSession();
        result = session.createQuery("FROM Skill WHERE level='" + skillLevel + "'", Skill.class).list();
        session.close();

        return result;
    }
}