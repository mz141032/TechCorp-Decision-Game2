package com.university.techcorp.domain;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private double cash;
    private int reputation;
    private int completedProjects;

    private List<Employee> employees = new ArrayList<Employee>();
    private List<Project> projects = new ArrayList<Project>();

    public Company(String name, double cash) {
        this.name = name;
        this.cash = cash;
        this.reputation = 50;
        this.completedProjects = 0;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void paySalaries() {
        double totalSalary = 0;

        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }

        cash -= totalSalary;
    }

    public void addCash(double amount) {
        cash += amount;
    }

    public void reduceCash(double amount) {
        cash -= amount;
    }

    public void increaseReputation(int amount) {
        reputation += amount;
    }

    public void decreaseReputation(int amount) {
        reputation -= amount;

        if (reputation < 0) {
            reputation = 0;
        }
    }

    public void increaseCompletedProjects() {
        completedProjects++;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public int getReputation() {
        return reputation;
    }

    public int getCompletedProjects() {
        return completedProjects;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }
}