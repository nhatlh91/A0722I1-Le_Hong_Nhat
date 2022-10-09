package ss02_looping.thuc_hanh;
import java.util.Scanner;
public class Interest {
    public static void main(String[] args) {
        double money, interestRate, totalInterest = 0;
        int month;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so tien gui: ");
        money = input.nextDouble();
        System.out.print("Nhap so thang gui: ");
        month = input.nextInt();
        System.out.print("Nhap lai suat theo nam: ");
        interestRate = input.nextDouble();
        for (int i=0; i<month; i++) {
            totalInterest += money*(interestRate/100)/12;
        }
        System.out.print("So tien lai la: "+totalInterest);
    }

}
