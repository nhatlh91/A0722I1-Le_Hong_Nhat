package services.impl;

import controllers.FuramaController;
import models.*;
import services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    Scanner input = new Scanner(System.in);
    static LinkedHashMap<Facility, Integer> facilityList = new LinkedHashMap<>();
    static {
        facilityList.put(new Villa("Villa1",100,400,5, "Month","Standard",20.0,2),1);
        facilityList.put(new Villa("Villa2",150,500,7, "Day","Extra",22.0,1),3);
        facilityList.put(new House("House1",180,700,10, "Year","Large",1),4);
        facilityList.put(new House("House2",110,600,5, "Month","Small",3),5);
        facilityList.put(new Room("Room1",100,400,5, "Hour","Free Wifi"),2);
    }
    @Override
    public void display() {
        System.out.println("The facility list as below:");
        for (Facility item : facilityList.keySet()) {
            System.out.println(item.toString() + "\t has been used " + facilityList.get(item)+" times ");
        }
        this.displayFacilityMenu();
    }

    @Override
    public void add() {
        System.out.println("Facility Adding console");
        System.out.println("1\tAdd a new Villa\n" +
                "2\tAdd a new House\n" +
                "3\tAdd a new Room\n" +
                "4\tReturn to main menu\n");
        int choose = Integer.parseInt(input.nextLine());
        if(choose!=1&&choose!=2&choose!=3) {
            this.displayFacilityMenu();
        } else {
            System.out.print("Name of service: ");
            String nameOfService = input.nextLine();
            System.out.print("Area: ");
            double usingArea = Double.parseDouble(input.nextLine());
            System.out.print("Expense: ");
            double expense = Double.parseDouble(input.nextLine());
            System.out.print("Max capacity: ");
            int maxOfPeople = Integer.parseInt(input.nextLine());
            System.out.print("Type of rent: ");
            String typeOfRent = input.nextLine();
            if (choose==1) {
                System.out.print("Room standard: ");
                String roomStandard = input.nextLine();
                System.out.print("Area of pool: ");
                double poolArea = Double.parseDouble(input.nextLine());
                System.out.print("Number of floor: ");
                int floor = Integer.parseInt(input.nextLine());
                facilityList.put(new Villa(nameOfService,usingArea,expense,maxOfPeople,typeOfRent,roomStandard,poolArea,floor),0);
            } else if(choose==2) {
                System.out.print("Room standard: ");
                String roomStandard = input.nextLine();
                System.out.print("Number of floor: ");
                int floor = Integer.parseInt(input.nextLine());
                facilityList.put(new House(nameOfService,usingArea,expense,maxOfPeople,typeOfRent,roomStandard,floor),0);
            } else {
                System.out.print("Extra services: ");
                String extraService = input.nextLine();
                facilityList.put(new Room(nameOfService,usingArea,expense,maxOfPeople,typeOfRent,extraService),0);
            }
        }
        System.out.println("New facility added successfully!!");
        System.out.println("1\tAdd more facility");
        System.out.println("2\tDisplay facility list");
        System.out.println("3\tGo back to facility management console");
        int press = Integer.parseInt(input.nextLine());
        switch (press) {
            case 1 -> this.add();
            case 2 -> this.display();
            default -> this.displayFacilityMenu();
        }

    }
    @Override
    public void edit() {
//this function has not been opened yet.
    }

    @Override
    public void remove() {
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
            case 1 -> this.display();
            case 2 -> this.add();
            case 3 -> this.needMaintain();
            case 4 -> FuramaController.displayMainMenu();
            default -> {
                System.out.println("Wrong input, please re-choose");
                this.displayFacilityMenu();
            }
        }
    }



}
