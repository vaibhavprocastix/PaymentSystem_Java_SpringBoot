package com.vaibhav.payment_api.model;
import com.vaibhav.payment_api.exception.*;

public class UPIPayment extends Payment {
    private String upiId;
    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void validate() throws PaymentException {
        if(upiId == null || upiId.isEmpty() || !upiId.contains("@")) {
            throw new PaymentException("Invalid UPI ID","ERR_UPI_001");
        }
        if(amount <= 0) {
            throw new PaymentException("Amount must be greater than zero","ERR_AMOUNT_001");
        }
    }
    
    @Override
    public void process() throws PaymentException {
        if(amount > 50000) {
            throw new PaymentException("UPI transaction limit exceeded","ERR_LIMIT_001");
        }
        System.out.println("Processing UPI payment of ₹" + amount);
    }
}
