package com.sparta.paymentapi.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.paymentapi.event.CreateOrderEvent;
import com.sparta.paymentapi.model.Payment;
import com.sparta.paymentapi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaEventListener {
  private final ObjectMapper objectMapper;
  private final PaymentService paymentService;

  @KafkaListener(groupId = "myGroup", topics = "order-event")
  public void test(ConsumerRecord<String, String> data, Acknowledgment acknowledgment, Consumer<String, String> consumer){
    String value = data.value();
    CreateOrderEvent createOrderEvent;
    try {
      createOrderEvent = objectMapper.readValue(value, CreateOrderEvent.class);
      Payment paymentByOrder = paymentService.createPaymentByOrder(createOrderEvent);
      log.info("Payment created: {}", paymentByOrder);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

  }
}
