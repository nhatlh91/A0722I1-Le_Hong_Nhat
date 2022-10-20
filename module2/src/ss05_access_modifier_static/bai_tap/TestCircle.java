package ss05_access_modifier_static.bai_tap;

public class TestCircle {
    public static void main(String[] args) {
        Circle circleA = new Circle();
        System.out.println("Area: "+circleA.getArea());
        System.out.println("Radius: "+circleA.getRadius());
        System.out.println(circleA);
    }
    }
