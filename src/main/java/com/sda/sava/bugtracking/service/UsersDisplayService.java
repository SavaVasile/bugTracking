package com.sda.sava.bugtracking.service;

import com.sda.sava.bugtracking.dao.UserDao;
import com.sda.sava.bugtracking.model.User;

import java.util.List;

//Clasa intermediara intre dao si baza de date
public class UsersDisplayService {
    private UserDao userDao =  new UserDao();


    public User getUser(int userId) {
        return userDao.getUserById(userId);
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void printAllUsers() {
         userDao.printAllUsers();
    }
    public void deleteUser(User user){
        userDao.delete(user);
    }
    public void deleteAllUsers(){
        userDao.deleteAllUsers();
    }


}
