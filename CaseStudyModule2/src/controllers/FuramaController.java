package controllers;

import services.impl.CustomerServiceImpl;
import services.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    static Scanner input = new Scanner(System.in);
    private static int choose = -1;

    public static void displayMainMenu() {
        System.out.println("Furama Resort Controller System");
        System.out.println("1.\tEmployee Management\n" +
                "2.\tCustomer Management\n" +
                "3.\tFacility Management \n" +
                "4.\tBooking Management\n" +
                "5.\tPromotion Management\n" +
                "6.\tExit\n");
        choose = input.nextInt();
        switch (choose) {
            case 1 -> {
                EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                employeeService.displayEmployeeMenu();
            }
            case 2 -> {
                CustomerServiceImpl customerService = new CustomerServiceImpl();
                customerService.displayCustomerMenu();
            }
            case 3 -> displayFacilityManagement();
            case 4 -> displayBookingManagement();
            case 5 -> displayPromotionManagement();
            case 6 -> System.exit(6);
            default -> {
                System.out.println("Wrong input. Please re-choose");
                displayMainMenu();
            }
        }
    }

    public static void displayCustomerManagement() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Customer Management System");
        System.out.println("1.\tDisplay list customers\n" +
                "2.\tAdd new customer\n" +
                "3.\tEdit customer\n" +
                "4.\tReturn main menu\n");
        choose = input.nextInt();
        switch (choose) {
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("Wrong input, please re-choose");
                displayCustomerManagement();
        }
    }

    private static void displayFacilityManagement() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Facility Management System");
        System.out.println("1\tDisplay list facility\n" +
                "2\tAdd new facility\n" +
                "3\tDisplay list facility maintenance\n" +
                "4\tReturn main menu\n");
        choose = input.nextInt();
        switch (choose) {
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("Wrong input, please re-choose");
                displayFacilityManagement();
        }
    }

    private static void displayBookingManagement() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Booking Management System");
        System.out.println("1.\tAdd new booking\n" +
                "2.\tDisplay list booking\n" +
                "3.\tCreate new constracts\n" +
                "4.\tDisplay list contracts\n" +
                "5.\tEdit contracts\n" +
                "6.\tReturn main menu\n");
        choose = input.nextInt();
        switch (choose) {
            case 6:
                displayMainMenu();
                break;
            default:
                System.out.println("Wrong input, please re-choose");
                displayBookingManagement();
        }
    }

    private static void displayPromotionManagement() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Promotion Management System");
        System.out.println("1.\tDisplay list customers use service\n" +
                "2.\tDisplay list customers get voucher\n" +
                "3.\tReturn main menu\n");
        choose = input.nextInt();
        switch (choose) {
            case 3:
                displayMainMenu();
                break;
            default:
                System.out.println("Wrong input, please re-choose");
                displayPromotionManagement();
        }
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
