package ss01_java_overal.bai_tap;
import java.util.Scanner;
public class ReadTheNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao so can doc: ");
        int number = input.nextInt();

        if (number < 11) {
            switch (number) {
                case 0 -> System.out.println("khong");
                case 1 -> System.out.println("mot");
                case 2 -> System.out.println("hai");
                case 3 -> System.out.println("ba");
                case 4 -> System.out.println("bon");
                case 5 -> System.out.println("nam");
                case 6 -> System.out.println("sau");
                case 7 -> System.out.println("bay");
                case 8 -> System.out.println("tam");
                case 9 -> System.out.println("chin");
                case 10 -> System.out.println("muoi");
            }
        } else if (number < 20) {
                int units = number - 10;
                switch (units) {
                    case 1 -> System.out.println("muoi mot");
                    case 2 -> System.out.println("muoi hai");
                    case 3 -> System.out.println("muoi ba");
                    case 4 -> System.out.println("muoi bon");
                    case 5 -> System.out.println("muoi nam");
                    case 6 -> System.out.println("muoi sau");
                    case 7 -> System.out.println("muoi bay");
                    case 8 -> System.out.println("muoi tam");
                    case 9 -> System.out.println("muoi chin");
                }
            } else if (number<100) {
                int tens = number/10;
                int units = number-tens*10;
                String result = "";
            switch (tens) {
                case 2 -> result += "hai muoi";
                case 3 -> result += "ba muoi";
                case 4 -> result += "bon muoi";
                case 5 -> result += "nam muoi";
                case 6 -> result += "sau muoi";
                case 7 -> result += "bay muoi";
                case 8 -> result += "tam muoi";
                case 9 -> result += "chin muoi";
            }
            switch (units) {
                case 1 -> result += " mot";
                case 2 -> result += " hai";
                case 3 -> result += " ba";
                case 4 -> result += " bon";
                case 5 -> result += " nam";
                case 6 -> result += " sau";
                case 7 -> result += " bay";
                case 8 -> result += " tam";
                case 9 -> result += " chin";
            }
            System.out.println(result);
        } else System.out.println("Phan chuong trinh doc cac so co 3 chu so chua duoc hoan thien");
        }
    }
