package ss03_array_method.bai_tap;

import java.util.Scanner;

public class SumOfCol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[][] arr;
        System.out.print("Input the length of array: ");
        int rows = sc.nextInt();
        System.out.print("Input the depth of array: ");
        int cols = sc.nextInt();
        arr = new float[cols][rows];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Input the element at [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextFloat();
            }
        }
        System.out.println("Your array: ");
        for (float[] items : arr) {
            for (float item : items) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }

        System.out.print("Which column do you want to sum: ");
        int col = sc.nextInt();
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][col];
        }
        System.out.println("The sum of column " + col + " = " + sum);
    }
}
