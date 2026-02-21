package com.vaibhav.payment_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.payment_api.exception.PaymentException;
import com.vaibhav.payment_api.service.PaymentService;
import com.vaibhav.payment_api.model.*;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/upi")
    public String payViaUPI(@RequestParam double amount, @RequestParam String upiID) throws PaymentException {
        UPIPayment payment = new UPIPayment(amount, upiID);
        return paymentService.executePayment(payment);
    }
}
