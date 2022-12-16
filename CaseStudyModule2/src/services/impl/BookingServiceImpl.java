package services.impl;

import controllers.FuramaController;
import models.*;
import utils.DateUtils;
import utils.FileUtils;
import utils.Pattern;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class BookingServiceImpl implements Pattern {
    private Scanner sc = new Scanner(System.in);

    public void displayBookingMenu() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Facility Management System");
        System.out.println("1\tAdd a new booking\n" +
                "2\tDisplay list of booking\n" +
                "3\tCreate a new contracts\n" +
                "4\tDisplay list of contracts\n" +
                "5\tEdit contracts\n" +
                "6\tReturn to main menu");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                addNewBooking();
                break;
            case "2":
                displayBookings();
                break;
            case "3":
                addNewContract();
                break;
            case "4":
                displayContracts();
                break;
            case "5":
                editContract();
                break;
            case "6":
                FuramaController.displayMainMenu();
                break;
            default:
                System.err.println("Wrong input, please re-choose");
                displayBookingMenu();
        }
    }

    public void addNewBooking(){
        boolean needContract = false;
        System.out.println("Booking for:");
        System.out.println("1\tVilla");
        System.out.println("2\tHouse");
        System.out.println("3\tRoom");
        String choose = sc.nextLine();
        TreeSet<Booking> bookings = FileUtils.readBookingFile();
        LinkedList<Customer> customers = FileUtils.readCustomerFile();
        System.out.println("Customer list:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        switch (choose) {
            case "1":
                needContract = true;
                LinkedHashMap<Villa, Integer> villas = FileUtils.readVillaFile();
                System.out.println("Villa list:");
                for (Villa villa : villas.keySet()) {
                    System.out.println(villa.toString() + ", has been used " + villas.get(villa) + " times ");
                }
                break;
            case "2":
                needContract = true;
                LinkedHashMap<House, Integer> houses = FileUtils.readHouseFile();
                System.out.println("House list:");
                for (House house : houses.keySet()) {
                    System.out.println(house.toString() + ", has been used " + houses.get(house) + " times ");
                }
                break;
            case "3":
                LinkedHashMap<Room, Integer> rooms = FileUtils.readRoomFile();
                System.out.println("Room list:");
                for (Room room : rooms.keySet()) {
                    System.out.println(room.toString() + ", has been used " + rooms.get(room) + " times ");
                }
                break;
            default:
                addNewBooking();
        }

        System.out.println("Booking ID:");
        String bookingID = sc.nextLine();
        while (!bookingID.matches(BOOKING_ID_PATTERN)) {
            System.out.println(WRONG_INPUT);
            bookingID = sc.nextLine();
        }
        System.out.println("Checkin:");
        LocalDate checkin = DateUtils.inputDate();
        System.out.println("Checkout:");
        LocalDate checkout = DateUtils.inputDate();
        while (checkout.isBefore(checkin)) {
            System.out.println("Check-out time must be after check-in time");
            checkout = DateUtils.inputDate();
        }
        System.out.println("Customer ID:");
        String customerID = sc.nextLine();
        System.out.println("Facility name:");
        String facilityName = sc.nextLine();
        System.out.println("Facility type:");
        String typeOfFacility = sc.nextLine();
        LocalDate bookingDay = LocalDate.now();
        Booking newBooking = new Booking(bookingID,checkin,checkout,customerID,facilityName,typeOfFacility,bookingDay);
        bookings.add(newBooking);
        FileUtils.writeBookingFile(bookings);
        if (needContract) {
            System.out.println("Using villa and house facility must have contract.");
        }
        System.out.println(BACK_TO_MENU);
        String press = sc.nextLine();
        displayBookingMenu();
    }

    public void displayBookings(){
        TreeSet<Booking> bookings = FileUtils.readBookingFile();
        System.out.println("Booking list:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
        System.out.println(BACK_TO_MENU);
        String press = sc.nextLine();
        displayBookingMenu();
    }

    public void addNewContract(){
        TreeSet<Booking> bookings = FileUtils.readBookingFile2();
        Queue<Booking> bookingQueue = new LinkedList<>();
        LinkedList<Contract> contracts = new LinkedList<>();
        for (Booking booking : bookings) {
            if (!booking.getTypeOfFacility().equals("Room")) {
                bookingQueue.add(booking);
            }
        }
        while (!bookingQueue.isEmpty()){
            Booking temp = bookingQueue.remove();
            System.out.println("Making contract for booking:\n"+ temp);
            System.out.println("Booking No.: " + temp.getBookingID());
            System.out.println("CustomerID: " + temp.getCustomerID());
            System.out.println("Contract No.:");
            String contractNo = sc.nextLine();
            System.out.println("Deposit:");
            double deposit = Double.parseDouble(sc.nextLine());
            System.out.println("Total amount:");
            double totalAmount = Double.parseDouble(sc.nextLine());
            contracts.add(new Contract(contractNo, temp.getBookingID(),deposit,totalAmount,temp.getCustomerID()));
            }
    }

    public void displayContracts(){

    }

    public void editContract(){

    }
}
