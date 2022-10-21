package ss04_class_object.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c, delta, rootOne, rootTwo;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDelta() {
        return delta = Math.pow(b, 2) - 4 * a * c;
    }

    public double getRootOne() {
        return rootOne = (-b + Math.pow(delta, 0.5)) / 2 * a;
    }

    public double getRootTwo() {
        return rootTwo = (-b - Math.pow(delta, 0.5)) / 2 * a;
    }

    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a, b, c:");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        System.out.println("Delta = " + quadraticEquation.getDelta());
        if (quadraticEquation.getDelta() < 0) {
            System.out.println("The equation has no roots");
        } else if (quadraticEquation.getDelta() == 0) {
            System.out.println("The equation has 1 root: " + quadraticEquation.getRootOne());
        } else {
            System.out.println("The equation has 2 roots: " + quadraticEquation.getRootOne() + " and " + quadraticEquation.getRootTwo());
        }
    }
}
