package com.sda.sava.bugtracking.service;

import com.sda.sava.bugtracking.dao.ProjectDao;
import com.sda.sava.bugtracking.model.Project;

import java.util.List;

public class ProjectDisplayService {
    private ProjectDao projectDao = new ProjectDao();

    public Project getProject(int projectId) {
        return projectDao.getProjectById(projectId);
    }

    public Project saveProject(Project project) {
        return projectDao.save(project);
    }

    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    public void printAllProjects() {
        projectDao.printAllProjects();
    }

    public void deleteProject(Project project) {
        projectDao.deleteProject(project);
    }

    public void deleteAllProjects() {
        projectDao.deleteAllProjects();
    }
}
