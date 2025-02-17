package com.sparta.paymentapi.controller;

import com.sparta.paymentapi.service.PaymentService;
import com.sparta.paymentapi.webdto.GetAllPaymentsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
  private final PaymentService paymentService;

  @GetMapping
  public ResponseEntity<GetAllPaymentsResponse> getAllPayments(){
    return ResponseEntity.ok(paymentService.getAllPayments());
  }
}
