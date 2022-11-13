package ss11_tree_map.bai_tap;

public class Product implements Comparable<Product> {
    static int qty = 0;
    private String name;
    private int price;
    private int id;

    public Product(String name, int price) {
        this.id = qty++;
        this.name = name;
        this.price = price;
    }

    public Product() {
        this.id = qty++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.getPrice(), o.getPrice());
    }
}
