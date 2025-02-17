package com.sparta.paymentapi.repository;


import com.sparta.paymentapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
  Payment findByUserId(Long userId);

}
