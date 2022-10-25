package ss07_abstract.bai_tap;

public class ResizeableTest {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle(1.7);
        shapes[1] = new Square(5.4);
        shapes[2] = new Rectangle(6.3, 7.6);
        shapes[3] = new Circle();
        shapes[4] = new Rectangle();

        shapes[0].resize(54);
        shapes[1].resize(75);
        shapes[2].resize(12);
        shapes[3].resize(21);
        shapes[4].resize(39);
    }

}
