package ss10_queue_stack.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class BracketCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap bieu thuc can kiem tra");
        String inputString = input.nextLine();
        System.out.println(checker(inputString) ? "\nSu dung dau ngoac dung" : "\nSu dung dau ngoac sai");

    }

    public static boolean checker(String inputString) {
        Stack<Character> bStack = new Stack();
        for (int i = 0; i < inputString.length(); i++) {
            System.out.print(inputString.charAt(i));
            if (inputString.charAt(i) == '(') {
                bStack.push(inputString.charAt(i));
            }
            if (inputString.charAt(i) == ')') {
                if (!bStack.isEmpty()) {
                    bStack.pop();
                } else return false;
            }
        }
        return bStack.isEmpty();
    }
}
