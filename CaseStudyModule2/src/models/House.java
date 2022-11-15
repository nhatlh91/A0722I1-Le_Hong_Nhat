package models;

public class House extends Facility {
    private String roomStandard;
    private int floor;

    public House(String serviceName, double usingArea, double rentExpense, int maxPeople, char typeOfRent, String roomStandard, double poolArea, int floor) {
        super(serviceName, usingArea, rentExpense, maxPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
