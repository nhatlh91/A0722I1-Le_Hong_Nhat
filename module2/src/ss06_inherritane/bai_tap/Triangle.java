package ss06_inherritane.bai_tap;

public class Triangle extends Shape {
    private double sideA = 1.0, sideB = 1.0, sideC = 1.0;

    Triangle() {

    }

    Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    Triangle(String color,double sideA, double sideB, double sideC) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getPerimeter() {
        return getSideA() + getSideB() + getSideC();
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.pow(p, 1 / 2) * (p - getSideA()) * (p - getSideB()) * (p - getSideC());
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + getSideA() +
                ", sideB=" + getSideB() +
                ", sideC=" + getSideC() +
                ", color=" + getColor() +
                ", Perimeter=" + getPerimeter() +
                ", Area=" + getArea() +
                '}';
    }
}
