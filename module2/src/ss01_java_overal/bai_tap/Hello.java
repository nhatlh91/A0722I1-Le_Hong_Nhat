package ss01_java_overal.bai_tap;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten cua ban: ");
        String name = scanner.nextLine();
        System.out.println("Xin chao "+name);
    }
}
