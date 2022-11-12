package ss11_tree_map.bai_tap;

import java.util.ArrayList;

public class ProductManager {
    public static void display(ArrayList<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> myList = new ArrayList<>();
        myList.add(new Product());
        myList.add(new Product("Samsung", 500));
        myList.add(new Product("Sony", 600));
        myList.add(new Product("Sharp", 450));
        myList.add(new Product("Dell", 600));

        display(myList);
    }
}
