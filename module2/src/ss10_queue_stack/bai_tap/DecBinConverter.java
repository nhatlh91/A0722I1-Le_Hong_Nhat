package ss10_queue_stack.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class DecBinConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> myStack = new Stack();
        System.out.print("Input the number in decimal: ");
        int in = input.nextInt();
        while(in!=0) {
            int temp = in%2;
            myStack.push(temp);
            in = in/2;
        }
        System.out.print("The binary number is: ");
        while(!myStack.isEmpty()) {
            System.out.print(myStack.pop());
        }
    }
}
