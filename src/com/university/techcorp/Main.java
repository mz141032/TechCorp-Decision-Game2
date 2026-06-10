package com.university.techcorp;

import com.university.techcorp.domain.Company;
import com.university.techcorp.domain.Developer;
import com.university.techcorp.domain.Project;
import com.university.techcorp.domain.Tester;
import com.university.techcorp.engine.GameEngine;
import com.university.techcorp.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("TechCorp", 50000);

        Developer anna = new Developer("Anna", 8, 7000);
        Tester piotr = new Tester("Piotr", 6, 6000);

        company.hire(anna);
        company.hire(piotr);

        Project project = new Project("Mobile App", 40, 25000);
        project.addEmployee(anna);
        project.addEmployee(piotr);

        company.addProject(project);

        ConsoleUI ui = new ConsoleUI();
        GameEngine engine = new GameEngine(company, ui);
        engine.run();
    }
}