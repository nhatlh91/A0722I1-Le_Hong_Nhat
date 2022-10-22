package ss06_inherritane.bai_tap;

public class MovablePoint extends Point {
    private float xSpeed, ySpeed;

    MovablePoint() {

    }

    MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    }

    public float[] getSpeed() {
        float[] arr = new float[2];
        arr[0] = getXSpeed();
        arr[1] = getYSpeed();
        return arr;
    }

    public float[] move() {
        float moveX = getX() + getXSpeed();
        setX(moveX);
        float moveY = getY() + getYSpeed();
        setY(moveY);
        float[] newPosition = new float[2];
        newPosition[0] = moveX;
        newPosition[1] = moveY;
        return newPosition;
    }

    @Override
    public String toString() {
        return "\"(" + getX() +
                "," + getY() +
                "), speed = (" + getXSpeed() +
                "," + getYSpeed() +
                ')';
    }
}
