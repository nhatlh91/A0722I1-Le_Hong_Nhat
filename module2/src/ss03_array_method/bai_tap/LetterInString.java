package ss03_array_method.bai_tap;

import java.util.Scanner;

public class LetterInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the string:");
        String str = sc.nextLine();
        System.out.println("Input the letter:");
        String letter = sc.nextLine();
        int count = 0;
        System.out.println(str.indexOf(letter));
        while (str.contains(letter)) {
            str = str.substring(str.indexOf(letter) + 1);
            count++;
        }
        System.out.println("The letter " + letter + " appears " + count + " times in your string");
    }
}
