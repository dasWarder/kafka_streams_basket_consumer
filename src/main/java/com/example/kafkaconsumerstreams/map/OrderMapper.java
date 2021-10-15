package com.example.kafkaconsumerstreams.map;

import com.example.kafkaconsumerstreams.dto.OrderResponse;
import com.example.kafkaconsumerstreams.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderMapper {

  public OrderResponse orderToOrderResponse(Order order) {

    OrderResponse response =
        OrderResponse.builder()
            .name(order.getName())
            .type(order.getType())
            .price(order.getPrice())
            .quantity(order.getQuantity())
            .build();

    return response;
  }
}
