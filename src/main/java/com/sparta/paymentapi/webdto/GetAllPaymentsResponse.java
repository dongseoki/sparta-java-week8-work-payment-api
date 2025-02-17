package com.sparta.paymentapi.webdto;

import com.sparta.paymentapi.model.Payment;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class GetAllPaymentsResponse {
  List<Payment> payments;
}
