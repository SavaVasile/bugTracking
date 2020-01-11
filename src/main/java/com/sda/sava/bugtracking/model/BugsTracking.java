package com.sda.sava.bugtracking.model;

import org.omg.PortableInterceptor.ACTIVE;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bugsTracking")
public class BugsTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bugsTrackingId")
    private int bugsTrackingId;

    @ManyToOne()
    @JoinColumn(name = "userId",nullable = false)
    private User users;

    @ManyToOne()
    @JoinColumn(name = "projectId",nullable = false)
    private Project projects;

    @Column(name = "bugName")
    private String bugName;

    @Column(name = "bugDescription")
    private String bugDescription;

    @Column(name = "entryDate")
    private LocalDate entryDate;

    @Column(name = "dueDate")
    private LocalDate dueDate;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private PriorityEnum priorityEnum;

    @Column(name = "severity")
    @Enumerated(EnumType.STRING)
    private SeverityEnum severityEnum;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;
    public BugsTracking(){}
    public BugsTracking(String bugName,String bugDescription,LocalDate entryDate,LocalDate dueDate, PriorityEnum priorityEnum,SeverityEnum severityEnum){
        this.bugName = bugName;
        this.bugDescription = bugDescription;
        this.entryDate = entryDate;
        this.dueDate = dueDate;
        this.priorityEnum = priorityEnum;
        this.severityEnum = severityEnum;
    }
    public PriorityEnum getPriorityEnum(){
        return priorityEnum;
    }

    public SeverityEnum getSeverityEnum(){
        return severityEnum;
    }

    public StatusEnum getStatusEnum(){
        return statusEnum;
    }
    @Column(name = "userWorkingOnBug")
    private String userWorkingOnBug;

    public void workingOnBug(){
        if (getStatusEnum()== statusEnum.ACTIVE){
            getUserWorkingOnBug();
        }
    }

    public int getBugsTrackingId() {
        return bugsTrackingId;
    }

    public void setBugsTrackingId(int bugsTrackingId) {
        this.bugsTrackingId = bugsTrackingId;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Project getProjects() {
        return projects;
    }

    public void setProjects(Project projects) {
        this.projects = projects;
    }

    public String getBugName() {
        return bugName;
    }

    public void setBugName(String bugName) {
        this.bugName = bugName;
    }

    public String getBugDescription() {
        return bugDescription;
    }

    public void setBugDescription(String bugDescription) {
        this.bugDescription = bugDescription;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriorityEnum(PriorityEnum priorityEnum) {
        this.priorityEnum = priorityEnum;
    }

    public void setSeverityEnum(SeverityEnum severityEnum) {
        this.severityEnum = severityEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public String getUserWorkingOnBug() {
        return userWorkingOnBug;
    }

    public void setUserWorkingOnBug(String userWorkingOnBug) {
        this.userWorkingOnBug = userWorkingOnBug;
    }

    //@Override
    /*public String toString() {
        return "BugsTracking{" +
                "bugsTrackingId=" + bugsTrackingId +
                ", users=" + users +
                ", projects=" + projects +
                ", bugName='" + bugName + '\'' +
                ", bugDescription='" + bugDescription + '\'' +
                ", entryDate=" + entryDate +
                ", dueDate=" + dueDate +
                ", priorityEnum=" + priorityEnum +
                ", severityEnum=" + severityEnum +
                ", statusEnum=" + statusEnum +
                ", userWorkingOnBug='" + userWorkingOnBug + '\'' +
                '}';
    }*/
    @Override
    public String toString(){
        return "User : "+users +", Project : "+projects+", Bug : "+bugName+", Bug Description : "+bugDescription+", Entry Date : "+ entryDate+
                ", Due Date : " + ", Priority : "+ priorityEnum + ", Severity : "+ severityEnum+", Status : "+statusEnum+".";
    }
}
