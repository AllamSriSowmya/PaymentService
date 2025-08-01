package com.example.PaymentService.paymentgateway;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(String orderId, Long amount, String phoneNumber, String email) {
        return null;
    }
}
