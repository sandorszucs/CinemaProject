package org.project;

public class Payment {
    private double amount;
    private int transactionId;

    public Payment(double amount, int transactionId) {
        this.amount = amount;
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void confirmTransaction(){}
    public void cancelTransaction(){}


}
