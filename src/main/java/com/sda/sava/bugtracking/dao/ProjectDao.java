package com.sda.sava.bugtracking.dao;

import com.sda.sava.bugtracking.hibernateUtils.HibernateUtil;
import com.sda.sava.bugtracking.model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProjectDao {
    public Project getProjectById(int projectId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Project project = session.get(Project.class, projectId);
        transaction.commit();
        session.close();
        return project;
    }

    public Project save(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Project where project = ?1");
        query.setParameter(1, project.getProjectName());
        query.list();
        if (query.list().size() == 0) {
            session.saveOrUpdate(project);
        }
        transaction.commit();
        session.close();
        return project;
    }
    public void deleteProject(Project project){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(project);
        transaction.commit();
        session.close();
    }
    public void deleteAllProjects(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Project");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}


