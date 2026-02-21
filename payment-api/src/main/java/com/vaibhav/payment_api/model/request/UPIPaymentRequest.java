package com.vaibhav.payment_api.model.request;
import com.vaibhav.payment_api.model.PaymentRequest;

public class UPIPaymentRequest extends PaymentRequest {
    private String upiId;
    public String getUpiId(){ return upiId; }
    public void setUpiId(String upiId) { this.upiId = upiId; }
}
