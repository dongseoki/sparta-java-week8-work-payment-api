package com.sparta.paymentapi.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CreateOrderEvent {
  private Long id;
  private Long userId;
  private Long productId;
  private Integer quantity;
  private String status;  // PENDING, COMPLETED, CANCELLED
}
