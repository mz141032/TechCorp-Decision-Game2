package com.university.techcorp.ui;

import com.university.techcorp.domain.Company;
import com.university.techcorp.domain.Employee;
import com.university.techcorp.domain.Project;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);

    public void showTurn(int turn) {
        System.out.println();
        System.out.println("========== TURN " + turn + " ==========");
    }

    public void showCompanyStatus(Company company) {
        System.out.println("Company: " + company.getName());
        System.out.println("Cash: " + company.getCash());
        System.out.println("Reputation: " + company.getReputation());
        System.out.println("Completed projects: " + company.getCompletedProjects());
        System.out.println("Employees: " + company.getEmployees().size());
        System.out.println("Projects: " + company.getProjects().size());
    }

    public void showMenu() {
        System.out.println();
        System.out.println("1. Work one turn");
        System.out.println("2. Hire employee");
        System.out.println("3. Create project");
        System.out.println("4. Assign employee to project");
        System.out.println("5. Show employees");
        System.out.println("6. Show projects");
        System.out.println("0. Exit");
    }

    public void showEmployees(Company company) {
        System.out.println();
        System.out.println("Employees:");

        if (company.getEmployees().isEmpty()) {
            System.out.println("No employees.");
            return;
        }

        for (int i = 0; i < company.getEmployees().size(); i++) {
            Employee employee = company.getEmployees().get(i);
            System.out.println(
                    (i + 1) + ". " +
                    employee.getName() +
                    " | Type: " + employee.getClass().getSimpleName() +
                    " | Skill: " + employee.getSkill() +
                    " | Salary: " + employee.getSalary()
            );
        }
    }

    public void showProjects(Company company) {
        System.out.println();
        System.out.println("Projects:");

        if (company.getProjects().isEmpty()) {
            System.out.println("No projects.");
            return;
        }

        for (int i = 0; i < company.getProjects().size(); i++) {
            Project project = company.getProjects().get(i);
            System.out.println(
                    (i + 1) + ". " +
                    project.getName() +
                    " | Progress: " + project.getProgress() + "/" + project.getRequiredWork() +
                    " | Reward: " + project.getReward() +
                    " | Status: " + project.getStatus()
            );
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid decimal number.");
            }
        }
    }

    public String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}