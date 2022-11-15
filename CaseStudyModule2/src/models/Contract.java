package models;

import java.util.Date;

public class Contract extends Booking{
    private String contractNo;
    private double deposit;
    private double totalAmount;

    public Contract(String bookingID, Date checkinDate, Date checkoutDate, String customerID, String serviceName, String typeOfService, String contractNo, double deposit, double totalAmount) {
        super(bookingID, checkinDate, checkoutDate, customerID, serviceName, typeOfService);
        this.contractNo = contractNo;
        this.deposit = deposit;
        this.totalAmount = totalAmount;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
