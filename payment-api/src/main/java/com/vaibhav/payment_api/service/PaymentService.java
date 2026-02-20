package com.vaibhav.payment_api.service;

import com.vaibhav.payment_api.exception.PaymentException;

public class PaymentService {
    public String executePayment(Payment payment)throws PaymentException {
        try{
            payment.validate();
            payment.process();
            payment.generateReceipt();
            return "Payment successful";
        }catch (PaymentException e) {
            System.out.println("Payment failed: "+e.getMessage());
            throw e;
        }finally{
            System.out.println("Payment process completed.");
        }
    }
}
