package com.vaibhav.payment_api.service.strategy;

import org.springframework.stereotype.Component;
import com.vaibhav.payment_api.model.*;
import com.vaibhav.payment_api.model.request.*;

@Component
public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean supports(PaymentRequest request) {
        return request instanceof CardPaymentRequest;
    }

    @Override
    public Payment createPayment(PaymentRequest request) {
        CardPaymentRequest cardRequest = (CardPaymentRequest) request;
        return new CreditCardPayment(cardRequest.getAmount(), cardRequest.getCardNumber(), cardRequest.getCvv());
    }
}
