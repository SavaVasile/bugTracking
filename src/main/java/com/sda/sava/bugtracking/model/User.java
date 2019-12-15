package com.sda.sava.bugtracking.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "userId")
    private int userId;
    @Column(name = "userName",unique = true)
    private String userName;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "ocupation")
    private String ocupation;

    @OneToMany(mappedBy = "users")
    List<BugsTracking> usersList = new ArrayList<>();
    public User(){

    }

    public User(String userName, String email, String ocupation) {
        this.userName = userName;
        this.email = email;
        this.ocupation = ocupation;
    }

    public List<BugsTracking> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<BugsTracking> usersList) {
        this.usersList = usersList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    @Override
    public String toString() {
        return "\nUsers{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", ocupation='" + ocupation + '\'' +
                '}';
    }
}
