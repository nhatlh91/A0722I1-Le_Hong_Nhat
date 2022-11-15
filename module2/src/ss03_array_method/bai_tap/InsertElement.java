package ss03_array_method.bai_tap;

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] myArr;
        myArr = new int[10];
        int i = 0;
        do {
            System.out.print("Moi nhap vao phan tu thu " + i + ", nhap so 0 de ket thuc: ");
            myArr[i] = input.nextInt();
            i++;
        }
        while (i < 10);

        System.out.printf("\n%-30s%s", "Mang da nhap la: ", "");
        for (int n : myArr) {
            System.out.print(n + "\t");
        }

        System.out.printf("\n%-30s%s", "Nhap so can chen them vao: ", "");
        int insertNum = input.nextInt();

        System.out.printf("\n%-30s%s", "Nhap vi tri de chen vao: ", "");
        int index = input.nextInt();

        for (int j = myArr.length - 1; j > index; j--) {
            myArr[j] = myArr[j - 1];
        }

        myArr[index] = insertNum;

        System.out.printf("\n%-30s%s", "Mang da chen them la: ", "");
        for (int n : myArr) {
            System.out.print(n + "\t");
        }

    }
}
