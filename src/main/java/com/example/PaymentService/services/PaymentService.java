package com.example.PaymentService.services;

import com.example.PaymentService.paymentgateway.PaymentGateway;
import com.example.PaymentService.paymentgateway.PaymentGatewayStrategyChooser;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewayStrategyChooser paymentGatewayStrategyChooser;
    public PaymentService(PaymentGatewayStrategyChooser paymentGatewayStrategyChooser){
        this.paymentGatewayStrategyChooser = paymentGatewayStrategyChooser;
    }
    public String initiatePayment(String orderId, Long amount, String phoneNumber, String email) throws Exception {
        PaymentGateway paymentGateway = paymentGatewayStrategyChooser.getPaymentGateway();
        return paymentGateway.generatePaymentLink(orderId,amount,phoneNumber,email);

    }
}
