package com.sda.sava.bugtracking.view;

import com.sda.sava.bugtracking.dao.BugsTrackingDao;
import com.sda.sava.bugtracking.dao.ProjectDao;
import com.sda.sava.bugtracking.dao.UserDao;
import com.sda.sava.bugtracking.model.*;
import com.sda.sava.bugtracking.service.BugsTrackingDisplayService;
import com.sda.sava.bugtracking.service.ProjectDisplayService;
import com.sda.sava.bugtracking.service.UserDisplayService;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;


//Clasa de JavaFX, NU FOLOSIM DAO AICI
public class BugsTrackingView extends Application {
    BugsTrackingDisplayService bugsTrackingDisplayService = new BugsTrackingDisplayService();

    @Override
    public void start(Stage primaryStage) throws Exception {
        UserDisplayService usersDisplayService = new UserDisplayService();
        ProjectDisplayService projectDisplayService = new ProjectDisplayService();
        BugsTrackingDisplayService bugsTrackingDisplayService = new BugsTrackingDisplayService();

        primaryStage.setTitle("Bugs Tracking App");
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setX(400);
        primaryStage.setY(300);
        Text welcomeTitle = new Text("New Issue:");
        welcomeTitle.setFont(Font.font("Veranda",20));
        welcomeTitle.setFill(Paint.valueOf("#2455d1"));
        VBox vBox = new VBox();
        ScrollPane scroll = new ScrollPane();

        ChoiceBox <PriorityEnum>priority = new ChoiceBox(FXCollections.observableArrayList(
                PriorityEnum.values())
        );
        ChoiceBox<SeverityEnum> severity = new ChoiceBox(FXCollections.observableArrayList(
                SeverityEnum.values())
        );
        ChoiceBox<StatusEnum> status = new ChoiceBox(FXCollections.observableArrayList(
                StatusEnum.values())
        );
        Label projectNameLabel = new Label(       "Project name:          ");
        Label projectDescriptionLabel = new Label("Project description: ");
        Label bugNameLabel = new Label(           "Bug name:               ");
        Label bugDescriptionLabel = new Label(    "Bug description:      ");
        Label entryDateLabel = new Label("Entry date: ");
        Label dueDateLabel = new Label("Due date:   ");

        Label usernameLabel = new Label("Username: ");
        Label emailLabel = new Label("Email:        ");
        Label ocupationLabel = new Label("Ocupation:");
        Label priorityLabel = new Label("Priority:   ");
        Label severityLabel = new Label("Severity:  ");
        Label statusLabel = new Label("Status:     ");


        TextField projectNameTextField = new TextField();
        TextArea projectDescriptionTextField = new TextArea();
        projectDescriptionTextField.setMaxSize(500,100);
        TextField bugNameTextField = new TextField();
        TextArea bugDescriptionTextField = new TextArea();
        bugDescriptionTextField.setMaxSize(500,100);
        DatePicker entryDateTextField = new DatePicker();
        DatePicker dueDateTextField = new DatePicker();

        TextField userNameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField ocupationTextField = new TextField();

        User newUser = new User();
        Project newProject = new Project();
        BugsTracking newBug = new BugsTracking();
        Button saveAll = new Button("Save issue");
        saveAll.setOnMouseClicked(event -> {
         try {
             newUser.setUserName(userNameTextField.getText());
             newUser.setEmail(emailTextField.getText());
             newUser.setOcupation(ocupationTextField.getText());

             usersDisplayService.saveUser(newUser);


             newProject.setProjectName(projectNameTextField.getText());
             newProject.setProjectDescription(projectDescriptionTextField.getText());

             projectDisplayService.saveProject(newProject);

             newBug.setUsers(UserDao.getUserByEmail(newUser));
             newBug.setProjects(ProjectDao.getProjectByName(newProject));
             newBug.setBugName(bugNameTextField.getText());
             newBug.setBugDescription(bugDescriptionTextField.getText());
             newBug.setEntryDate(entryDateTextField.getValue());
             newBug.setDueDate(dueDateTextField.getValue());
             newBug.setPriorityEnum(priority.getValue());
             newBug.setSeverityEnum(severity.getValue());
             newBug.setStatusEnum(status.getValue());

             bugsTrackingDisplayService.save(newBug);

             bugsTrackingDisplayService.printAllBugs();
         }catch (Exception e){
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Error Dialog");
             alert.setHeaderText(null);
             alert.setContentText("ERROR SAVING THE ISSUE. TRY AGAIN LATER. ");
             alert.showAndWait();
         }

        });


        HBox projectNamehBox = new HBox();
        projectNamehBox.setAlignment(Pos.TOP_LEFT);
        projectNamehBox.getChildren().addAll(projectNameLabel,projectNameTextField);

        HBox projectDescriptionhBox = new HBox();
        projectDescriptionhBox.setAlignment(Pos.TOP_LEFT);
        projectDescriptionhBox.getChildren().addAll(projectDescriptionLabel,projectDescriptionTextField);

        HBox bugNamehBox = new HBox();
        bugNamehBox.setAlignment(Pos.TOP_LEFT);
        bugNamehBox.getChildren().addAll(bugNameLabel,bugNameTextField);

        HBox bugDescriptionhBox = new HBox();
        bugDescriptionhBox.setAlignment(Pos.TOP_LEFT);
        bugDescriptionhBox.getChildren().addAll(bugDescriptionLabel,bugDescriptionTextField);

        HBox entryDatehBox = new HBox();
        entryDatehBox.setAlignment(Pos.TOP_LEFT);
        entryDatehBox.getChildren().addAll(entryDateLabel,entryDateTextField);
        HBox dueDatehBox = new HBox();
        dueDatehBox.setAlignment(Pos.TOP_LEFT);
        dueDatehBox.getChildren().addAll(dueDateLabel,dueDateTextField);

        HBox priorityhBox = new HBox();
        priorityhBox.setAlignment(Pos.TOP_LEFT);
        priorityhBox.getChildren().addAll(priorityLabel,priority);
        HBox severityhBox = new HBox();
        severityhBox.setAlignment(Pos.TOP_LEFT);
        severityhBox.getChildren().addAll(severityLabel,severity);
        HBox statushBox = new HBox();
        statushBox.setAlignment(Pos.TOP_LEFT);
        statushBox.getChildren().addAll(statusLabel,status);

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.TOP_LEFT);
        //hBox1.getChildren().addAll(saveUser,existingUser);
        HBox existingUserhBox = new HBox();

