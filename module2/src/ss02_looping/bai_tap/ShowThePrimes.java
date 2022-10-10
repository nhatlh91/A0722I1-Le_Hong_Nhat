package ss02_looping.bai_tap;
import java.util.Scanner;
public class ShowThePrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong so nguyen to muon nhan duoc: ");
        int quantity = sc.nextInt();
        int count1 = 0, number = 2;
        while (count1 != quantity) {
            int count2 = 0;
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    count2++;
                }
            }
            if (count2 == 0) {
                System.out.print(number + " ");
                count1++;
            }
            number++;
        }
    }
}
