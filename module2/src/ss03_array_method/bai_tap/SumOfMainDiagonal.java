package ss03_array_method.bai_tap;

import java.util.Scanner;

public class SumOfMainDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[][] arr;
        System.out.print("Input the dimension of matrix: ");
        int dim = sc.nextInt();
        arr = new float[dim][dim];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Input the element at [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextFloat();
            }
        }
        System.out.println("Your array is: ");
        for (float[] items : arr) {
            for (float item : items) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }

        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        System.out.println("The sum of main diagonal elements = " + sum);
    }
}
