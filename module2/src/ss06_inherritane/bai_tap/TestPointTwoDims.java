package ss06_inherritane.bai_tap;

public class TestPointTwoDims {
    public static void main(String[] args) {
        PointTwoDims pointTwoDims1 = new PointTwoDims(4,7);
        System.out.println(pointTwoDims1.getXY());
        pointTwoDims1.setXY(7,19);
        System.out.println(pointTwoDims1);
    }
}
