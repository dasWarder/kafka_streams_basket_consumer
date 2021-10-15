package com.example.kafkaconsumerstreams.service;

import com.example.kafkaconsumerstreams.exception.OrderNotFoundException;
import com.example.kafkaconsumerstreams.model.Order;
import com.example.kafkaconsumerstreams.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BasketConsumerServiceImpl implements BasketConsumerService {

  private final ObjectMapper mapper;

  private final OrderRepository repository;

  @KafkaListener(topics = "basket", groupId = "basket_group_1")
  public void consume(String order) throws JsonProcessingException {

    Order fetched = mapper.readValue(order, Order.class);
    repository.save(fetched);
    log.info(order);
  }

  @Override
  public List<Order> getBookOrders() {

    log.info("Receiving all orders");

    return repository.findAll();
  }

  @Override
  public Order getOrderById(Long id) throws OrderNotFoundException {

    log.info("Receiving an order by id = {}", id);

    return repository
        .findById(id)
        .orElseThrow(
            () ->
                new OrderNotFoundException(
                    String.format("The order with the id = %d not found", id)));
  }

  @Override
  public Order getOrderByNameAndType(String name, String type) throws OrderNotFoundException {

    log.info("Receiving an order with the name = {} and the type = {}", name, type);

    return repository
        .getOrderByNameAndType(name, type)
        .orElseThrow(
            () ->
                new OrderNotFoundException(
                    String.format(
                        "The order with the name = %s and the type = %s not found", name, type)));
  }
}
