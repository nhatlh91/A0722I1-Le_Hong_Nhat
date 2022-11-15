package ss04_class_object.bai_tap;

public class Fan {
    private final int slow = 1;
    private final int medium = 2;
    private final int fast = 3;
    private int speed = slow;
    private boolean on;
    private double radius = 5;
    private String color = "Blue";

    Fan() {
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.fanInfo();
        fan2.fanInfo();

        fan1.setSpeed(3);
        fan1.setColor("Yellow");
        fan1.setRadius(9.9);
        fan1.switchStatus();

        fan2.setSpeed(2);

        fan1.fanInfo();
        fan2.fanInfo();


    }

    String getSpeed() {
        return !this.on ? "Fan is off" : this.speed == 1 ? "Fan is on. Speed is LOW" : this.speed == 2 ? "Fan is on. Speed is MEDIUM" : "Fan is on. Speed is HIGH";
    }

    void setSpeed(int speed) {
        if (speed > 0 && speed < 4) {
            this.speed = speed;
            System.out.println("Fan speed has changed to " + speed);
        } else System.out.println("Speed range is from 1-3, please adjust");
    }

    String isOn() {
        return !this.on ? "Fan is off" : "Fan is on";
    }

    void switchStatus() {
        this.on = !this.on;
    }

    String getRadius() {
        return !this.on ? "Fan is off" : "Fan is on, the radius is: " + this.radius;
    }

    void setRadius(double radius) {
        if (radius > 0 && speed < 10) {
            this.radius = radius;
            System.out.println("Fan radius has changed to " + radius);
        } else System.out.println("Radius range is from 1-10, please adjust");
    }

    String getColor() {
        return "Fan color is: " + this.color;
    }

    void setColor(String color) {
        this.color = color;
        System.out.println("Fan color has changed to " + color);
    }

    void fanInfo() {
        System.out.println("Fan color is: " + this.color);
        System.out.println("Radius is: " + this.radius);
        if (this.on) {
            System.out.println("Fan is on");
            System.out.println("Speed is: " + this.speed);
        } else System.out.println("Fan is off");
    }
}
