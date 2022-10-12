package ss04_class_object.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;
    double delta, root1, root2;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return delta = Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        return root1 = (-b + Math.pow(delta, 0.5)) / 2 * a;
    }

    public double getRoot2() {
        return root2 = (-b - Math.pow(delta, 0.5)) / 2 * a;
    }

    public static void main(String[] args) {
        double a1, a2, a3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a, b, c:");
        a1 = sc.nextDouble();
        a2 = sc.nextDouble();
        a3 = sc.nextDouble();

        QuadraticEquation quadraticEquation1 = new QuadraticEquation(a1, a2, a3);
        if (quadraticEquation1.getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else if (quadraticEquation1.getDiscriminant() == 0) {
            System.out.println("The equation has 1 root: " + quadraticEquation1.getRoot1());
        } else {
            System.out.println("The equation has 2 roots: " + quadraticEquation1.getRoot1() + " and " + quadraticEquation1.getRoot2());
        }
    }
}
