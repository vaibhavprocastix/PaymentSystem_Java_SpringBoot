package com.vaibhav.payment_api.model;

import com.vaibhav.payment_api.exception.PaymentException;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cvv;
    public CreditCardPayment(double amount, String cardNumber, String cvv){
        super(amount);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void validate() throws PaymentException {
        if (cardNumber == null || cardNumber.length() != 16) {
            throw new PaymentException("Invalid card number","ERR_CARD_001");
        }
        if (cvv == null || cvv.length() != 3) {
            throw new PaymentException("Invalid CVV","ERR_CARD_002");
        }
        if(amount <= 0) {
            throw new PaymentException("Amount must be greater than zero","ERR_AMOUNT_001");
        }
    }

    @Override
    public void process() throws PaymentException{
        if(amount > 100000) {
            throw new PaymentException("Credit card transaction limit exceeded","ERR_LIMIT_002");
        }
        System.out.println("Processing credit card payment of ₹" + amount);
    }
}
