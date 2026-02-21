package com.vaibhav.payment_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.payment_api.exception.PaymentException;
import com.vaibhav.payment_api.service.PaymentService;
import com.vaibhav.payment_api.model.*;
// import org.springframework.web.bind.annotation.RequestParam;
import com.vaibhav.payment_api.model.request.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // @PostMapping("/upi")
    // public String payViaUPI(@RequestParam double amount, @RequestParam String upiID) throws PaymentException {
    //     UPIPayment payment = new UPIPayment(amount, upiID);
    //     return paymentService.executePayment(payment);
    // }

    // @PostMapping
    // public String makePayment(@RequestBody PaymentRequest request) throws PaymentException {
    //     Payment payment;
    //     if("UPI".equalsIgnoreCase(request.getType())) {
    //         payment = new UPIPayment(request.getAmount(), request.getUpiId());
    //     } else {
    //         throw new PaymentException("Unsupported payment type","ERR_TYPE_001");
    //     }
    //     return paymentService.executePayment(payment);
    // }

    @PostMapping
    public String makePayment(@RequestBody PaymentRequest request) throws PaymentException {
        Payment payment;
        if(request instanceof UPIPaymentRequest upiRequest) {
            payment = new UPIPayment(upiRequest.getAmount(),upiRequest.getUpiId());
        } else if(request instanceof CardPaymentRequest cardRequest){
            payment = new CreditCardPayment(cardRequest.getAmount(),cardRequest.getCardNumber(),cardRequest.getCvv());
        }else{
            throw new PaymentException("Unsupported payment type","ERR_TYPE_001");
        }
        return paymentService.executePayment(payment);
    }
}
