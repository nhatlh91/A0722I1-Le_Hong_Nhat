package ss01_java_overal.thuc_hanh;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bạn muốn xem số ngày của tháng mấy ?");

        int month = scanner.nextInt();

        switch (month) {
            case 2 -> System.out.println("Tháng " + month + " có 28 ngày");
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("Tháng " + month + " có 31 ngày");
            case 4, 6, 9, 11 -> System.out.println("Tháng " + month + " có 30 ngày");
            default -> System.out.println("Bạn nhập sai");
        }
    }
}
