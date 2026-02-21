package com.vaibhav.payment_api.model;
import com.vaibhav.payment_api.exception.PaymentException;

public abstract class Payment {
    protected double amount;
    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void validate() throws PaymentException;
    public abstract void process() throws PaymentException;

    public void generateReceipt() {
        System.out.println("Payment of ₹" + amount + " completed successfully.");
    }

    public double getAmount() {
        return amount;
    }
}
