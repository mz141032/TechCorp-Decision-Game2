package com.university.techcorp.domain;

public class Tester extends Employee {
    public Tester(String name, int skill, double salary) {
        super(name, skill, salary);
    }

    public int work() {
        return getSkill() + 3;
    }
}