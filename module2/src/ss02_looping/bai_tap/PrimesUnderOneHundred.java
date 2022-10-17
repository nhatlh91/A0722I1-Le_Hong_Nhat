package ss02_looping.bai_tap;
public class PrimesUnderOneHundred {
    public static void main(String[] args) {
        int number = 2;
        while (number < 100) {
            int count = 0;
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.print(number + " ");
            }
            number++;
        }
    }
}
