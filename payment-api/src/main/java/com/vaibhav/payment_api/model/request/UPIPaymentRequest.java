package com.vaibhav.payment_api.model.request;
import com.vaibhav.payment_api.model.PaymentRequest;
import jakarta.validation.constraints.NotBlank;

public class UPIPaymentRequest extends PaymentRequest {
    @NotBlank(message = "UPI ID is required")
    private String upiId;
    public String getUpiId(){ return upiId; }
    public void setUpiId(String upiId) { this.upiId = upiId; }
}
