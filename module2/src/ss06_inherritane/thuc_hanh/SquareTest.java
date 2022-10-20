package ss06_inherritane.thuc_hanh;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        square.setSide(6.1);
        System.out.println(square);
        square.setWidth(6.2);
        System.out.println(square);
        square.setLength(6.3);
        System.out.println(square);
    }
}
