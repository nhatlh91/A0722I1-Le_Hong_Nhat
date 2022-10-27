package ss08_refactor.thuc_hanh;

public class Cylinder {
    public static double getVolume(int radius, int height){
        return getPerimeter(radius) * height + 2 * getBaseArea(radius);
    }
    public static double getBaseArea(int radius) {
        return Math.PI * Math.pow(radius,2);
    }

    public static double getPerimeter(int radius) {
        return 2 * Math.PI  * radius;
    }
}
