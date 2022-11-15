package ss10_queue_stack.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class ReverseAnString {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Input the string");
        String inputString = input.nextLine();
        String[] inputStringArr = inputString.split("");
        for (String item : inputStringArr) {
            stringStack.push(item);
        }
        System.out.println(stringStack);
        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.pop());
        }
    }
}
