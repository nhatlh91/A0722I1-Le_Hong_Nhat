package ss01_java_overal.bai_tap;
import java.util.Scanner;
public class ChangeMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double RATE = 23300;
        System.out.print("Nhap so tien muon quy doi: ");
        double usd = sc.nextDouble();
        System.out.print("So tien quy doi duoc la: "+usd*RATE+" VND");
    }
}
