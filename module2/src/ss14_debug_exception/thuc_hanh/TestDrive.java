package ss14_debug_exception.thuc_hanh;

import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao 2 so a & b");
        boolean flag = true;
        while (flag)
        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = a / b;
            System.out.println("Thuong cua 2 so la " + c);
            flag = false;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            flag = true;
        }
        System.out.println("Chuong trinh khong bi ket thuc dot ngot");
        System.out.println("Cac khoi lenh benh duoi van duoc thuc thi");
    }
}
