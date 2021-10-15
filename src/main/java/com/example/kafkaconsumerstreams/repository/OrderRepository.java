package com.example.kafkaconsumerstreams.repository;

import com.example.kafkaconsumerstreams.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, Long> {

  Optional<Order> getOrderByNameAndType(String name, String type);
}
