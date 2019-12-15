package com.sda.sava.bugtracking.view;

import com.sda.sava.bugtracking.model.User;
import com.sda.sava.bugtracking.service.UsersDisplayService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


//Clasa de JavaFX, NU FOLOSIM DAO AICI
public class BugsTrackingView extends Application {

    @Override
    public void  start (Stage primaryStage) throws Exception{
        UsersDisplayService usersDisplayService = new UsersDisplayService();

        primaryStage.setTitle("Bugs Tracking App");
        primaryStage.setHeight(400);
        primaryStage.setWidth(800);
        primaryStage.setX(400);
        primaryStage.setY(300);

        Label usernameLabel = new Label("Username: ");
        Label emailLabel = new Label("    Email: ");
        Label ocupationLabel = new Label("Ocupation: ");

        Button printUsers = new Button("Print Users");
        printUsers.setOnMouseClicked(event -> {
            System.out.println("Printing users");
            usersDisplayService.printAllUsers();
        });
        TextField userNameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField ocupationTextField = new TextField();

        Button saveUser = new Button("Save User");
        saveUser.setOnMouseClicked(event -> {
            System.out.println("Saving new User");
            User text = new User();
            usersDisplayService.save(text);

        });
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(printUsers);

        HBox hBox1= new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(saveUser);

        HBox userNamehBox = new HBox();
        userNamehBox.setAlignment(Pos.CENTER);
        userNamehBox.getChildren().addAll(usernameLabel,userNameTextField);

        HBox emailhBox = new HBox();
        emailhBox.setAlignment(Pos.CENTER);
        emailhBox.getChildren().addAll(emailLabel,emailTextField);

        HBox ocupationhBox = new HBox();
        ocupationhBox.setAlignment(Pos.CENTER);
        ocupationhBox.getChildren().addAll(ocupationLabel,ocupationTextField);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0,0,50,30));
        vBox.getChildren().addAll(hBox,userNamehBox,emailhBox,ocupationhBox,hBox1);



        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();







    }
}
