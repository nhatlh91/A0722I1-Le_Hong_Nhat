package service.implement;

import model.Account;
import model.PayingAccount;
import model.SavingAccount;
import utils.DateUtils;
import utils.FileUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountManagement {
    static Scanner sc = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG");
        System.out.println("Chọn chức năng theo số để (đế tiếp tục)");
        System.out.println("1.\tThêm mới\n" +
                "2.\tXóa\n" +
                "3.\tXem danh sách tài khoản ngân hàng\n" +
                "4.\tTìm kiếm\n" +
                "5.\tThoát\n");
        System.out.println("Chọn chức năng");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                add();
                break;
            case "2":
                delete();
                break;
            case "3":
                display();
                break;
            case "4":
                search();
                break;
            case "5":
                System.exit(5);
                break;
            default: {
                System.out.println("Wrong input. Please re-choose");
                displayMainMenu();
                break;
            }
        }
    }

    public void add() {
        ArrayList<Account> accounts = FileUtils.readFromFile();
        int id = accounts.isEmpty() ? 1 : accounts.get(accounts.size() - 1).getId() + 1;
        System.out.println("Chọn loại tài khoản:");
        System.out.println("1\tTài khoản tiết kiệm");
        System.out.println("2\tTài khoản thanh toán");
        String typeOfAccount = sc.nextLine();
        System.out.println("Id tài khoản: " + id);
        System.out.println("Mã tài khoản: ");
        String accountID = sc.nextLine();
        System.out.println("Chủ tài khoản: ");
        String accountOwner = sc.nextLine();
        System.out.println("Ngày tạo tài khoản: ");
        LocalDate createDate = DateUtils.inputDate();
        if (typeOfAccount.equals("1")) {
            System.out.println("Số tiền gởi tiêt kiệm: ");
            double savingAmount = Double.parseDouble(sc.nextLine());
            while (!(savingAmount > 0)) {
                System.err.println("Số tiền trong tài khoản phải là số dương, vui lòng nhập lại");
                savingAmount = Double.parseDouble(sc.nextLine());
            }
            System.out.println("Ngày gởi tiết kiệm: ");
            LocalDate beginDate = DateUtils.inputDate();
            System.out.println("Lãi suất: ");
            double interestRate = Double.parseDouble(sc.nextLine());
            System.out.println("Kỳ hạn (tháng): ");
            int term = Integer.parseInt(sc.nextLine());
            accounts.add(new SavingAccount(id, accountID, accountOwner, createDate, savingAmount, beginDate, interestRate, term));
            FileUtils.writeToFile(accounts);
            System.out.println("Đã thêm thành công, quay về menu chính");
            displayMainMenu();
        } else if (typeOfAccount.equals("2")) {
            System.out.println("Số thẻ: ");
            String cardNumber = sc.nextLine();
            System.out.println("Số tiền trong tài khoản: ");
            double moneyAmount = Double.parseDouble(sc.nextLine());
            while (!(moneyAmount > 0)) {
                System.err.println("Số tiền trong tài khoản phải là số dương, vui lòng nhập lại");
                moneyAmount = Double.parseDouble(sc.nextLine());
            }
            accounts.add(new PayingAccount(id, accountID, accountOwner, createDate, cardNumber, moneyAmount));
            FileUtils.writeToFile(accounts);
            System.out.println("Đã thêm thành công, quay về menu chính");
            displayMainMenu();
        } else {
            System.out.println("Bạn chọn sai loại tài khoản, quay về menu chính");
            displayMainMenu();
        }

    }

    public void delete() {
        System.out.println("Nhập vào mã tài khoản: ");
        String search = sc.nextLine();
        ArrayList<Account> accounts = FileUtils.readFromFile();
        for (Account account : accounts) {
            if (account.getAccountID().equalsIgnoreCase(search)) {
                System.out.println("Tìm thấy tài khoản với thông tin như sau:");
                System.out.println(account);
                System.out.println("1.\t Xác nhận xóa");
                System.out.println("2.\t Hủy thao tác");
                String choose = sc.nextLine();
                if (choose.equals("1")) {
                    accounts.remove(account);
                    System.out.println("Đã xóa tài khoản, danh sách tài khoản còn lại là");
                } else {
                    displayMainMenu();
                    return;
                }
            }
        }
        for (Account account : accounts) {
            System.out.println(account);
        }
        FileUtils.writeToFile(accounts);
        displayMainMenu();
    }

    public void display() {
        System.out.println("Danh sách tài khoản ngân hàng:");
        ArrayList<Account> accounts = FileUtils.readFromFile();
        for (Account account : accounts) {
            System.out.println(account);
        }
        displayMainMenu();
    }

    public void search() {
        ArrayList<Account> accounts = FileUtils.readFromFile();
        boolean flag = false;
        String search;
        System.out.println("Tìm kiếm tài khoản ngân hàng:");
        System.out.println("1.\tTìm kiếm theo Mã tài khoản");
        System.out.println("2.\tTìm kiếm theo tên");
        String choose = sc.nextLine();
        if (choose.equals("1")) {
            System.out.println("Nhập vào mã tài khoản muốn tìm kiếm");
            search = sc.nextLine();
            for (Account account : accounts) {
                if (account.getAccountID().equalsIgnoreCase(search)) {
                    System.out.println(account);
                    flag = true;
                }
            }
        } else {
            System.out.println("Nhập vào tên tài khoản muốn tìm kiếm");
            search = sc.nextLine();
            for (Account account : accounts) {
                if (account.getAccountOwner().contains(search)) {
                    System.out.println(account);
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("Tìm kiếm không có kết quả");
        }
        System.out.println("Thao tác hoàn tất, quay về menu chính");
        displayMainMenu();
    }
}
