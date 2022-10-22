package ss06_inherritane.bai_tap;

public class TestPointThreeDims {
    public static void main(String[] args) {
        PointThreeDims pA = new PointThreeDims(4.6f, 65.5f, 1.74f);
        System.out.println(pA);
        System.out.println(pA.getXYZ());
        pA.setXYZ(5.43f,72.1f,2.05f);
        System.out.println(pA);

    }
}
