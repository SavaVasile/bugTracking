package com.sda.sava.bugtracking.dao;

import com.sda.sava.bugtracking.hibernateUtils.HibernateUtil;
import com.sda.sava.bugtracking.model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDao {
public User getUserById(int userId){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    User user = session.get(User.class,userId);
    transaction.commit();
    session.close();
    return user;
}
public User save(User user){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("from Users where email = ?1" );
    query.setParameter(1,user.getEmail());
    query.list();
    if (query.list().size() == 0){
        session.saveOrUpdate(user);
    }
    transaction.commit();
    session.close();
    return user;
}
public void delete(User users){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction =session.beginTransaction();
    session.delete(users);
    transaction.commit();
    session.close();
}
public static void deleteAllUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from User");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
