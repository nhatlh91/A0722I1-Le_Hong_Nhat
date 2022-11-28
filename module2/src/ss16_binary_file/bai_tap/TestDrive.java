package ss16_binary_file.bai_tap;


import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class TestDrive {
    public static List<Product> readFromFile(String path) {
        List<Product> products = new LinkedList<>();
        File file = new File(path);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            products = (LinkedList<Product>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void writeToFile(String path, List<Product> products) {
        File file = new File(path);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(products);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final String PATH = "D:\\CODEGYM\\Git\\module2\\src\\ss16_binary_file\\bai_tap\\Products.dat";
//        Đoạn code tạo product list và add vào file.
//        List<Product> products = new LinkedList<>();
//        products.add(new Product(1,"Galaxy","Samsung",250.7,"OLED screen"));
//        products.add(new Product(2,"iPhone","Apple",559.99,"apple logo"));
//        products.add(new Product(3,"Redmi","Xiaomi",210.5,"Very cheap"));
//        products.add(new Product(4,"Reno","Oppo",222.1,"Camera selfie"));
//        products.add(new Product(5,"XPeria","Sony",650.7,"Super durable"));
//        writeToFile(PATH,products);

//        Đoạn code đọc product list từ file.
        List<Product> products = readFromFile(PATH);
        for (Product product: products) {
            System.out.println(product);
        }

    }
}
