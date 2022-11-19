package ss14_debug_exception.bai_tap;

import java.util.Scanner;

public class IllegalTriangleException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhẹ nhàng nhập vào 3 giá trị chiều dài muốn kiểm tra: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        try {
            if (!(a > 0 && b > 0 && c > 0)) throw new ArithmeticException();
            else if (!(a + b > c && a + c > b && c + b > a)) throw new ArithmeticException();
            else System.out.println("Ba giá trị nhập vào phù hợp với yêu cầu làm 3 cạnh tam giác");
        } catch (ArithmeticException e) {
            System.err.println("Nhập số không phù hợp");

        } finally {
            System.out.println("Kết thúc chương trình");
        }
    }
}
