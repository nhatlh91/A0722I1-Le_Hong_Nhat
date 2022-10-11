package ss03_array_method.bai_tap;

import java.util.Scanner;

public class MinOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu cua mang: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0 ; i<arr.length; i++) {
            System.out.print("Nhap vao phan tu thu "+i+": ");
            arr[i] = sc.nextInt();
        }
        int min = arr[0];
        System.out.print("Mang da nhap: ");
        for (int ele : arr) {
            System.out.print(ele+"\t");
            if (ele < min) {
                min = ele;
            }
        }
        System.out.println();
        System.out.print("Gia tri nho nhat: "+min);

    }
}
