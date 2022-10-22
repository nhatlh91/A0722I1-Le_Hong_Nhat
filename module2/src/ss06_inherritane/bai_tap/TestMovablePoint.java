package ss06_inherritane.bai_tap;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint pointA = new MovablePoint();
        System.out.println(pointA);
        pointA.setXY(5.43f, 6.21f);
        pointA.setSpeed(1.34f, 2.05f);
        System.out.println(pointA);
        System.out.println(pointA.move());
        System.out.println(pointA);

    }
}
