package ss10_queue_stack.bai_tap;

import java.util.Scanner;
import java.util.TreeMap;

public class CountLetters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TreeMap<String, Integer> myMap = new TreeMap();
        System.out.println("Input your string:");
        String inputString = input.nextLine();
        String[] inputArr = inputString.split("");
        for (String item : inputArr) {
            String lowerCase = item.toLowerCase();
            if (myMap.containsKey(lowerCase)) {
                myMap.put(lowerCase, myMap.get(lowerCase) + 1);
            } else
                myMap.put(lowerCase, 1);
        }
        System.out.println(myMap);
    }
}
