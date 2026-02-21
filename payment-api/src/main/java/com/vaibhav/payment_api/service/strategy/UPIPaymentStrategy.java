package com.vaibhav.payment_api.service.strategy;

import org.springframework.stereotype.Component;
import com.vaibhav.payment_api.model.*;
import com.vaibhav.payment_api.model.request.*;

@Component
public class UPIPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean supports(PaymentRequest request) {
        return request instanceof UPIPaymentRequest;
    }

    @Override
    public Payment createPayment(PaymentRequest request){
        UPIPaymentRequest upiRequest = (UPIPaymentRequest) request;
        return new UPIPayment(upiRequest.getAmount(), upiRequest.getUpiId());
    }
}
