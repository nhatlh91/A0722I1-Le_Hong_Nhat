package ss06_inherritane.bai_tap;

public class Circle {
    private double radius;
    private String color;


    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius = " + getRadius() +
                ", color = '" + getColor() + '\'' +
                ", area= " + getArea() + '\'' +
                '}';
    }
}
