package models;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floor;

    public Villa(String serviceName, double usingArea, double rentExpense, int maxPeople, String typeOfRent, String roomStandard, double poolArea, int floor) {
        super(serviceName, usingArea, rentExpense, maxPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Room standard = " + roomStandard + '\'' +
                ", Pool area = " + poolArea +
                ", Floor = " + floor +
                '}';
    }
}
