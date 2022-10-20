package ss05_access_modifier_static.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle () {
    }

    Circle(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }
    double getArea() {
        return Math.pow(radius,2)*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
