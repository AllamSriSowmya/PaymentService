package com.example.PaymentService.paymentgateway;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGateway{

    private RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }


    @Override
    public String generatePaymentLink(String orderId, Long amount, String phoneNumber, String email) throws RazorpayException{
    try {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount);
        paymentLinkRequest.put("currency", "INR");
        paymentLinkRequest.put("accept_partial", false);
        long expireBy = (System.currentTimeMillis() / 1000) + 1000000; // 15 minutes from now
        paymentLinkRequest.put("expire_by", expireBy);
        paymentLinkRequest.put("reference_id", orderId);
        paymentLinkRequest.put("description", "Payment for policy no #" + orderId);
        JSONObject customer = new JSONObject();
        customer.put("name", phoneNumber);
        customer.put("contact", "Sri Sowmya");
        customer.put("email", email);
        paymentLinkRequest.put("customer", customer);
        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);
        paymentLinkRequest.put("reminder_enable", true);
        //JSONObject notes = new JSONObject();
        //notes.put("policy_name","Life Insurance Policy");
        //paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url", "https://example-callback-url.com/");
        paymentLinkRequest.put("callback_method", "get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment.get("short_url").toString();
    }
    catch (RazorpayException ex){
        throw  new RuntimeException(ex);
    }
}}
