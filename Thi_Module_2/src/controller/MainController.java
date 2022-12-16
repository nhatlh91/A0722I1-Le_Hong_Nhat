package controller;

import service.implement.BankAccountManagement;

public class MainController {
    public static void main(String[] args) {
       BankAccountManagement mainController = new BankAccountManagement();
        mainController.displayMainMenu();
    }
    }