package ss14_debug_exception.bai_tap;

import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {
        int age;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao:");
        boolean flag = true;
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                System.out.println("Age: "+age);
                flag = false;
            } catch (NumberFormatException e) {
                System.err.println("Nhap sai, nhap lai: ");
                flag = true;
            }
        }
    }
}
