package com.university.techcorp.domain;

public class Designer extends Employee {
    public Designer(String name, int skill, double salary) {
        super(name, skill, salary);
    }

    public int work() {
        return getSkill() + 2;
    }
}