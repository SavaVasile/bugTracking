package com.sda.sava.bugtracking.service;

import com.sda.sava.bugtracking.dao.BugsTrackingDao;
import com.sda.sava.bugtracking.dao.ProjectDao;
import com.sda.sava.bugtracking.dao.UserDao;
import com.sda.sava.bugtracking.model.BugsTracking;
import com.sda.sava.bugtracking.model.Project;
import com.sda.sava.bugtracking.model.User;

import java.util.List;

//Clasa intermediara intre dao si baza de date
public class UserDisplayService {
    private UserDao userDao = new UserDao();

    public User getUser(int userId) {
        return userDao.getUserById(userId);
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void printAllUsers() {
        userDao.printAllUsers();
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void deleteAllUsers() {
        userDao.deleteAllUsers();
    }





}
