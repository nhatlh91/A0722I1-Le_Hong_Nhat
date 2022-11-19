package models;

public class Room extends Facility {
    private String extraServices;

    public Room(String serviceName, double usingArea, double rentExpense, int maxPeople, String typeOfRent, String extraServices) {
        super(serviceName, usingArea, rentExpense, maxPeople, typeOfRent);
        this.extraServices = extraServices;
    }

    public String getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(String extraServices) {
        this.extraServices = extraServices;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Extra sercice = " + extraServices + '\'' +
                '}';
    }
}
