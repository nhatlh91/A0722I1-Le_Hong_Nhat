package ss06_inherritane.bai_tap;

public class PointTwoDims {
    private float x;
    private float y;

        PointTwoDims(){
        }
        PointTwoDims(float x, float y) {
        this.x = x;
        this.y = y;
        }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.setX(x);
        this.setY(y);
    }

    public float[] getXY() {
        float[] arr = new float[2];
        arr[0] = this.getX();
        arr[1] = this.getY();
        return arr;
    }

    @Override
    public String
    toString() {
        return "\""+ x +
                ',' + y +
                "\"";
    }
}
