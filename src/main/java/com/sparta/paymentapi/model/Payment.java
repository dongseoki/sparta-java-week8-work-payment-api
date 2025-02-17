package com.sparta.paymentapi.model;

import com.sparta.paymentapi.event.CreateOrderEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "payments")
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long orderId;
  private Long userId;
  private Long productId;
  private Integer quantity;
  private String status;  // PENDING, COMPLETED, CANCELLED

  public static Payment of(CreateOrderEvent createOrderEvent) {
    return Payment.builder()
        .orderId(createOrderEvent.getId())
        .userId(createOrderEvent.getUserId())
        .productId(createOrderEvent.getProductId())
        .quantity(createOrderEvent.getQuantity())
        .status(createOrderEvent.getStatus())
        .build();
  }
}
