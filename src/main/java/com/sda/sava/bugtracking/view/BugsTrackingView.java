package com.sda.sava.bugtracking.view;

import com.sda.sava.bugtracking.Application;
import com.sda.sava.bugtracking.service.UsersDisplayService;
import javafx.stage.Stage;
//Clasa de JavaFX, NU FOLOSIM DAO AICI
public class BugsTrackingView extends Application {
    //@Override
    public void  start (Stage primaryStage) throws Exception{
        UsersDisplayService usersDisplayService = new UsersDisplayService();


    }
}
