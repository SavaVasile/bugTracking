package com.sda.sava.bugtracking.service;

import com.sda.sava.bugtracking.dao.BugsTrackingDao;
import com.sda.sava.bugtracking.model.BugsTracking;
import com.sda.sava.bugtracking.model.Project;
import com.sda.sava.bugtracking.model.User;

import java.util.List;

public class BugsTrackingDisplayService {
    private BugsTrackingDao bugsTrackingDao = new BugsTrackingDao();

    public BugsTracking getBugs(int bugId) {
        return bugsTrackingDao.getBugById(bugId);
    }

    public BugsTracking save(BugsTracking bugsTracking) {
        return bugsTrackingDao.save(bugsTracking);
    }


    public List<BugsTracking> getAllBugs() {
        return bugsTrackingDao.getAllBugs();
    }

    public void printAllBugs() {
        bugsTrackingDao.printAllBugs();
    }

    public void deleteBug(BugsTracking bug) {
        bugsTrackingDao.delete(bug);
    }

    public void deleteAllBugs() {
        bugsTrackingDao.deleteAllBugs();
    }
}
