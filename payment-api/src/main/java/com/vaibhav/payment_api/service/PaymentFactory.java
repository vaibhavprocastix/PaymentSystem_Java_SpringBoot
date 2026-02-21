package com.vaibhav.payment_api.service;

import org.springframework.stereotype.Component;
import java.util.List;

import com.vaibhav.payment_api.exception.PaymentException;
import com.vaibhav.payment_api.model.Payment;
import com.vaibhav.payment_api.model.PaymentRequest;
import com.vaibhav.payment_api.service.strategy.PaymentStrategy;

@Component
public class PaymentFactory {
    private final List<PaymentStrategy> strategies;
    public PaymentFactory(List<PaymentStrategy> strategies) {
        this.strategies = strategies;
    }
    
    public Payment createPayment(PaymentRequest request) throws PaymentException {

        return strategies.stream()
                .filter(strategy -> strategy.supports(request))
                .findFirst()
                .map(strategy -> strategy.createPayment(request))
                .orElseThrow(() ->
                        new PaymentException("Unsupported payment type", "ERR_TYPE_001")
                );
    }
}
