package services.impl;

import controllers.FuramaController;
import models.Employee;
import services.EmployeeService;
import utils.DateUtils;
import utils.FileUtils;
import utils.Pattern;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class EmployeeServiceImpl implements EmployeeService, Pattern {
    private static Scanner sc = new Scanner(System.in);

    public void displayEmployeeMenu() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Employee Management System");
        System.out.println("1\tDisplay list of employees\n" +
                "2\tAdd new employee\n" +
                "3\tEdit employee\n" +
                "4\tReturn to main menu\n");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                display();
                break;
            case "2":
                add();
                break;
            case "3":
                edit();
                break;
            case "4":
                FuramaController.displayMainMenu();
                break;
            default:
                displayEmployeeMenu();
        }
    }

    @Override
    public void display() {
        ArrayList<Employee> employeeList = FileUtils.readEmployeeFile();
        System.out.println("The Employee list as below:");
        for (Employee item : employeeList) {
            System.out.println(item);
        }
        System.out.println(BACK_TO_MENU);
        String press = sc.nextLine();
        this.displayEmployeeMenu();
    }

    @Override
    public void add() {
        System.out.println("=== Adding Employee Terminal ===");
        ArrayList<Employee> employees = FileUtils.readEmployeeFile();
        Employee newEmployee = createEmployeeInforSet();
        employees.add(newEmployee);
        FileUtils.writeEmployeeFile(employees);
        System.out.println("New employee added."+BACK_TO_MENU);
        String press = sc.nextLine();
        this.displayEmployeeMenu();
    }

    @Override
    public void edit() {
        ArrayList<Employee> employees = FileUtils.readEmployeeFile();
        int idx = -1;
        System.out.println("Edit Employee Terminal");
        System.out.println("Please input StaffID:");
        String search = sc.nextLine();
        while (!search.matches(STAFF_ID_PATTERN)){
            System.err.println(WRONG_INPUT);
            search = sc.nextLine();
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getStaffID().equalsIgnoreCase(search)) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            System.out.println("Employee found!");
            System.out.println(employees.get(idx));
            System.out.println("Enter 1 to edit employee's information");
            String confirm = sc.nextLine();
            if (confirm.equals(("1"))) {
                Employee updatedEmployee = createEmployeeInforSet();
                employees.set(idx,updatedEmployee);
                FileUtils.writeEmployeeFile(employees);
                System.out.println("Employee information has been updated.");
            }
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println(BACK_TO_MENU);
        String back = sc.nextLine();
        this.displayEmployeeMenu();
        }

    public Employee createEmployeeInforSet() {
        System.out.println("Staff ID:");
        String staffID = sc.nextLine();
        boolean validate = validateStaffID(staffID);
        while ((!staffID.matches(STAFF_ID_PATTERN)) || validate) {
            if (!staffID.matches(STAFF_ID_PATTERN)) {
                System.err.println(WRONG_INPUT);
            }
            if (validate) {
                System.err.println("StaffID is not available, please re-do: ");
            }
            staffID = sc.nextLine();
            validate = validateStaffID(staffID);
        }
        System.out.println("Name:");
        String name = sc.nextLine();
        while (!name.matches(NAME_PATTERN)){
            System.err.println(WRONG_INPUT);
            name = sc.nextLine();
        }
        LocalDate birthday = DateUtils.inputBirthday();
        System.out.println("Gender:");
        String gender = sc.nextLine();
        while (!gender.matches(GENDER_PATTERN)){
            System.err.println(WRONG_INPUT);
            gender = sc.nextLine();
        }
        System.out.println("ID:");
        String id = sc.nextLine();
        while (!id.matches(ID_PATTERN)){
            System.err.println(WRONG_INPUT);
            id = sc.nextLine();
        }
        System.out.println("Telephone number:");
        String tel = sc.nextLine();
        while (!tel.matches(PHONE_PATTERN)){
            System.err.println(WRONG_INPUT);
            tel = sc.nextLine();
        }
        System.out.println("Email:");
        String email = sc.nextLine();
        while (!email.matches(EMAIL_PATTERN)){
            System.err.println(WRONG_INPUT);
            email = sc.nextLine();
        }
        System.out.println("Academic Level:");
        String academicLevel = sc.nextLine();
        while (!academicLevel.matches(ACADEMIC_LEVEL_PATTERN)){
            System.err.println(WRONG_INPUT);
            academicLevel = sc.nextLine();
        }
        System.out.println("Position:");
        String position = sc.nextLine();
        while (!position.matches(POSITION_PATTERN)){
            System.err.println(WRONG_INPUT);
            position = sc.nextLine();
        }
        System.out.println("Salary:");
        String inputSalary = sc.nextLine();
        while (!inputSalary.matches(SALARY_PATTERN)){
            System.err.println(WRONG_INPUT);
            inputSalary = sc.nextLine();
        }
        int salary = parseInt(inputSalary);
        return new Employee(staffID, name, birthday, gender, id, tel, email, academicLevel, position, salary);
    }

    public boolean validateStaffID(String input){
        ArrayList<Employee> employees = FileUtils.readEmployeeFile();
        for (Employee employee : employees) {
            if(employee.getStaffID().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}
