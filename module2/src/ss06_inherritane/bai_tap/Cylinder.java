package ss06_inherritane.bai_tap;

public class Cylinder extends Circle {
    private double height;

    public double getHeight(){
        return height;
    }

    public double getVolume(){
        return getArea()*height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + getHeight() +
                "volume=" + getVolume() +
                "is a " + super.toString() +
                '}';
    }
}
