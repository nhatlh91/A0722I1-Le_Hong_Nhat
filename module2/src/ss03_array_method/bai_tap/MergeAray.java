package ss03_array_method.bai_tap;

import java.util.Scanner;

public class MergeAray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr1,arr2,arr3;
        int i = 0, j=0;
        System.out.print("Nhap so phan tu cua mang thu 1: ");
        int qtyA = input.nextInt();
        arr1 = new int[qtyA];
        do {
            System.out.print("Nhap vao phan tu thu "+i+" cua mang thu nhat: ");
            arr1[i] = input.nextInt();
            i++;
        }
        while (i<qtyA);

        System.out.print("Nhap so phan tu cua mang thu 2: ");
        int qtyB = input.nextInt();
        arr2 = new int[qtyB];
        do {
            System.out.print("Nhap vao phan tu thu "+j+" cua mang thu nhat: ");
            arr2[j] = input.nextInt();
            j++;
        }
        while (j<qtyB);

        arr3 = new int[qtyA+qtyB];

        for (int k = 0; k < arr1.length; k++) {
            arr3[k] = arr1[k];
        }

        for (int k = i ,l=0; k<arr3.length; k++, l++) {
            arr3[k] = arr2[l];
        }
        System.out.printf("%-20s%s", "Mang thu nhat: ", "");
        for (int m:arr1) {
            System.out.print(m+"\t");
        }
        System.out.printf("\n%-20s%s", "Mang thu hai: ", "");
        for (int m:arr2) {
            System.out.print(m+"\t");
        }
        System.out.printf("\n%-20s%s", "Mang da gop: ", "");
        for (int m:arr3) {
            System.out.print(m+"\t");
        }

    }
    }
