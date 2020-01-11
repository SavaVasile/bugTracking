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
    @Column(name = "projectName",unique = true)
    private String projectName;
    @Column(name = "ProjectDescription")
    private String projectDescription;

    @OneToMany(cascade =CascadeType.ALL, mappedBy = "projects")
    List<BugsTracking> bugsTrackingList = new ArrayList<>();

    public Project() { }

    public Project(String projectName, String projectDescription) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

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
        return bugsTrackingList;
    }

    public void setProjectsList(List<BugsTracking> projectsList) {
        this.bugsTrackingList = projectsList;
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
