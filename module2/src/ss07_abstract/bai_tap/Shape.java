package ss07_abstract.bai_tap;

public  abstract class Shape implements Resizeable{
    String color;
    boolean filled;

    Shape() {
    this.color = "green";
    this.filled = true;
    }
    Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    abstract double getArea();

    @Override
    public String toString() {
        return "a Shape with color " + color +" and " + (isFilled()? "filled" : "not filled");
    }
}