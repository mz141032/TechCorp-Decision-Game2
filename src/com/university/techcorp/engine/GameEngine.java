package com.university.techcorp.engine;

import com.university.techcorp.domain.Company;
import com.university.techcorp.domain.Designer;
import com.university.techcorp.domain.Developer;
import com.university.techcorp.domain.Employee;
import com.university.techcorp.domain.Project;
import com.university.techcorp.domain.ProjectManager;
import com.university.techcorp.domain.ProjectStatus;
import com.university.techcorp.domain.Tester;
import com.university.techcorp.events.GameEvent;
import com.university.techcorp.events.RandomEventGenerator;
import com.university.techcorp.ui.ConsoleUI;

public class GameEngine {
    private Company company;
    private ConsoleUI ui;
    private int turn = 1;
    private boolean running = true;

    public GameEngine(Company company, ConsoleUI ui) {
        this.company = company;
        this.ui = ui;
    }

    public void run() {
        while (running) {
            ui.showTurn(turn);
            ui.showCompanyStatus(company);
            ui.showMenu();

            int choice = ui.readInt("Choose option: ");

            switch (choice) {
                case 1:
                    workOneTurn();
                    break;
                case 2:
                    hireEmployee();
                    break;
                case 3:
                    createProject();
                    break;
                case 4:
                    assignEmployeeToProject();
                    break;
                case 5:
                    ui.showEmployees(company);
                    break;
                case 6:
                    ui.showProjects(company);
                    break;
                case 0:
                    running = false;
                    ui.showMessage("Game ended.");
                    break;
                default:
                    ui.showMessage("Invalid option.");
            }

            if (running) {
                checkWinLoseCondition();
                turn++;
            }
        }
    }

    private void workOneTurn() {
        ui.showMessage("Employees are working...");

        for (Project project : company.getProjects()) {
            if (project.getStatus() == ProjectStatus.IN_PROGRESS) {
                project.workOneTurn();

                if (project.isCompleted()) {
                    project.setStatus(ProjectStatus.COMPLETED);
                    company.addCash(project.getReward());
                    company.increaseCompletedProjects();
                    company.increaseReputation(10);

                    ui.showMessage("Project completed: " + project.getName());
                    ui.showMessage("Reward received: " + project.getReward());
                }
            }
        }

        company.paySalaries();

        GameEvent event = RandomEventGenerator.generateRandomEvent();
        if (event != null) {
            ui.showMessage("Random event: " + event.getName());
            event.apply(company);
        }
    }

    private void hireEmployee() {
        ui.showMessage("Choose employee type:");
        ui.showMessage("1. Developer");
        ui.showMessage("2. Tester");
        ui.showMessage("3. Designer");
        ui.showMessage("4. Project Manager");

        int type = ui.readInt("Type: ");
        String name = ui.readString("Name: ");

        Employee employee;

        switch (type) {
            case 1:
                employee = new Developer(name, 8, 7000);
                break;
            case 2:
                employee = new Tester(name, 6, 6000);
                break;
            case 3:
                employee = new Designer(name, 5, 5500);
                break;
            case 4:
                employee = new ProjectManager(name, 4, 8000);
                break;
            default:
                ui.showMessage("Invalid employee type.");
                return;
        }

        company.hire(employee);
        ui.showMessage("Employee hired: " + employee.getName());
    }

    private void createProject() {
        String name = ui.readString("Project name: ");
        int requiredWork = ui.readInt("Required work points: ");
        double reward = ui.readDouble("Project reward: ");

        if (requiredWork <= 0 || reward <= 0) {
            ui.showMessage("Required work and reward must be greater than 0.");
            return;
        }

        Project project = new Project(name, requiredWork, reward);
        company.addProject(project);

        ui.showMessage("Project created: " + name);
    }

    private void assignEmployeeToProject() {
        if (company.getEmployees().isEmpty()) {
            ui.showMessage("No employees available.");
            return;
        }

        if (company.getProjects().isEmpty()) {
            ui.showMessage("No projects available.");
            return;
        }

        ui.showEmployees(company);
        int employeeIndex = ui.readInt("Choose employee number: ") - 1;

        ui.showProjects(company);
        int projectIndex = ui.readInt("Choose project number: ") - 1;

        if (employeeIndex < 0 || employeeIndex >= company.getEmployees().size()) {
            ui.showMessage("Invalid employee number.");
            return;
        }

        if (projectIndex < 0 || projectIndex >= company.getProjects().size()) {
            ui.showMessage("Invalid project number.");
            return;
        }

        Employee employee = company.getEmployees().get(employeeIndex);
        Project project = company.getProjects().get(projectIndex);

        project.addEmployee(employee);

        ui.showMessage(employee.getName() + " assigned to " + project.getName());
    }

    private void checkWinLoseCondition() {
        if (company.getCash() <= 0) {
            ui.showMessage("You lost. Company went bankrupt.");
            running = false;
        }

        if (company.getCompletedProjects() >= 3) {
            ui.showMessage("You won. Company completed 3 projects.");
            running = false;
        }
    }
}