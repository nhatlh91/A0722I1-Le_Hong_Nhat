package models;

public abstract class Facility {
    protected String name;
    protected double usingArea;
    protected double rentExpense;
    protected int maxPeople;
    protected String typeOfRent;

//    private int timesOfusing = 0;
//
//    public int getTimesOfusing() {
//        return timesOfusing;
//    }
//
//    public void setTimesOfusing(int timesOfusing) {
//        this.timesOfusing = timesOfusing;
//    }

    public Facility(String serviceName, double usingArea, double rentExpense, int maxPeople, String typeOfRent) {
    this.name = serviceName;
    this.usingArea = usingArea;
    this.rentExpense = rentExpense;
    this.maxPeople = maxPeople;
    this.typeOfRent = typeOfRent;
}

    public String getName() {
        return name;
    }

    public void setName(String serviceName) {
        this.name = serviceName;
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
        return  name +
                ", Area: " + usingArea +
                ", Price: " + rentExpense +
                ", Capacity: " + maxPeople +
                ", Type of rent: " + typeOfRent;
    }

    public abstract String toFile();
}
