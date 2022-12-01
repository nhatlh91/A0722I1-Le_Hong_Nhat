package services.impl;

import controllers.FuramaController;
import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    static LinkedHashMap<Facility, Integer> facilityList = new LinkedHashMap<>();

    static {
        facilityList.put(new Villa("Villa1", 100, 400, 5, "Month", "Standard", 20.0, 2), 1);
        facilityList.put(new Villa("Villa2", 150, 500, 7, "Day", "Extra", 22.0, 1), 3);
        facilityList.put(new House("House1", 180, 700, 10, "Year", "Large", 1), 4);
        facilityList.put(new House("House2", 110, 600, 5, "Month", "Small", 3), 5);
        facilityList.put(new Room("Room1", 100, 400, 5, "Hour", "Free Wifi"), 2);
    }

    Scanner input = new Scanner(System.in);

    @Override
    public void display() {
        System.out.println("The facility list as below:");
        for (Facility item : facilityList.keySet()) {
            System.out.println(item.toString() + "\t has been used " + facilityList.get(item) + " times ");
        }
        this.displayFacilityMenu();
    }

    @Override
    public void add() {
        System.out.println("Facility Adding console");
        System.out.println( "1\tAdd a new Villa\n" +
                            "2\tAdd a new House\n" +
                            "3\tAdd a new Room\n" +
                            "4\tReturn to main menu\n");
        int choose = Integer.parseInt(input.nextLine());
        if (choose != 1 && choose != 2 & choose != 3) {
            this.displayFacilityMenu();
        } else {
            System.out.print("Name of facility: ");
            String nameOfFacility = input.nextLine();
            while (!validateNameOfFacility(nameOfFacility)) {
                System.err.println("The facility name format was wrong. Please re input: ");
                nameOfFacility = input.nextLine();
            }
            System.out.print("Area: ");
            double usingArea = Double.parseDouble(input.nextLine());
            while (!validateArea(usingArea)) {
                System.err.println("The total area must not smaller than 30m2. Please re input: ");
                usingArea = Double.parseDouble(input.nextLine());
            }
            System.out.print("Expense: ");
            double expense = Double.parseDouble(input.nextLine());
            while (!validateCost(expense)) {
                System.err.println("The price must be more than 0, please re input: ");
                expense = Double.parseDouble(input.nextLine());
            }
            System.out.print("Max capacity: ");
            int maxOfPeople = Integer.parseInt(input.nextLine());
            while (!validateCapacity(maxOfPeople)) {
                System.err.println("The capacity mus be between 0 -> 20");
                maxOfPeople = Integer.parseInt(input.nextLine());
            }
            System.out.print("Type of rent: ");
            String typeOfRent = input.nextLine();
            while (!validateNameOfFacility(typeOfRent)) {
                System.err.println("The type of rent format was wrong. Please re input: ");
                typeOfRent = input.nextLine();
            }
            if (choose == 1) {
                System.out.print("Room standard: ");
                String roomStandard = input.nextLine();
                while (!validateNameOfFacility(roomStandard)) {
                    System.err.println("The room standard format was wrong. Please re input: ");
                    roomStandard = input.nextLine();
                }
                System.out.print("Area of pool: ");
                double poolArea = Double.parseDouble(input.nextLine());
                while (!validateArea(poolArea)) {
                    System.err.println("The area of pool is not smaller than 30m2. Please re input: ");
                    poolArea = Double.parseDouble(input.nextLine());
                }
                System.out.print("Number of floor: ");
                int floor = Integer.parseInt(input.nextLine());
                while (!validateFloor(floor)) {
                    System.err.println("The number of floor must be positive, please re input: ");
                    floor = Integer.parseInt(input.nextLine());
                }
                facilityList.put(new Villa(nameOfFacility, usingArea, expense, maxOfPeople, typeOfRent, roomStandard, poolArea, floor), 0);
            } else if (choose == 2) {
                System.out.print("Room standard: ");
                String roomStandard = input.nextLine();
                while (!validateNameOfFacility(roomStandard)) {
                    System.err.println("The room standard format was wrong. Please re input: ");
                    roomStandard = input.nextLine();
                }
                System.out.print("Number of floor: ");
                int floor = Integer.parseInt(input.nextLine());
                facilityList.put(new House(nameOfFacility, usingArea, expense, maxOfPeople, typeOfRent, roomStandard, floor), 0);
            } else {
                System.out.print("Extra services: ");
                String extraService = input.nextLine();
                facilityList.put(new Room(nameOfFacility, usingArea, expense, maxOfPeople, typeOfRent, extraService), 0);
            }
        }
        System.out.println("New facility added successfully!!");
        System.out.println("1\tAdd more facility");
        System.out.println("2\tDisplay facility list");
        System.out.println("3\tGo back to facility management console");
        int press = Integer.parseInt(input.nextLine());
        switch (press) {
            case 1:
                this.add();
                break;
            case 2:
                this.display();
                break;
            default:
                this.displayFacilityMenu();
        }

    }

    @Override
    public void edit() {
//this function has not been opened yet.
    }

    @Override
    public void needMaintain() {
        System.out.println("The facility list as below need to be maintained:");
        for (Facility item : facilityList.keySet()) {
            if (facilityList.get(item) > 4) {
                System.out.println(item.getServiceName() + " has been used " + facilityList.get(item) + " times and need to be maintained before next using");
            }
        }
        this.displayFacilityMenu();
    }

    public void displayFacilityMenu() {

        int choose;
        System.out.println("Furama Resort Controller System");
        System.out.println("Facility Management System");
        System.out.println("1\tDisplay list of facility\n" +
                "2\tAdd new facility\n" +
                "3\tDisplay list of facility maintenance\n" +
                "4\tReturn to main menu\n");
        choose = Integer.parseInt(input.nextLine());
        switch (choose) {
            case 1:
                this.display();
                break;
            case 2:
                this.add();
                break;
            case 3:
                this.needMaintain();
                break;
            case 4:
                FuramaController.displayMainMenu();
                break;
            default:
                System.out.println("Wrong input, please re-choose");
                this.displayFacilityMenu();
        }
    }

    public boolean validateArea(double area) {
        return (area > 30);
    }

    public boolean validateCost(double price) {
        return (price > 0);
    }

    public boolean validateCapacity(int people) {
        return (people > 0 && people < 20);
    }
    public boolean validateFloor(int floors) {
        return (floors > 0);
    }

    public boolean validateNameOfFacility(String name) {
        char temp = name.charAt(0);
        if ( temp < 'A' || temp > 'Z' ) {
            return false;
        } else {
            for (int i =1; i<name.length(); i++){
                temp = name.charAt(i);
                if (temp < '0' || temp > '9' && temp < 'a' || temp > 'z'){
                return false;
                }
            }
        }
        return true;
    }

}
