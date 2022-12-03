package models;

public class House extends Facility {
    private String roomStandard;
    private int floor;

    public House(String name, double usingArea, double rentExpense, int maxPeople, String typeOfRent, String roomStandard, int floor) {
        super(name, usingArea, rentExpense, maxPeople, typeOfRent);
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

    @Override
    public String toString() {
        return super.toString() +
                ", Room Standard: " + roomStandard + '\'' +
                ", Floor: " + floor;
    }

    public String toFile() {
    return String.format("%s,%s,%s,%s,%s,%s,%s",name, usingArea, rentExpense, maxPeople, typeOfRent,roomStandard,floor);
    }
}
