package com.main.payment_app.service;

import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.main.payment_app.dao.PaymentRequest;
import com.main.payment_app.dao.PaymentResponse;
import com.main.payment_app.entity.Payment;
import com.main.payment_app.repository.PaymentRepository;

@Service
public class PaymentService {
  @Autowired
  private PaymentRepository paymentRepository;
  
  @Autowired
  private RestTemplate template;
  
  public Object processPayment (PaymentRequest paymentRequest)
  {
    new UUID(1, 100000000000000l);
    Payment payment = Payment.builder()
    .orderId(paymentRequest.getOrderId())
    .paymentStatus(new Random().nextBoolean()?"success":"failed")
    .transactionId(UUID.randomUUID().toString())
    .build();

   Object paymentResponse = template.postForObject("http://localhost:8083/api/v1/order/"+payment.getOrderId(), paymentRequest,Object.class);
    System.out.println(paymentResponse);
    paymentRepository.save(payment);
   return paymentResponse;

  }
}
