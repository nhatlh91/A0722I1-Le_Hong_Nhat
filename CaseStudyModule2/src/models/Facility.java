package models;

public abstract class Facility {
    private final char BY_YEAR = 'y';
    private final char BY_MONTH = 'm';
    private final char BY_DAY = 'd';
    private final char BY_HOUR = 'h';
    private String serviceName;
    private double usingArea;
    private double rentExpense;
    private int maxPeople;
    private char typeOfRent;

public Facility(String serviceName, double usingArea, double rentExpense, int maxPeople, char typeOfRent) {
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

    public int getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(char typeOfRent) {
        this.typeOfRent = typeOfRent;
    }
}
