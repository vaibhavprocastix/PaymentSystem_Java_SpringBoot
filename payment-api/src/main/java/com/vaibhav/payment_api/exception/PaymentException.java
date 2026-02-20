package com.vaibhav.payment_api.exception;

public class PaymentException extends Exception {

    private String errorCode;

    public PaymentException(String message) {
        super(message);
    }

    public PaymentException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
