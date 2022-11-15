package services.impl;

import controllers.FuramaController;
import models.Employee;
import services.EmployeeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeServiceImpl implements EmployeeService {
    public static final int INTERMEDIATE = 1;
    public static final int COLLEGE = 2;
    public static final int UNIVERSITY = 3;
    public static final int POSTGRADUATE = 4;

    static ArrayList<Employee> employeeList = new ArrayList();
    static {
        LocalDate birthday = dateInput("16/08/1991");
        employeeList.add(new Employee("Lê Hồng Nhật", birthday, "Male", "205599593",
                "0905598909", "nhatlg@gmail.com", "Staff01", UNIVERSITY, "Director", 5000));
    }


    public static void displayEmployeeMenu() {
        Scanner input = new Scanner(System.in);
        int choose = -1;
        System.out.println("Furama Resort Controller System");
        System.out.println("Employee Management System");
        System.out.println("1\tDisplay list of employees\n" +
                "2\tAdd new employee\n" +
                "3\tEdit employee\n" +
                "4\tReturn to main menu\n");
        choose = input.nextInt();
        switch (choose) {
            case 1:
                displayEmployeeList();
                break;
            case 2:
                addEmployee();
                break;
            case 3:
                editEmployee();
                break;
            case 4:
                FuramaController.displayMainMenu();
                break;
            default:
                System.out.println("Wrong input, please re-choose");
                displayEmployeeMenu();
        }
    }

    private static void displayEmployeeList() {
        Scanner input = new Scanner(System.in);
        System.out.println("The Employee list as below:");
        for (Employee item : employeeList) {
            System.out.println(item);
        }
        System.out.println("Press any key to go back to continue");
        String press = input.nextLine();
        displayEmployeeMenu();
    }
    public static Employee createEmployeeInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of employee:");
        String name = input.nextLine();
        System.out.println("Enter the date of birth:");
        String userInput = input.nextLine();
        LocalDate birthday = dateInput(userInput);
        System.out.println(birthday);
        System.out.println("Gender:");
        String gender = input.nextLine();
        System.out.println("ID:");
        String id = input.nextLine();
        System.out.println("Telephone number:");
        String tel = input.nextLine();
        System.out.println("Email:");
        String email = input.nextLine();
        System.out.println("Staff ID:");
        String staffID = input.nextLine();
        System.out.println("Academic Level:");
        int academicLevel = input.nextInt();
        System.out.println("Position:");
        String position = input.nextLine();
        System.out.println("Salary:");
        int salary = input.nextInt();
        Employee employee = new Employee(name, birthday,gender,id,tel,email,staffID,academicLevel,position, salary);
        return employee;
    }
    private static void addEmployee() {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Adding Employee Terminal ===");
        Employee employee = createEmployeeInfo();
        employeeList.add(employee);
        System.out.println("New employee added. Press any key to go back to menu");
        String press = input.nextLine();
        displayEmployeeMenu();

    }

    private static void editEmployee() {
        Scanner input = new Scanner(System.in);
        System.out.println("Edit Employee Terminal");
        System.out.println("Please input StaffID:");
        String search = input.nextLine();
        for (int i = 0; i<employeeList.size(); i++) {
            if (employeeList.get(i).getStaffID().equals(search)) {
                System.out.println("Employee found, pls input the updated information");
                Employee tempEmployee = createEmployeeInfo();
                employeeList.set(i,tempEmployee);
                System.out.println("Employee infor. updated. Press any key to go back.");
                String press = input.nextLine();
                displayEmployeeMenu();
            }
        }
            System.out.println("Employee not found !!");
            editEmployee();
    }

    public static LocalDate dateInput(String userInput) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(userInput, dateFormat);
        return date ;
    }
}
