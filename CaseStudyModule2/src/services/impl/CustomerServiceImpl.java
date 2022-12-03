package services.impl;

import controllers.FuramaController;
import models.Customer;
import services.CustomerService;
import utils.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService, Pattern {
    private static Scanner sc = new Scanner(System.in);

    public void displayCustomerMenu() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Customer Management System");
        System.out.println("1\tDisplay list of customers\n" +
                "2\tAdd new customer\n" +
                "3\tEdit customer\n" +
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
                displayCustomerMenu();
        }
    }

    @Override
    public void display() {
        LinkedList<Customer> customerList = FileUtils.readCustomerFile();
        System.out.println("The Customer list as below:");
        for (Customer item : customerList) {
            System.out.println(item);
        }
        System.out.println(BACK_TO_MENU);
        String press = sc.nextLine();
        this.displayCustomerMenu();
    }

    @Override
    public void add() {
        LinkedList<Customer> customers = FileUtils.readCustomerFile();
        System.out.println("=== Adding Customer Terminal ===");
        Customer newCustomer = createCustomerInforSet();
        customers.add(newCustomer);
        FileUtils.writeCustomerFile(customers);
        System.out.println("New Customer added.\n" + BACK_TO_MENU);
        String back = sc.nextLine();
        this.displayCustomerMenu();
    }


    @Override
    public void edit() {
        LinkedList<Customer> customers = FileUtils.readCustomerFile();
        int idx = -1;
        System.out.println("Edit Customer Terminal");
        System.out.println("Please input CustomerID:");
        String search = sc.nextLine();
        while (!search.matches(CUSTOMER_ID_PATTERN)){
            System.err.println("Enter CustomerID with wrong pattern, please re-do:");
            search = sc.nextLine();
        }
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerID().equalsIgnoreCase(search)) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            System.out.println("Customer found !");
            System.out.println(customers.get(idx));
            System.out.println("Enter 1 to edit customer's information");
            String confirm = sc.nextLine();
            if (confirm.equals(("1"))) {
             Customer updatedCustomer = createCustomerInforSet();
             customers.set(idx,updatedCustomer);
             FileUtils.writeCustomerFile(customers);
             System.out.println("Customer information has been updated.");
            }
        } else {
            System.out.println("Customer not found.");
        }
        System.out.println(BACK_TO_MENU);
        String back = sc.nextLine();
        this.displayCustomerMenu();
    }
    public Customer createCustomerInforSet(){
        System.out.println("CustomerID:");
        String customerID = sc.nextLine();
        boolean validate = valiadateCustomerID(customerID);
        while ((!customerID.matches(STAFF_ID_PATTERN))||validate) {
            if (!customerID.matches(STAFF_ID_PATTERN)) {
                System.err.println(WRONG_INPUT);
            }
            if (validate) {
                System.err.println("StaffID is not available, please re-do: ");
            }
            customerID = sc.nextLine();
            validate = valiadateCustomerID(customerID);
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
        System.out.println("Type of customer:");
        String typeOfCustomer = sc.nextLine();
        while (!typeOfCustomer.matches(CUSTOMER_TYPE_PATTERN)){
            System.err.println(WRONG_INPUT);
            typeOfCustomer = sc.nextLine();
        }
        System.out.println("Address:");
        String address = sc.nextLine();
        while (!address.matches(ADDRESS_PATTERN)){
            System.err.println(WRONG_INPUT);
            address = sc.nextLine();
        }
        return new Customer(customerID, name, birthday, gender, id, tel, email, typeOfCustomer, address);
    }

    public boolean valiadateCustomerID(String customerID) {
        LinkedList<Customer> customers = FileUtils.readCustomerFile();
        for (Customer customer : customers) {
            if(customer.getCustomerID().equalsIgnoreCase(customerID)) {
                return true;
            }
        }
        return false;
    }
}
