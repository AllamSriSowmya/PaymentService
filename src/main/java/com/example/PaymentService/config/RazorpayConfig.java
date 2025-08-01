package com.example.PaymentService.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
    @Value("${razorpay.key.Id}")
    private String razorpayId;
    @Value("${razorpay.key.secret}")
    private String RazorpaySecret;

    @Bean
    public RazorpayClient getRazorpayClient()throws RazorpayException {
        return new RazorpayClient(razorpayId, RazorpaySecret);
    }

}
