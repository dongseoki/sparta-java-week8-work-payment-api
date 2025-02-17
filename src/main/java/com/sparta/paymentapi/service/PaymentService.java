package com.sparta.paymentapi.service;

import com.sparta.paymentapi.event.CreateOrderEvent;
import com.sparta.paymentapi.model.Payment;
import com.sparta.paymentapi.repository.PaymentRepository;
import com.sparta.paymentapi.webdto.GetAllPaymentsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
  private final PaymentRepository paymentRepository;

  public GetAllPaymentsResponse getAllPayments() {
    return GetAllPaymentsResponse.builder().payments(paymentRepository.findAll()).build();
  }

  public Payment createPaymentByOrder(CreateOrderEvent createOrderEvent) {
    return paymentRepository.save(Payment.of(createOrderEvent));
  }
}
