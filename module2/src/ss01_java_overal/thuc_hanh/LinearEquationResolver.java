package ss01_java_overal.thuc_hanh;
import java.util.Scanner;
public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Chương trình giải phương trình bậc nhất");
        System.out.println("Nhập vào các tham số a/b/c theo thứ tự ax+b=c");

        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();

        if(a!=0) {
                        double answer = (c-b)/a;
            System.out.println("x = "+answer);
        } else {
            if (b==c) {
                System.out.println("Phương trình có vô số nghiệm");
            } else {
                System.out.println("Phương trình vô ");
            }
        }

    }
}
