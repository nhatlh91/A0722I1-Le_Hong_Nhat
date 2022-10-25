package ss07_abstract.bai_tap;

import ss06_inherritane.thuc_hanh.Rectangle;

public class Square extends Shape implements Resizeable{
    private double side = 1.0;
    public Square() {
    }

    public Square(double side){
        this.side = side;
    }


    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea(){
        return Math.pow(side,2);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        System.out.println("Area before resizing: "+getArea());
        double newSize = percent*getSide()/100;
        System.out.println("Area after resizing: "+Math.pow(newSize,2));
    }
}
