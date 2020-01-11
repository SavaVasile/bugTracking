package com.sda.sava.bugtracking.dao;

import com.sda.sava.bugtracking.hibernateUtils.HibernateUtil;
import com.sda.sava.bugtracking.model.Project;
import com.sda.sava.bugtracking.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectDao {
    public Project getProjectById(int projectId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Project project = session.get(Project.class, projectId);
        transaction.commit();
        session.close();
        return project;
    }
    public List<Project> getAllProjects() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Project");
        List<Project> projectList = query.list();
        session.close();
        return projectList;
    }
    public void printAllProjects() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Project");
        List<Project> printProjects = query.list();
        System.out.println(printProjects);
        session.close();
    }

    public Project save(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Project where projectName = ?1");
        query.setParameter(1, project.getProjectName());
        query.list();
        if (query.list().size() == 0) {
            session.saveOrUpdate(project);
        }
        session.saveOrUpdate(project);
        transaction.commit();
        session.close();
        return project;
    }
    public static Project getProjectByName(Project project){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Project where projectName = ?1");
        query.setParameter(1, project.getProjectName());
        Project savedProject = (Project) query.list().get(0);
        transaction.commit();
        session.close();
        return savedProject;
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


