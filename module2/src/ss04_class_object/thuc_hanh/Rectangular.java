package ss04_class_object.thuc_hanh;

import java.util.Scanner;

public class Rectangular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width:");
        double width = sc.nextDouble();
        System.out.print("Enter the height:");
        double height = sc.nextDouble();
        Rectangular rectangle = new Rectangular(width, height);
        System.out.println("Your Rectangle: \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
    }
    double width, height;
    public Rectangular() {
    }
    public Rectangular(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}
