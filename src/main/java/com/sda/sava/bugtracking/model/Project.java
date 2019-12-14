package com.sda.sava.bugtracking.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private int projectId;
    @Column(name = "projectName")
    private String projectName;
    @Column(name = "ProjectDescription")
    private String projectDescription;

    @OneToMany(mappedBy = "projects")
    List<BugsTracking>projectsList = new ArrayList<>();

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public List<BugsTracking> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<BugsTracking> projectsList) {
        this.projectsList = projectsList;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                '}';
    }
}
