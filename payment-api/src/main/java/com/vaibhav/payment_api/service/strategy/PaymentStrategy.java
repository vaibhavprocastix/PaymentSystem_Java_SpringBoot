package com.vaibhav.payment_api.service.strategy;

// import com.vaibhav.payment_api.exception.PaymentException;
import com.vaibhav.payment_api.model.*;

public interface PaymentStrategy {
    boolean supports(PaymentRequest request);
    Payment createPayment(PaymentRequest request);
}
