package services.impl;

import controllers.FuramaController;
import models.Customer;
import models.Employee;
import services.CustomerService;
import utils.FileUtils;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import static services.impl.EmployeeServiceImpl.dateInput;

public class CustomerServiceImpl implements CustomerService {

    private final String PATH_FILE = "D:\\CODEGYM\\Git\\CaseStudyModule2\\src\\data\\customer.csv";
    private final String COMMA = ",";
    private Scanner input = new Scanner(System.in);
    static LinkedList<Customer> customerList = new LinkedList<>();
//    static {
//        LocalDate birthday = dateInput("16/08/1991");
//        customerList.add(new Customer("Lê Hồng Nhật", birthday, "Male", "205599593",
//                "0905598909", "nhatlg@gmail.com", "Diamond","Hoa Minh, Lien Chieu"));
//        customerList.add(new Customer("Bevis", birthday, "Male", "205599594",
//                "0914638782", "bevis@gmail.com", "Gold","Hoi An"));
//        customerList.add(new Customer("Vincent", birthday, "Male", "205599595",
//                "0911863283", "vincent@gmail.com", "Silver","Vinh Dien, Dien Ban"));
//    }
    public void displayCustomerMenu() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Customer Management System");
        System.out.println("1\tDisplay list of customers\n" +
                "2\tAdd new customer\n" +
                "3\tEdit customer\n" +
                "4\tRemove customer\n" +
                "5\tReturn to main menu\n");
        int choose = Integer.parseInt(input.nextLine());
        switch (choose) {
            case 1 -> this.display();
            case 2 -> this.add();
            case 3 -> this.edit();
            case 4 -> this.remove();
            case 5 -> FuramaController.displayMainMenu();
            default -> {
                System.out.println("Wrong input, please re-choose");
                displayCustomerMenu();
            }
        }
    }
    @Override
    public void display() {
        System.out.println("The Customer list as below:");
        for (Customer item : customerList) {
            System.out.println(item);
        }
        System.out.println("Press any key to go back to menu");
        String press = input.nextLine();
        this.displayCustomerMenu();
    }

    @Override
    public void add() {
        System.out.println("=== Adding Customer Terminal ===");
        customerList.add(createCustomerInforSet());
        System.out.println("New Customer added. Press any key to go back to menu");
        String press = input.nextLine();
        this.displayCustomerMenu();
    }

    @Override
    public void edit() {
        System.out.println("Edit Customer Terminal");
        System.out.println("Please input Customer ID:");
        String search = input.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerID().equals(search)) {
                System.out.println("Customer found, pls input the updated information");
                editCustomerInforSet(i, customerList);
                System.out.println("Customer infor. updated. Press any key to go back.");
                String press = input.nextLine();
                this.displayCustomerMenu();
            }
        }
        System.out.println("Customer not found !!");
        this.edit();
    }

    @Override
    public void remove() {
        System.out.println("Please input CustomerID:");
        String search = input.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerID().equals(search)) {
                System.out.println("Customer found, press 1 to confirm removing");
                int choose = input.nextInt();
                if (choose == 1) {
                    customerList.remove(i);
                    System.out.println("Customer removed, back to Employee menu");
                    this.displayCustomerMenu();
                } else {
                    this.displayCustomerMenu();
                }
            }
        }
        System.out.println("Customer not found !!");
        this.remove();
    }


    public Customer createCustomerInforSet() {
        System.out.println("Name:");
        String name = input.nextLine();
        System.out.println("Date of birth:");
        LocalDate birthday = inputBirthday();
        System.out.println("Gender:");
        String gender = input.nextLine();
        System.out.println("ID:");
        String id = input.nextLine();
        System.out.println("Telephone number:");
        String tel = input.nextLine();
        System.out.println("Email:");
        String email = input.nextLine();
        System.out.println("Type of customer:");
        String typeOfCustomer = input.nextLine();
        System.out.println("Address:");
        String address = input.nextLine();
        return new Customer(name, birthday, gender, id, tel, email, typeOfCustomer, address);
    }

    public void editCustomerInforSet(int index, LinkedList<Customer> list) {
        System.out.println("Current name is: "+list.get(index).getName());
        list.get(index).setName(input.nextLine());
        System.out.println("Current DOB is: "+list.get(index).getBirthday());
        list.get(index).setBirthday(inputBirthday());
        System.out.println("Current gender is: "+list.get(index).getGender());
        list.get(index).setGender(input.nextLine());
        System.out.println("Current ID is: "+list.get(index).getId());
        list.get(index).setId(input.nextLine());
        System.out.println("Current telephone number is: "+list.get(index).getTel());
        list.get(index).setTel(input.nextLine());
        System.out.println("Current email is: "+list.get(index).getEmail());
        list.get(index).setEmail(input.nextLine());
        System.out.println("Current type of customer is:"+list.get(index).getTypeOfCustomer());
        list.get(index).setTypeOfCustomer(input.nextLine());
        System.out.println("Current address is: "+list.get(index).getAddress());
        list.get(index).setAddress(input.nextLine());
    }
    public LocalDate inputBirthday() {
        LocalDate birthday = null;
        String userInput;
        try {
            userInput = input.nextLine();
            birthday = dateInput(userInput);
        }
        catch(DateTimeParseException e) {
            System.err.println("The correct format is \"yyyy-MM-dd\", please re input: ");
            this.inputBirthday();
        }
        if(!ageValidator(birthday)){
            System.err.println("The customer has not meet age requirement!");
            this.displayCustomerMenu();
        }
        return birthday;
    }
    public static boolean ageValidator(LocalDate birthday){
//        int age = LocalDate.now().getYear()-date.getYear();
        int age = Period.between(birthday, LocalDate.now()).getYears();
        return (age >= 18 && age <= 100);
    }

    @Override
    public void extractToFile() {
        for (Customer customer: customerList){
            String content = customer.getName()+COMMA+customer.getBirthday()+COMMA+customer.getGender()+COMMA+customer.getId()+COMMA+
                    customer.getTel()+COMMA+customer.getEmail()+COMMA+customer.getTypeOfCustomer()+COMMA+customer.getAddress();
            FileUtils.writetoFile(PATH_FILE,content);
        }
        System.out.println("Data has been saved successfully!!");
        this.displayCustomerMenu();
    }

    @Override
    public void importFromFile() {
        ArrayList<String> tempArrList = FileUtils.readFromFile(PATH_FILE);
        customerList.clear();
        for (int i = 0; i<tempArrList.size(); i++) {
            String[] tempArr = tempArrList.get(i).split(",");
            customerList.add(new Customer(tempArr[0],dateInput(tempArr[1]),tempArr[2],tempArr[3],tempArr[4],tempArr[5],tempArr[6], tempArr[7]));
        }
        System.out.println("Data has been extracted successfully!!");
        this.displayCustomerMenu();
    }

}
