package com.org.chandrabank;

import java.sql.Time;
import java.util.Date;

public class BankModel {
    private String customerName;
    private long phoneNumber;
    private int commision;
    private String remarks;
    private String amount;
    private Date transactionDate;

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getCommision() {
        return commision;
    }

    public void setCommision(int commision) {
        this.commision = commision;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BankPojoClass{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", commision=" + commision +
                ", remarks='" + remarks + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
