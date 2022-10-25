package ss07_abstract.bai_tap;

public class ResizeableTest {
    public static void main(String[] args) {

        Circle shape1 = new Circle(1.7);
        Shape shape2 = new Square(5.4);
        Shape shape3 = new Rectangle(6.3, 7.6);
        Shape shape4 = new Circle();
        Shape shape5 = new Rectangle();
        Shape[] shapes = new Shape[5];
        shapes[0] = shape1;
        shapes[1] = shape2;
        shapes[2] = shape3;
        shapes[3] = shape4;
        shapes[4] = shape5;

        shapes[0].resize(54);
        shapes[1].resize(75);
        shapes[2].resize(12);
        shapes[3].resize(21);
        shapes[4].resize(39);
    }

}
