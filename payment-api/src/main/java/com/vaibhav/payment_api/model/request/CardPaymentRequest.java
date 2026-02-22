package com.vaibhav.payment_api.model.request;

import com.vaibhav.payment_api.model.PaymentRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CardPaymentRequest extends PaymentRequest {
    @NotBlank(message = "Card number is required")
    @Size(min = 16, max = 16, message = "Card number must be 16 digits")
    private String cardNumber;

    @NotBlank(message = "CVV is required")
    @Size(min = 3, max = 3, message = "CVV must be 3 or 4 digits")
    private String cvv;
    
    public String getCardNumber() { return cardNumber; }
    public String getCvv() { return cvv; }

    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public void setCvv(String cvv) { this.cvv = cvv; }
}
