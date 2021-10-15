package com.example.kafkaconsumerstreams.service;

import com.example.kafkaconsumerstreams.model.Order;
import com.example.kafkaconsumerstreams.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final ObjectMapper mapper;

    private final OrderRepository repository;

    @KafkaListener(topics = "basket", groupId = "orders")
    public void consume(String order) throws JsonProcessingException {

        Order fetched = mapper.readValue(order, Order.class);
        repository.save(fetched);
        log.info(order);
    }
}
