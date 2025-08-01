package com.example.PaymentService.controller;

import com.example.PaymentService.dtos.InitiatePaymentDto;
import com.example.PaymentService.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    // return payment link of Payment gateway
    @PostMapping
    public String initiatePayment(@RequestBody InitiatePaymentDto initiatePaymentDto){
        try {
            return paymentService.initiatePayment(initiatePaymentDto.getOrderId(),
                                                    initiatePaymentDto.getAmount(),
                                                    initiatePaymentDto.getPhoneNumber(),
                                                    initiatePaymentDto.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
