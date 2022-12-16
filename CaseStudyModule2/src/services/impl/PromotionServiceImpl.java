package services.impl;

import controllers.FuramaController;
import services.Service;

import java.util.Scanner;

public class PromotionServiceImpl {
    private Scanner sc = new Scanner(System.in);

    public void displayPromotionMenu() {
        System.out.println("Furama Resort Controller System");
        System.out.println("Promotion Management System");
        System.out.println("1\tDisplay list customers use service\n" +
                "2\tDisplay list customers get voucher\n" +
                "3\tReturn to main menu");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                displayCustomersUseService();
                break;
            case "2":
                displayCustomersGetVoucher();
                break;
            case "3":
                FuramaController.displayMainMenu();
                break;
            default:
                System.err.println("Wrong input, please re-choose");
                displayPromotionMenu();
        }
    }

    public void displayCustomersUseService() {

    }

    public void displayCustomersGetVoucher() {

    }

    public void edit() {

    }
}
