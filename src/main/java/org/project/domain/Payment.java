package org.project.domain;

import javax.persistence.*;


@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name = "transactionId")
    @GeneratedValue(generator = "payment_generator")
    @SequenceGenerator(
            name = "payment_generator",
            sequenceName = "payment_sequence",
            initialValue = 1
    )

    private int transactionId;

    @Column(name = "amount")
    private double amount;



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

//    public void confirmTransaction(){}
//    public void cancelTransaction(){}


}
