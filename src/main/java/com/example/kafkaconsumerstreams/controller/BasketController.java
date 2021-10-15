package com.example.kafkaconsumerstreams.controller;

import com.example.kafkaconsumerstreams.dto.OrderResponse;
import com.example.kafkaconsumerstreams.exception.OrderNotFoundException;
import com.example.kafkaconsumerstreams.map.OrderMapper;
import com.example.kafkaconsumerstreams.model.Order;
import com.example.kafkaconsumerstreams.service.BasketConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/consumer/baskets")
public class BasketController {

  private final OrderMapper mapper;

  private final BasketConsumerService service;

  @GetMapping("/{id}")
  public ResponseEntity<OrderResponse> getOrderById(@PathVariable("id") Long id)
      throws OrderNotFoundException {

    Order order = service.getOrderById(id);
    OrderResponse response = mapper.orderToOrderResponse(order);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/one")
  public ResponseEntity<OrderResponse> getOrderByNameAndType(
      @RequestParam("name") String name, @RequestParam("type") String type)
      throws OrderNotFoundException {

    Order order = service.getOrderByNameAndType(name, type);
    OrderResponse response = mapper.orderToOrderResponse(order);

    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<List<OrderResponse>> getBooksOrders() {

    List<OrderResponse> orders =
        service.getBookOrders().stream()
            .map(mapper::orderToOrderResponse)
            .collect(Collectors.toList());

    return ResponseEntity.ok(orders);
  }
}
