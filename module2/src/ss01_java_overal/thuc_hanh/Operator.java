package ss01_java_overal.thuc_hanh;
import java.util.Scanner;
public class Operator {
    public static void main(String[] args) {
        float width, height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = scanner.nextFloat();
        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        float area = width*height;
        System.out.println("Area is: "+area);

    }
}
