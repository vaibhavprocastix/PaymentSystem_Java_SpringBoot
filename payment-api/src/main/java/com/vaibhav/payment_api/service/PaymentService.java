package com.vaibhav.payment_api.service;

import com.vaibhav.payment_api.exception.PaymentException;
import com.vaibhav.payment_api.model.Payment;
import org.springframework.stereotype.Service;

@Service
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
