package com.main.payment_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
}
