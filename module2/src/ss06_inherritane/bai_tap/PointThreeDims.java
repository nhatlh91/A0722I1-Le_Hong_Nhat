package ss06_inherritane.bai_tap;

public class PointThreeDims extends PointTwoDims {
    private float z;

    public PointThreeDims() {
    }

    PointThreeDims (float x, float y, float z) {
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arr = new float[3];
        arr[0] = getX();
        arr[1] = getY();
        arr[2] = getZ();
        return arr;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x,y);
        setZ(z);
    }

    @Override
    public String toString() {
        return "\"" +getX()+
                ","+getX()+
                ","+getZ()+"\"";
    }
}
