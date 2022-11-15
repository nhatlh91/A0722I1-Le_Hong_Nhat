package ss01_java_overal.thuc_hanh;
import java.util.Scanner;
public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap can nang (kg):");
        double weight = scanner.nextDouble();
        System.out.println("Nhap chieu cao (kg):");
        double height = scanner.nextDouble();

        double bmi = (weight / Math.pow(height,2));

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
