package com.university.techcorp.domain;

public class ProjectManager extends Employee {
    public ProjectManager(String name, int skill, double salary) {
        super(name, skill, salary);
    }

    public int work() {
        return getSkill() + 1;
    }
}