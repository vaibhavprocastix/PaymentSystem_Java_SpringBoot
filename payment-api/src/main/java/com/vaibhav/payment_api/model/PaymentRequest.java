package com.vaibhav.payment_api.model;

import com.vaibhav.payment_api.model.request.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UPIPaymentRequest.class, name = "UPI"),
        @JsonSubTypes.Type(value = CardPaymentRequest.class, name = "CARD")
})

public abstract class PaymentRequest {
    private double amount;

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }  
 }
