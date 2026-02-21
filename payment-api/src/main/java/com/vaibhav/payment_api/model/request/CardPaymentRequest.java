package com.vaibhav.payment_api.model.request;

import com.vaibhav.payment_api.model.PaymentRequest;

public class CardPaymentRequest extends PaymentRequest {
    private String cardNumber;
    private String cvv;
    
    public String getCardNumber() { return cardNumber; }
    public String getCvv() { return cvv; }

    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public void setCvv(String cvv) { this.cvv = cvv; }
}
