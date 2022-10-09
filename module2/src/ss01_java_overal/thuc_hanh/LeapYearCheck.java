package ss01_java_overal.thuc_hanh;

import java.util.Scanner;

public class LeapYearCheck {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào số năm cần kiểm tra");

        int year = scanner.nextInt();

        if(year%100==0) {
            if (year%400==0) {
                System.out.println("Nam nhuan");
            } else System.out.println("Khong phai");
        } else {
            if (year % 4 == 0) {
                System.out.println("Nam nhuan");
            } else System.out.println("Khong phai");
        }
    }
}
