package org.project.dto;

import java.util.Objects;

public class PaymentDTO {

    private double amount;
    private int transactionId;

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

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "amount=" + amount +
                ", transactionId=" + transactionId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDTO that = (PaymentDTO) o;
        return Double.compare(that.amount, amount) == 0 &&
                transactionId == that.transactionId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, transactionId);
    }
}
