package com.sda.sava.bugtracking.service;

import com.sda.sava.bugtracking.dao.UserDao;
import com.sda.sava.bugtracking.model.User;
//Clasa intermediara intre dao si baza de date
public class UsersDisplayService {
    private UserDao userDao;


    public User getUser(int userId){
        return userDao.getUserById(userId);
    }

}
