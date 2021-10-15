package com.example.kafkaconsumerstreams.service;

import com.example.kafkaconsumerstreams.exception.OrderNotFoundException;
import com.example.kafkaconsumerstreams.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface BasketConsumerService {

  void consume(String order) throws JsonProcessingException;

  List<Order> getBookOrders();

  Order getOrderById(Long id) throws OrderNotFoundException;

  Order getOrderByNameAndType(String name, String type) throws OrderNotFoundException;
}
