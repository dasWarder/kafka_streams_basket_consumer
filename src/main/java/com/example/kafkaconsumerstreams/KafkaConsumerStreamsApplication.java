package com.example.kafkaconsumerstreams;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class KafkaConsumerStreamsApplication {

    public static void main(String[] args) {

        SpringApplication.run(KafkaConsumerStreamsApplication.class, args);
    }

}
