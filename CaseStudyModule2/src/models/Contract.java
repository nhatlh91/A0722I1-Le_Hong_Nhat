package models;

import java.util.Date;

public class Contract {
    private String contractNo;
    private String bookingID;
    private double deposit;
    private double totalAmount;
    private String customerID;

    public Contract(String contractNo, String bookingID, double deposit, double totalAmount, String customerID) {
        this.contractNo = contractNo;
        this.bookingID = bookingID;
        this.deposit = deposit;
        this.totalAmount = totalAmount;
        this.customerID = customerID;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNo='" + contractNo + '\'' +
                ", bookingID='" + bookingID + '\'' +
                ", deposit=" + deposit +
                ", totalAmount=" + totalAmount +
                ", customerID='" + customerID + '\'' +
                '}';
    }

    public String toFile(){
        return String.format("%s,%s,%s,%s,%s",contractNo,bookingID,deposit,totalAmount,customerID);
    }
}