        HBox userNamehBox = new HBox();
        userNamehBox.setAlignment(Pos.TOP_LEFT);

        userNamehBox.setSpacing(10);
        userNamehBox.getChildren().addAll(usernameLabel, userNameTextField);

        HBox emailhBox = new HBox();
        emailhBox.setAlignment(Pos.TOP_LEFT);

        emailhBox.setSpacing(10);
        emailhBox.getChildren().addAll(emailLabel, emailTextField);

        HBox saveIssueHBox = new HBox();
        saveIssueHBox.setAlignment(Pos.CENTER);
        saveIssueHBox.getChildren().addAll(saveAll);

        /*HBox saveBugHBox = new HBox();
        saveBugHBox.setAlignment(Pos.CENTER);
        saveBugHBox.getChildren().addAll(saveBug);*/

        HBox ocupationhBox = new HBox();
        ocupationhBox.setAlignment(Pos.TOP_LEFT);
        ocupationhBox.setSpacing(10);
        ocupationhBox.getChildren().addAll(ocupationLabel, ocupationTextField);
        vBox.setLayoutX(5);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(30,30,50,30));





        TableView tableView = new TableView();
        TableColumn<String,BugsTracking> column1 = new TableColumn<>("User Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("userName"));
        tableView.getColumns().add(column1);
        tableView.getItems().setAll(usersDisplayService.getAllUsers());
        tableView.refresh();

        vBox.getChildren().addAll(welcomeTitle,userNamehBox, emailhBox, ocupationhBox, hBox1,projectNamehBox,projectDescriptionhBox,
                bugNamehBox,bugDescriptionhBox,priorityhBox,severityhBox,statushBox,entryDatehBox,dueDatehBox,saveIssueHBox,tableView);
        scroll.setContent(vBox);
        Scene scene = new Scene(scroll);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
