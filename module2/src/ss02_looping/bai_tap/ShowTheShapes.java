package ss02_looping.bai_tap;

import java.util.Scanner;
public class ShowTheShapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice!=0) {
            System.out.println("Menu");
            System.out.println("1. Ve hinh chu nhat");
            System.out.println("2. Ve hinh tam gac vuong");
            System.out.println("3. Ve hinh tam giac can");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap chieu dai: ");
                    int a = sc.nextInt();
                    System.out.print("Nhap chieu rong: ");
                    int b = sc.nextInt();
                    for (int i = 0; i < b; i++) {
                        for (int j = 0; j < a; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Chieu dai canh: ");
                    int c = sc.nextInt();
                    for (int i=0; i<c; i++) {
                        for (int j=0; j<c; j++) {
                            if (i>=j) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i=0; i<c; i++) {
                        for (int j=0; j<c; j++) {
                            if (i>j) {
                                System.out.print("  ");
                            } else {
                                System.out.print("* ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i=0; i<c; i++) {
                        for (int j=0; j<c; j++) {
                            if (i>c-j-1) {
                                System.out.print("  ");
                            } else {
                                System.out.print("* ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i=0; i<c; i++) {
                        for (int j=0; j<c; j++) {
                            if (i>=c-j-1) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Nhap chieu dai canh: ");
                    int d = sc.nextInt();
                    for (int i=0; i<d; i++) {
                        for (int j=0; j<d; j++) {
                            if (i>=j) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }

                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
/*
*
* *
* **
* ***
* ****
* *****
* ******
 */