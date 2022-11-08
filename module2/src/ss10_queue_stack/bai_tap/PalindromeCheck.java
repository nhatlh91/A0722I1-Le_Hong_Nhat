package ss10_queue_stack.bai_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap chuoi can kiem tra: ");
        String inputString = input.nextLine();
        Stack<Character> myStack = new Stack<>();
        Queue<Character> myQueue = new LinkedList<>();
        for (int i = 0; i < inputString.length(); i++) {
            char temp = inputString.charAt(i);
            myStack.push(temp);
            myQueue.add(temp);
        }
        System.out.println("Stack: " + myStack);
        System.out.println("Queue: " + myQueue);
        while (!myStack.isEmpty()) {
            if (myStack.pop() != myQueue.poll()) {
                System.out.println("Day khong phai la chuoi Palindrome");
                return;
            }
        }
        System.out.println("Day la chuoi Palindrome");
    }
}
