package ss10_queue_stack.bai_tap;

import java.util.Stack;

public class ReverseAnIntArray {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack();
        int[] myArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : myArray) {
            myStack.push(i);
        }
        System.out.println(myStack);
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + "\t");
        }
    }
}
