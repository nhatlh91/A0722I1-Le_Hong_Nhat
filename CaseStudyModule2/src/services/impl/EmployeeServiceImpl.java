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
    private static final String EMPLOYEE_FILE = "/mnt/01D8F8C16EEA6020/CODEGYM/Git/CaseStudyModule2/src/data/employee.csv";
    public static final String UNCHANGING = " , leave blank for unchanging";
    Scanner sc = new Scanner(System.in);
//    static ArrayList<Employee> employeeList = new ArrayList<>();
//    static {
//        LocalDate birthday = dateInput("16/08/1991");
//        employeeList.add(new Employee("Lê Hồng Nhật", birthday, "Male", "205599593",
//                "0905598909", "nhatlg@gmail.com", "Staff01", "UNIVERSITY", "Director", 5000));
//    }
    public Employee createEmployeeInfo() {
        System.out.println("Staff ID:");
        String staffID = sc.nextLine();
        while (!staffID.matches(STAFF_ID_PATTERN)){
            System.err.println("Enter Staff ID with wrong pattern, please re-do:");
            staffID = sc.nextLine();
        }
        System.out.println("Name:");
        String name = sc.nextLine();
        while (!name.matches(NAME_PATTERN)){
            System.err.println("Entered wrong information, please re-do:");
            name = sc.nextLine();
        }
        LocalDate birthday = DateUtils.inputBirthday();
        System.out.println("Gender:");
        String gender = sc.nextLine();
        while (!gender.matches(GENDER_PATTERN)){
            System.err.println("Entered wrong information, please re-do:");
            gender = sc.nextLine();
        }
        System.out.println("ID:");
        String id = sc.nextLine();
        while (!id.matches(ID_PATTERN)){
            System.err.println("Entered wrong ID, please re-do:");
            id = sc.nextLine();
        }
        System.out.println("Telephone number:");
        String tel = sc.nextLine();
        while (!tel.matches(PHONE_PATTERN)){
            System.err.println("Entered wrong Telephone No., please re-do:");
            tel = sc.nextLine();
        }
        System.out.println("Email:");
        String email = sc.nextLine();
        while (!email.matches(EMAIL_PATTERN)){
            System.err.println("Entered wrong email, please re-do:");
            email = sc.nextLine();
        }
        System.out.println("Academic Level:");
        String academicLevel = sc.nextLine();
        while (!academicLevel.matches(ACADEMIC_LEVEL_PATTERN)){
            System.err.println("Entered wrong academic level, please re-do:");
            academicLevel = sc.nextLine();
        }
        System.out.println("Position:");
        String position = sc.nextLine();
        while (!position.matches(POSITION_PATTERN)){
            System.err.println("Entered wrong position, please re-do:");
            position = sc.nextLine();
        }
        System.out.println("Salary:");
        String input = sc.nextLine();
        while (!input.matches(SALARY_PATTERN)){
            System.err.println("Entered wrong data, please re-do:");
            input = sc.nextLine();
        }
        int salary = parseInt(sc.nextLine());
        return new Employee(staffID, name, birthday, gender, id, tel, email, academicLevel, position, salary);
    }

