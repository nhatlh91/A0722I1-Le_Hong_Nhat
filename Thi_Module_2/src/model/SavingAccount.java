package model;

import java.time.LocalDate;

public class SavingAccount extends Account {
    private double savingAmount;
    private LocalDate beginDate;
    private double interestRate;
    private int term;

    public SavingAccount() {
    }

    public SavingAccount(double savingAmount, LocalDate beginDate, double interestRate, int term) {
        this.savingAmount = savingAmount;
        this.beginDate = beginDate;
        this.interestRate = interestRate;
        this.term = term;
    }

    public SavingAccount(int id, String accountID, String accountOwner, LocalDate createDate, double savingAmount, LocalDate beginDate, double interestRate, int term) {
        super(id, accountID, accountOwner, createDate);
        this.savingAmount = savingAmount;
        this.beginDate = beginDate;
        this.interestRate = interestRate;
        this.term = term;
    }

    public double getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(double savingAmount) {
        this.savingAmount = savingAmount;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "id=" + id +
                ", accountID='" + accountID + '\'' +
                ", accountOwner='" + accountOwner + '\'' +
                ", createDate=" + createDate +
                ", savingAmount=" + savingAmount +
                ", beginDate=" + beginDate +
                ", interestRate=" + interestRate +
                ", term=" + term +
                '}';
    }

    public String toFile(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",id,accountID,accountOwner,createDate,savingAmount,beginDate,interestRate,term);
    }
}
