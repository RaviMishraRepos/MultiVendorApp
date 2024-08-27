package com.main.payment_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.payment_app.dao.PaymentRequest;

import com.main.payment_app.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
  
  @Autowired
  private PaymentService paymentService;

  @PostMapping("/process")
  public Object paymentProcess(@RequestBody PaymentRequest paymentRequest)
  {
    
     return  paymentService.processPayment(paymentRequest);
  }

}
