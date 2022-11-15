package ss03_array_method.bai_tap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] myArr = {5, 4, 2, 6, 8, 6, 4, 2, 1, 7};
        System.out.printf("\n%-25s%s", "Mang da nhap la: ", "");
        for (int n : myArr) {
            System.out.print(n + "\t");
        }
        System.out.println();
        System.out.print("Nhap vao phan tu can xoa: ");
        int x = input.nextInt();
        int index = -1;
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] == x) {
                index = i;
                for (int j = index; j < myArr.length - 1; j++) {
                    myArr[j] = myArr[j + 1];
                }
                myArr[myArr.length - 1] = 0;
            }
        }
        if (index == -1) {
            System.out.println("Phan tu nay khong nam trong mang");
        } else {
            System.out.printf("\n%-25s%s", "Mang sau khi xoa la: ", "");
            for (int k : myArr) {
                System.out.print(k + "\t");
            }
        }
    }
}
