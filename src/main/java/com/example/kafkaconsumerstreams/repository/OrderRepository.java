package com.example.kafkaconsumerstreams.repository;

import com.example.kafkaconsumerstreams.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Long> {
}
