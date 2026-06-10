package com.university.techcorp.domain;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<Employee> team = new ArrayList<Employee>();
    private int progress;
    private int requiredWork;
    private double reward;
    private ProjectStatus status;

    public Project(String name, int requiredWork, double reward) {
        this.name = name;
        this.requiredWork = requiredWork;
        this.reward = reward;
        this.progress = 0;
        this.status = ProjectStatus.IN_PROGRESS;
    }

    public void addEmployee(Employee employee) {
        if (!team.contains(employee)) {
            team.add(employee);
        }
    }

    public void workOneTurn() {
        for (Employee employee : team) {
            progress += employee.work();
        }
    }

    public boolean isCompleted() {
        return progress >= requiredWork;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getTeam() {
        return team;
    }

    public int getProgress() {
        return progress;
    }

    public int getRequiredWork() {
        return requiredWork;
    }

    public double getReward() {
        return reward;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}