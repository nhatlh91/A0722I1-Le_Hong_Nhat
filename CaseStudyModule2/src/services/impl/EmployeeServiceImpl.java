package services.impl;

import controllers.FuramaController;
import models.Employee;
import services.EmployeeService;
import utils.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeServiceImpl implements EmployeeService {
    private static final String PATH_FILE = "D:\\CODEGYM\\Git\\CaseStudyModule2\\src\\data\\customer.csv";
    private static final String COMMA = ",";

    static ArrayList<Employee> employeeList = new ArrayList();
    static Scanner input = new Scanner(System.in);
//    static {
//        LocalDate birthday = dateInput("16/08/1991");
//        employeeList.add(new Employee("Lê Hồng Nhật", birthday, "Male", "205599593",
//                "0905598909", "nhatlg@gmail.com", "Staff01", "UNIVERSITY", "Director", 5000));
//    }
    public static Employee createEmployeeInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of employee:");
        String name = input.nextLine();
        System.out.println("Enter the date of birth:");
        String userInput = input.nextLine();
        LocalDate birthday = DateUtils.dateInput(userInput);
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
        String academicLevel = input.nextLine();
        System.out.println("Position:");
        String position = input.nextLine();
        System.out.println("Salary:");
        int salary = Integer.parseInt(input.nextLine());
        return new Employee(name, birthday, gender, id, tel, email, staffID, academicLevel, position, salary);
    }

//    public static LocalDate dateInput(String userInput) {
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return LocalDate.parse(userInput, dateFormat);
//    }
    public void displayEmployeeMenu() {
        int choose = -1;
        System.out.println("Furama Resort Controller System");
        System.out.println("Employee Management System");
        System.out.println("1\tDisplay list of employees\n" +
                "2\tAdd new employee\n" +
                "3\tEdit employee\n" +
                "4\tRemove employee\n" +
                "5\tReturn to main menu\n");
        choose = input.nextInt();
        switch (choose) {
            case 1 -> this.display();
            case 2 -> this.add();
            case 3 -> this.edit();
            case 4 -> this.remove();
            case 5 -> FuramaController.displayMainMenu();
            default -> {
                System.out.println("Wrong input, please re-choose");
                displayEmployeeMenu();
            }
        }
    }

    @Override
    public void display() {
        System.out.println("The Employee list as below:");
        for (Employee item : employeeList) {
            System.out.println(item);
        }
        System.out.println("Press any key to go back");
        String press = input.nextLine();
        this.displayEmployeeMenu();
    }

    @Override
    public void add() {
        System.out.println("=== Adding Employee Terminal ===");
        Employee employee = createEmployeeInfo();
        String writeToFile = employee.getName()+COMMA+employee.getBirthday()+COMMA+employee.getGender()+COMMA+employee.getId()+COMMA+
                employee.getTel()+COMMA+employee.getEmail()+COMMA+employee.getStaffID()+COMMA+employee.getAcademicLevel()+COMMA+employee.getPosition()+COMMA+employee.getSalary();
        employeeList.add(employee);
        System.out.println("New employee added. Press any key to go back to menu");
        String press = input.nextLine();
        this.displayEmployeeMenu();
    }

    @Override
    public void edit() {
        System.out.println("Edit Employee Terminal");
        System.out.println("Please input StaffID:");
        String search = input.nextLine();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getStaffID().equals(search)) {
                System.out.println("Employee found, pls input the updated information");
                Employee tempEmployee = createEmployeeInfo();
                employeeList.set(i, tempEmployee);
//                this.extractToFile(); //Cần phải kiểm tra lại
                System.out.println("Employee infor. updated. Press any key to go back.");
                String press = input.nextLine();
                this.displayEmployeeMenu();
            }
        }
        System.out.println("Employee not found !!");
        this.edit();
    }

    @Override
    public void remove() {
        System.out.println("Please input StaffID:");
        String search = input.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getStaffID().equals(search)) {
                System.out.println("Employee found, press 1 to confirm removing");
                int choose = input.nextInt();
                if (choose == 1) {
                    employeeList.remove(i);
                    System.out.println("Employee removed, back to Employee menu");
                    this.displayEmployeeMenu();
                } else {
                    this.displayEmployeeMenu();
                }
            }
        }
        System.out.println("Employee not found !!");
        this.remove();
    }
}
