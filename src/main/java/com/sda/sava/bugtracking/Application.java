package com.sda.sava.bugtracking;

import com.sda.sava.bugtracking.dao.ProjectDao;
import com.sda.sava.bugtracking.dao.UserDao;
import com.sda.sava.bugtracking.model.User;
import com.sda.sava.bugtracking.service.UserDisplayService;
import com.sda.sava.bugtracking.view.BugsTrackingView;



public class Application extends BugsTrackingView {
    public static void main(String[] args) {
        launch(args);


        /*UserDao userDao = new UserDao();
        userDao.deleteAllUsers();
        ProjectDao projectDao = new ProjectDao();
        projectDao.deleteAllProjects();*/



    }
}