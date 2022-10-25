package ss07_abstract.bai_tap;

public class ColorableTest {
    public static void main(String[] args) {
        int i = 0;
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle(1.7);
        shapes[1] = new Square(5.4);
        shapes[2] = new Rectangle(6.3, 7.6);
        shapes[3] = new Circle();
        shapes[4] = new Square();

        for( Shape item: shapes) {
            System.out.println("Diện tích hình thứ"+i+" là: "+item.getArea());
            i++;
            if (item instanceof Square) ((Square) item).howToColor();
        }
    }
}
