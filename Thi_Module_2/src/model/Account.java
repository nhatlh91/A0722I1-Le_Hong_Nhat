package model;

import java.time.LocalDate;

public abstract class Account {
    protected int id;
    protected String accountID;
    protected String accountOwner;
    protected LocalDate createDate;

    public Account() {
    }

    public Account(int id, String accountID, String accountOwner, LocalDate createDate) {
        this.id = id;
        this.accountID = accountID;
        this.accountOwner = accountOwner;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountID='" + accountID + '\'' +
                ", accountOwner='" + accountOwner + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public abstract String toFile();
}
