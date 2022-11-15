package ss06_inherritane.bai_tap;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào lần lượt các giá trị màu sắc , độ dài 3 cạnh của tam giác:");
        String color = input.nextLine();
        double sideA = input.nextDouble();
        double sideB = input.nextDouble();
        double sideC = input.nextDouble();
      Triangle triangleA = new Triangle(color, sideA, sideB, sideC);
        System.out.println(triangleA);
    }
}
