package com.example.PaymentService.paymentgateway;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PaymentGatewayStrategyChooser {
    private RazorpayPaymentGateway razorpayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;
    public PaymentGatewayStrategyChooser(RazorpayPaymentGateway razorpayPaymentGateway, StripePaymentGateway stripePaymentGateway){
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }
    public PaymentGateway getPaymentGateway(){
        //write logic for randomly picking PG
        return razorpayPaymentGateway;
    }
}
