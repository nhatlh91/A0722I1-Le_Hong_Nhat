package ss02_looping.bai_tap;
import java.util.Scanner;
public class ShowThePrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong so nguyen to muon nhan duoc: ");
        int quantity = sc.nextInt();
        int countA = 0, number = 2;
        while (countA != quantity) {
            int countB = 0;
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    countB++;
                }
            }
            if (countB == 0) {
                System.out.print(number + " ");
                countA++;
            }
            number++;
        }
    }
}
