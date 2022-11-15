package ss12_searching_algorithm.bai_tap;

import java.util.*;

public class FindMaximumSubsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Character> myList = new ArrayList<>();
        Queue<Character> inputQueue = new LinkedList<>();
        System.out.print("Nhap chuoi: ");
        String inputString = input.nextLine();
        for (int i = 0; i < inputString.length(); i++) {
            inputQueue.add(inputString.charAt(i));
        }
        System.out.println(inputQueue);
        if (!inputQueue.isEmpty()) {
            myList.add(inputQueue.poll());
        }
        while (!inputQueue.isEmpty()) {
            char temp = inputQueue.poll();
            System.out.print(temp + "\t");
            if (temp > myList.get(myList.size() - 1)) {
                myList.add(temp);
            }
        }
        System.out.println(myList);
    }
}