//    public static LocalDate dateInput(String userInput) {
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return LocalDate.parse(userInput, dateFormat);
//    }
    public void displayEmployeeMenu() {
        int choose;
        System.out.println("Furama Resort Controller System");
        System.out.println("Employee Management System");
        System.out.println("1\tDisplay list of employees\n" +
                "2\tAdd new employee\n" +
                "3\tEdit employee\n" +
                "5\tReturn to main menu\n");
        choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                this.display();
                break;
            case 2:
                this.add();
                break;
            case 3:
                this.edit();
                break;
            case 4:
                FuramaController.displayMainMenu();
                break;
            default:
                System.out.println("Wrong input, please re-choose");
                displayEmployeeMenu();
        }
    }

    @Override
    public void display() {
        ArrayList<Employee> employeeList = FileUtils.readEmployeeListFromFile();
        System.out.println("The Employee list as below:");
        for (Employee item : employeeList) {
            System.out.println(item);
        }
        System.out.println("Press any key to go back");
        String press = sc.nextLine();
        this.displayEmployeeMenu();
    }

    @Override
    public void add() {
        System.out.println("=== Adding Employee Terminal ===");
        Employee employee = createEmployeeInfo();
        FileUtils.addToFile(EMPLOYEE_FILE,employee.toFile());
        System.out.println("New employee added. Press any key to go back to menu");
        String press = sc.nextLine();
        this.displayEmployeeMenu();
    }

    @Override
    public void edit() {
        ArrayList<Employee> employeeList = FileUtils.readEmployeeListFromFile();
        System.out.println("Edit Employee Terminal");
        System.out.println("Please input StaffID:");
        String search = sc.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getStaffID().equalsIgnoreCase(search)) {
                System.out.println("Employee found, pls input the updated information");
                editEmployeeInfor(employeeList.get(i));
                FileUtils.writeEmployeeListToFile(employeeList);
                System.out.println("Employee information have been updated. Press any key to go back.");
                String press = sc.nextLine();
                this.displayEmployeeMenu();
                return;
            }
        }
        System.out.println("Employee not found !!");
        this.edit();
    }

    public void editEmployeeInfor(Employee employeeNeedToBeUpdated) {
        System.out.println("Current StaffID is: " + employeeNeedToBeUpdated.getStaffID()+ UNCHANGING);
        String staffID = sc.nextLine();
        if(!staffID.equals("")) {
            while (!staffID.matches(STAFF_ID_PATTERN)) {
                System.err.println("Enter Staff ID with wrong pattern, please re-do:");
                staffID = sc.nextLine();
            }
            employeeNeedToBeUpdated.setStaffID(staffID);
        }
        System.out.println("Current name is: " + employeeNeedToBeUpdated.getName()+ UNCHANGING);
        String name = sc.nextLine();
        if(!name.equals("")) {
            while (!name.matches(NAME_PATTERN)) {
                System.err.println("Entered wrong information, please re-do:");
                name = sc.nextLine();
            }
            employeeNeedToBeUpdated.setName(name);
        }
        System.out.println("Current DOB is: " + employeeNeedToBeUpdated.getBirthday()+ UNCHANGING);
            employeeNeedToBeUpdated.setBirthday(DateUtils.inputBirthday());

        System.out.println("Current gender is: " + employeeNeedToBeUpdated.getGender()+ UNCHANGING);
        String gender = sc.nextLine();
        if(!gender.equals("")) {
            while (!gender.matches(GENDER_PATTERN)) {
                System.err.println("Entered wrong information, please re-do:");
                gender = sc.nextLine();
            }
            employeeNeedToBeUpdated.setGender(gender);
        }
        System.out.println("Current ID is: " + employeeNeedToBeUpdated.getId()+ UNCHANGING);
        String id = sc.nextLine();
        if(!id.equals("")) {
            while (!id.matches(ID_PATTERN)) {
                System.err.println("Entered wrong ID, please re-do:");
                id = sc.nextLine();
            }
            employeeNeedToBeUpdated.setId(id);
        }
        System.out.println("Current telephone number is: " + employeeNeedToBeUpdated.getTel()+ UNCHANGING);
        String tel = sc.nextLine();
        if(!tel.equals("")) {
            while (!tel.matches(PHONE_PATTERN)) {
                System.err.println("Entered wrong Telephone No., please re-do:");
                tel = sc.nextLine();
            }
            employeeNeedToBeUpdated.setTel(tel);
        }
        System.out.println("Current email is: " + employeeNeedToBeUpdated.getEmail()+ UNCHANGING);
        String email = sc.nextLine();
        if(!email.equals("")) {
            while (!email.matches(EMAIL_PATTERN)) {
                System.err.println("Entered wrong email, please re-do:");
                email = sc.nextLine();
            }
            employeeNeedToBeUpdated.setEmail(email);
        }
        System.out.println("Current academic level is:" + employeeNeedToBeUpdated.getAcademicLevel()+ UNCHANGING);
        String academicLevel = sc.nextLine();
        if(!academicLevel.equals("")) {
            while (!academicLevel.matches(ACADEMIC_LEVEL_PATTERN)) {
                System.err.println("Entered wrong academic level, please re-do:");
                academicLevel = sc.nextLine();
            }
            employeeNeedToBeUpdated.setAcademicLevel(academicLevel);
        }
        System.out.println("Current position is: " + employeeNeedToBeUpdated.getPosition()+ UNCHANGING);
        String position = sc.nextLine();
        if(!position.equals("")) {
            while (!position.matches(POSITION_PATTERN)) {
                System.err.println("Entered wrong position, please re-do:");
                position = sc.nextLine();
            }
            employeeNeedToBeUpdated.setPosition(position);
        }
        System.out.println("Current salary is: " + employeeNeedToBeUpdated.getSalary()+ UNCHANGING);
        String salary = sc.nextLine();
        if(!salary.equals("")) {
            while (!salary.matches(SALARY_PATTERN)) {
                System.err.println("Entered wrong data, please re-do:");
                salary = sc.nextLine();
            }
            employeeNeedToBeUpdated.setSalary(parseInt(salary));
        }
    }


//    public void remove() {
//        System.out.println("Please input StaffID:");
//        String search = input.nextLine();
//        for (int i = 0; i < employeeList.size(); i++) {
//            if (employeeList.get(i).getStaffID().equals(search)) {
//                System.out.println("Employee found, press 1 to confirm removing");
//                int choose = input.nextInt();
//                if (choose == 1) {
//                    employeeList.remove(i);
//                    System.out.println("Employee removed, back to Employee menu");
//                    this.displayEmployeeMenu();
//                } else {
//                    this.displayEmployeeMenu();
//                }
//            }
//        }
//        System.out.println("Employee not found !!");
//        this.remove();
//    }
}
