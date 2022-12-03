package services.impl;

import controllers.FuramaController;
import models.House;
import models.Room;
import models.Villa;
import services.FacilityService;
import utils.FileUtils;
import utils.Pattern;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService, Pattern {
    private final Scanner sc = new Scanner(System.in);

    public void displayFacilityMenu() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Facility Management System");
        System.out.println("1\tDisplay list of facility\n" +
                "2\tAdd new facility\n" +
                "3\tDisplay list of facility maintenance\n" +
                "4\tReturn to main menu");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                display();
                break;
            case "2":
                add();
                break;
            case "3":
                needMaintain();
                break;
            case "4":
                FuramaController.displayMainMenu();
                break;
            default:
                System.err.println("Wrong input, please re-choose");
                displayFacilityMenu();
        }
    }

    @Override
    public void display() {
        LinkedHashMap<Villa,Integer> villas = FileUtils.readVillaFile();
        LinkedHashMap<House,Integer> houses = FileUtils.readHouseFile();
        LinkedHashMap<Room,Integer> rooms = FileUtils.readRoomFile();
        System.out.println("The villa list as below:");
        for (Villa villa : villas.keySet()) {
            System.out.println(villa.toString() + ", has been used " + villas.get(villa) + " times ");
        }
        System.out.println("The house list as below:");
        for (House house : houses.keySet()) {
            System.out.println(house.toString() + ", has been used " + houses.get(house) + " times ");
        }
        System.out.println("The room list as below:");
        for (Room room : rooms.keySet()) {
            System.out.println(room.toString() + ", has been used " + rooms.get(room) + " times ");
        }
        System.out.println(BACK_TO_MENU);
        String press = sc.nextLine();
        displayFacilityMenu();
    }

    @Override
    public void add() {
        System.out.println("Facility Adding console");
        System.out.println( "1\tAdd a new Villa\n" +
                "2\tAdd a new House\n" +
                "3\tAdd a new Room\n" +
                "4\tReturn to main menu\n");
        String choose = sc.nextLine();
        if (!choose.equals("1") && !choose.equals("2") & !choose.equals("3")) {
            this.displayFacilityMenu();
        } else {
            System.out.print("Name of facility: ");
            String nameOfFacility = sc.nextLine();
            String pattern = choose.equals("1") ? VILLA_PATTERN : choose.equals("2") ? HOUSE_PATTERN : ROOM_PATTERN;
            while (!nameOfFacility.matches(pattern)) {
                System.err.println(WRONG_INPUT);
                nameOfFacility = sc.nextLine();
            }
            System.out.print("Area: ");
            double usingArea = Double.parseDouble(sc.nextLine());
            while (!validateArea(usingArea)) {
                System.err.println("The total area must not smaller than 30m2. Please re input: ");
                usingArea = Double.parseDouble(sc.nextLine());
            }
            System.out.print("Expense: ");
            double expense = Double.parseDouble(sc.nextLine());
            while (!validateCost(expense)) {
                System.err.println("The price must be more than 0, please re input: ");
                expense = Double.parseDouble(sc.nextLine());
            }
            System.out.print("Max capacity: ");
            int maxOfPeople = Integer.parseInt(sc.nextLine());
            while (!validateCapacity(maxOfPeople)) {
                System.err.println("The capacity mus be between 0 -> 20");
                maxOfPeople = Integer.parseInt(sc.nextLine());
            }
            System.out.print("Type of rent: ");
            String typeOfRent = sc.nextLine();
            while (!typeOfRent.matches(RENT_TYPE_PATTERN)) {
                System.err.println(WRONG_INPUT);
                typeOfRent = sc.nextLine();
            }
            if (choose.equals("1")) {
                System.out.print("Room standard: ");
                String roomStandard = sc.nextLine();
                while (!roomStandard.matches(ROOM_STANDARD_PATTERN)) {
                    System.err.println(WRONG_INPUT);
                    roomStandard = sc.nextLine();
                }
                System.out.print("Area of pool: ");
                double poolArea = Double.parseDouble(sc.nextLine());
                while (!validateArea(poolArea)) {
                    System.err.println("The area of pool is not smaller than 30m2. Please re input: ");
                    poolArea = Double.parseDouble(sc.nextLine());
                }
                System.out.print("Number of floor: ");
                int floor = Integer.parseInt(sc.nextLine());
                while (!validateFloor(floor)) {
                    System.err.println("The number of floor must be positive, please re input: ");
                    floor = Integer.parseInt(sc.nextLine());
                }
                Villa newVilla = new Villa(nameOfFacility, usingArea, expense, maxOfPeople, typeOfRent, roomStandard, poolArea, floor);
                LinkedHashMap<Villa,Integer> villas = FileUtils.readVillaFile();
                villas.put(newVilla,0);
                FileUtils.writeVillaFile(villas);
            } else if (choose.equals("2")) {
                System.out.print("Room standard: ");
                String roomStandard = sc.nextLine();
                while (!roomStandard.matches(ROOM_STANDARD_PATTERN)) {
                    System.err.println(WRONG_INPUT);
                    roomStandard = sc.nextLine();
                }
                System.out.print("Number of floor: ");
                int floor = Integer.parseInt(sc.nextLine());
                House newHouse = new House(nameOfFacility, usingArea, expense, maxOfPeople, typeOfRent, roomStandard, floor);
                LinkedHashMap<House,Integer> houses = FileUtils.readHouseFile();
                houses.put(newHouse,0);
                FileUtils.writeHouseFile(houses);
            } else {
                System.out.print("Extra services: ");
                String extraService = sc.nextLine();
                while (!extraService.matches(EXTRA_SERVICE_PATTERN)) {
                    System.err.println(WRONG_INPUT);
                    extraService = sc.nextLine();
                }
                Room newRoom = new Room(nameOfFacility, usingArea, expense, maxOfPeople, typeOfRent, extraService);
                LinkedHashMap<Room,Integer> rooms = FileUtils.readRoomFile();
                rooms.put(newRoom,0);
                FileUtils.writeRoomFile(rooms);
            }
        }
        System.out.println("New facility added successfully!!");
        System.out.println(BACK_TO_MENU);
        String press = sc.nextLine();
        displayFacilityMenu();
    }

    @Override
    public void edit() {
//this function has not been opened yet.
    }

    @Override
    public void needMaintain() {
        LinkedHashMap<Villa,Integer> villas = FileUtils.readVillaFile();
        LinkedHashMap<House,Integer> houses = FileUtils.readHouseFile();
        LinkedHashMap<Room,Integer> rooms = FileUtils.readRoomFile();
        System.out.println("The facility list as below need to be maintained:");
        for (Villa villa : villas.keySet()) {
            if (villas.get(villa) >= 5) {
                System.out.println(villa.getName() + " has been used " + villas.get(villa) + " times and need to be maintained before next using");
            }
        }
        for (House house : houses.keySet()) {
            if (houses.get(house) >= 5) {
                System.out.println(house.getName() + " has been used " + houses.get(house) + " times and need to be maintained before next using");
            }
        }
        for (Room room : rooms.keySet()) {
            if (rooms.get(room) >= 5) {
                System.out.println(room.getName() + " has been used " + rooms.get(room) + " times and need to be maintained before next using");
            }
        }
        System.out.println(BACK_TO_MENU);
        String press = sc.nextLine();
        displayFacilityMenu();
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

//    public boolean validateNameOfFacility(String name) {
//        char temp = name.charAt(0);
//        if ( temp < 'A' || temp > 'Z' ) {
//            return false;
//        } else {
//            for (int i =1; i<name.length(); i++){
//                temp = name.charAt(i);
//                if (temp < '0' || temp > '9' && temp < 'a' || temp > 'z'){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

}
