package services.impl;

import controllers.FuramaController;
import models.Customer;
import services.CustomerService;
import libs.AgeValidateException;
import utils.DateUtils;
import utils.FileUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static final String PATH_CUSTOMER = "D:\\CODEGYM\\Git\\CaseStudyModule2\\src\\data\\customer.csv";
    private static final String COMMA = ",";
    private Scanner input = new Scanner(System.in);
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
        LinkedList<Customer> customerList = readCustomerFile();
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
        LinkedList<Customer> customers = readCustomerFile();
        System.out.println("=== Adding Customer Terminal ===");
        customers.add(createCustomerInforSet());
        writeCustomerFile(customers);
        System.out.println("New Customer added. Press any key to go back to menu");
        String press = input.nextLine();
        this.displayCustomerMenu();
    }

    @Override
    public void edit() {
        LinkedList<Customer> customers = readCustomerFile();
        System.out.println("Edit Customer Terminal");
        System.out.println("Please input Customer ID:");
        String search = input.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerID().equals(search)) {
                System.out.println("Customer found, pls input the updated information");
                editCustomerInforSet(i, customers);
                writeCustomerFile(customers);
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
        System.out.println("This function has not opened yet. Press any key to go back to menu");
        String press = input.nextLine();
        this.displayCustomerMenu();
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
        System.out.println("CustomerID:");
        String customerID = input.nextLine();
        return new Customer(name, birthday, gender, id, tel, email, typeOfCustomer, address, customerID);
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
            birthday = DateUtils.dateInput(userInput);
            if (!DateUtils.ageValidate(birthday)) {
                throw new AgeValidateException();
            }
        }
        catch(DateTimeParseException e) {
            System.err.println("The correct format is \"yyyy-MM-dd\", please re input: ");
            this.inputBirthday();
        } catch (AgeValidateException e) {
            e.noti();
            this.inputBirthday();
        }
        return birthday;
    }
//    public static boolean ageValidator(LocalDate birthday){
//        int age = Period.between(birthday, LocalDate.now()).getYears();
//        return (age >= 18 && age <= 100);
//    }

    public static LinkedList<Customer> readCustomerFile(){
        LinkedList<Customer> customers= new LinkedList<>();
        ArrayList<String> strings = (ArrayList<String>) FileUtils.readFromFile(PATH_CUSTOMER);
        for (String customer : strings){
            String[] prop = customer.split(",");
            customers.add(new Customer(prop[0] , DateUtils.dateInput(prop[1]) , prop[2] , prop[3] , prop[4] , prop[5] , prop[6] , prop[7], prop[8]));
        }
        return customers;
    }

    public static void writeCustomerFile(LinkedList<Customer> customers) {
        ArrayList<String> content = new ArrayList<>();
        for (Customer customer : customers) {
            content.add(customer.toFile());
        }
        FileUtils.writetoFile(PATH_CUSTOMER,content);
    }
}
