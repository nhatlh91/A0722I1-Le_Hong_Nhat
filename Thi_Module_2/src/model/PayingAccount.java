package model;

import java.time.LocalDate;

public class PayingAccount extends Account{
    private String cardNumber;
    private double moneyAmount;

    public PayingAccount() {
    }

    public PayingAccount(int id, String accountID, String accountOwner, LocalDate createDate, String cardNumber, double moneyAmount) {
        super(id, accountID, accountOwner, createDate);
        this.cardNumber = cardNumber;
        this.moneyAmount = moneyAmount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    @Override
    public String toString() {
        return "PayingAccount{" +
                "id=" + id +
                ", accountID='" + accountID + '\'' +
                ", accountOwner='" + accountOwner + '\'' +
                ", createDate=" + createDate +
                ", cardNumber='" + cardNumber + '\'' +
                ", moneyAmount=" + moneyAmount +
                '}';
    }

    public String toFile(){
        return String.format("%s,%s,%s,%s,%s,%s",id,accountID,accountOwner,createDate,cardNumber,moneyAmount);
    }
}
