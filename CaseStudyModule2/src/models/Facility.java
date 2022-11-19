package models;

public abstract class Facility {
    private String serviceName;
    private double usingArea;
    private double rentExpense;
    private int maxPeople;
    private String typeOfRent;

    private int timesOfusing = 0;

    public int getTimesOfusing() {
        return timesOfusing;
    }

    public void setTimesOfusing(int timesOfusing) {
        this.timesOfusing = timesOfusing;
    }

    public Facility(String serviceName, double usingArea, double rentExpense, int maxPeople, String typeOfRent) {
    this.serviceName = serviceName;
    this.usingArea = usingArea;
    this.rentExpense = rentExpense;
    this.maxPeople = maxPeople;
    this.typeOfRent = typeOfRent;
}

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
        this.usingArea = usingArea;
    }

    public double getRentExpense() {
        return rentExpense;
    }

    public void setRentExpense(double rentExpense) {
        this.rentExpense = rentExpense;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    @Override
    public String toString() {
        return "Facility: {" +
                "Name = " + serviceName + '\'' +
                ", Area = " + usingArea +
                ", Price = " + rentExpense +
                ", Capacity = " + maxPeople +
                ", Type of rent = " + typeOfRent + '\'' +
                ", Times Of Using = " + timesOfusing;
    }
}
