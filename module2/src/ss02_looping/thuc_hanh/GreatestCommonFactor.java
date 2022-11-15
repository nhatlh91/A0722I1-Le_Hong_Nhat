package ss02_looping.thuc_hanh;
import  java.util.Scanner;
public class GreatestCommonFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so thu nhat: ");
        int a = input.nextInt();
        System.out.print("Nhap so thu hai: ");
        int b = input.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            System.out.println("Khong co UCLN");
        } else {
            while (a != b) {
                if (a > b)
                    a = a - b;
                else
                    b = b - a;
            }
            System.out.println("UCLN la: " + a);
        }
    }

}
