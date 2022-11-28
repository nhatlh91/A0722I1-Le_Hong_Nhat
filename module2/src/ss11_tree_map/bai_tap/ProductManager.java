package ss11_tree_map.bai_tap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    public static void display(ArrayList<Product> list) {
        System.out.println("Danh sach san pham la: ");
        for (Product product : list) System.out.println(product);
        mainMenu(list);
    }

    public static void add(ArrayList<Product> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("== THEM SAN PHAM ==");
        System.out.print("Nhap ten san pham: ");
        String name = input.nextLine();
        System.out.print("Nhap gia san pham: ");
        int price = input.nextInt();
        list.add(new Product(name, price));
        System.out.println("San pham da duoc dua vao CSDL !");
        mainMenu(list);

    }

    public static int searchById(ArrayList<Product> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void edit(ArrayList<Product> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("== SUA THONG TIN SAN PHAM ==");
        System.out.print("Nhap id san pham: ");
        int id = Integer.parseInt(input.nextLine());
//        int id = input.nextInt();
        int index = searchById(list, id);
        if (index == -1) {
            System.out.println("ID ban dang tim kiem khong ton tai, vui long thuc hien lai");
            edit(list);
        } else {
            System.out.println("Tim thay san pham voi thong tin nhu sau: ");
            System.out.println(list.get(index));
            System.out.print("Nhap ten moi: ");
            String newName = input.nextLine();
            System.out.print("Nhap gia moi: ");
            int newPrice = input.nextInt();
            list.set(index, new Product(newName, newPrice));
            System.out.println("Da cap nhat thanh cong, quay ve menu chinh");
            mainMenu(list);
        }
    }

    public static void delete(ArrayList<Product> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("== XOA SAN PHAM ==");
        System.out.print("Nhap id san pham: ");
        int id = input.nextInt();
        int index = searchById(list, id);
        if (index == -1) {
            System.out.println("ID ban dang tim kiem khong ton tai, vui long thuc hien lai");
            delete(list);
        } else {
            System.out.println("Tim thay san pham voi thong tin nhu sau: ");
            System.out.println(list.get(index));
            System.out.println("Nhan phim 1 de xoa");
            int confirm = input.nextInt();
            if (confirm == 1) {
                list.remove(index);
                System.out.println("Da xoa thanh cong, quay ve menu chinh");
                mainMenu(list);
            } else
                System.out.println("Huy bo thao tac, quay ve menu chinh");
            mainMenu(list);
        }
    }

    public static void sort(ArrayList<Product> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("== SAP XEP SAN PHAM ==");
        System.out.println("1\t Gia tang dan");
        System.out.println("2\t Gia giam dan");
        int choose = input.nextInt();
        switch (choose) {
//            case 1 -> {
//                Collections.sort(list);
//                display(list);
//            }
//            case 2 -> {
//                Collections.reverse(list);
//                display(list);
//            }
//            default -> {
//                display(list);
//            }
        }
    }


    public static void searchByName(ArrayList<Product> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ten san pham muon tim kiem: ");
        String searchName = input.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(searchName)) {
                System.out.println("San pham ban dang tim kiem co trong danh sach voi id = " + i);
                mainMenu(list);
                return;
            }
        }
        System.out.println("San pham ban dang tim kiem khong trong danh sach");
        mainMenu(list);
    }

    public static void mainMenu(ArrayList<Product> myList) {
        Scanner input = new Scanner(System.in);
        System.out.println("== GIAO DIEN QUAN LY SAN PHAM ==");
        System.out.println("1\tThem san pham");
        System.out.println("2\tSua thong tin san pham");
        System.out.println("3\tXoa san pham");
        System.out.println("4\tHien thi danh sach san pham");
        System.out.println("5\tTim kiem san pham");
        System.out.println("6\tSap xep san pham");
        System.out.println("7\tThoat");
        System.out.print("Nhap chuc nang tuong ung: ");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                add(myList);
                break;
            case 2:
                edit(myList);
                break;
            case 3:
                delete(myList);
                break;
            case 4:
                display(myList);
                break;
            case 5:
                searchByName(myList);
                break;
            case 6:
                sort(myList);
                break;
            case 7:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> myList = new ArrayList<>();
        myList.add(new Product("Apple", 900));
        myList.add(new Product("Samsung", 500));
        myList.add(new Product("Sony", 600));
        myList.add(new Product("Sharp", 450));
        myList.add(new Product("Dell", 600));
        mainMenu(myList);
    }
}
