package ss12_searching_algorithm.bai_tap;

import java.util.ArrayList;
import java.util.Scanner;

public class FindLongestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi vao:");
        String input = sc.nextLine();
        ArrayList<ArrayList<Character>> myList = new ArrayList<>();
        ArrayList<Character> tempList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char tempChar = input.charAt(i);
            if (tempList.isEmpty()) {
                tempList.add(tempChar);
            } else {
                if (tempChar > tempList.get(tempList.size() - 1)) {
                    tempList.add(tempChar);
                } else {
                    myList.add((ArrayList<Character>) tempList.clone());
                    tempList.clear();
                    tempList.add(tempChar);
                }
            }
        }
        myList.add((ArrayList<Character>) tempList.clone());
        System.out.println("The list is:\n" + myList);
        ArrayList<Character> result = new ArrayList<>();
        for (ArrayList<Character> item : myList) {
            if (item.size() > result.size()) {
                result = (ArrayList<Character>) item.clone();
            }
        }
        System.out.println("The result is:");
        for (char item : result) {
            System.out.print(item);
        }
    }
}
