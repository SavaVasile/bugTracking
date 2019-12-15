package com.sda.sava.bugtracking;

import com.sda.sava.bugtracking.dao.UserDao;
import com.sda.sava.bugtracking.model.User;
import com.sda.sava.bugtracking.service.UsersDisplayService;
import com.sda.sava.bugtracking.view.BugsTrackingView;



public class Application extends BugsTrackingView {
    public static void main(String[] args) {
        launch();
        /*UserDao userDao = new UserDao();
        User user = new User("John", "email@gmail.com", "developer");
        //userDao.save(user);
        //userDao.deleteAllUsers();
        UsersDisplayService u = new UsersDisplayService();
        u.printAllUsers();
*/

    }
}