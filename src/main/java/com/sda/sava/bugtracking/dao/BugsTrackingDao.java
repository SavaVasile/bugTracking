package com.sda.sava.bugtracking.dao;

import com.sda.sava.bugtracking.hibernateUtils.HibernateUtil;
import com.sda.sava.bugtracking.model.BugsTracking;
import com.sda.sava.bugtracking.model.Project;
import com.sda.sava.bugtracking.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BugsTrackingDao {
    public BugsTracking getBugById(int bugId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        BugsTracking bugsTracking = session.get(BugsTracking.class, bugId);
        transaction.commit();
        session.close();
        return bugsTracking;
    }

    public List<BugsTracking> getAllBugs() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from BugsTracking");
        List<BugsTracking> bugsList = query.list();
        session.close();
        return bugsList;
    }

    public void printAllBugs() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from BugsTracking");
        List<BugsTracking> printBugs = query.list();
        System.out.println(printBugs.toString());
        session.close();
    }

    public BugsTracking save(BugsTracking bugsTracking) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(bugsTracking);
        transaction.commit();
        session.close();
        return bugsTracking;
    }

    public void delete(BugsTracking bugsTracking) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(bugsTracking);
        transaction.commit();
        session.close();
    }

    public void deleteAllBugs() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from BugsTracking");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}
