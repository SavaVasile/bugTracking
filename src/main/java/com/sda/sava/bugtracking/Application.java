package com.sda.sava.bugtracking;

import com.sda.sava.bugtracking.dao.UserDao;
import com.sda.sava.bugtracking.model.User;

public class Application {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user3 = new User("John","email@gmail.com","developer");
        userDao.save(user3);
        System.out.println(userDao.getUserById(2));
        //userDao.delete(user2);
    }

}