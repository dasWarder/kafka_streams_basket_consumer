package com.example.kafkaconsumerstreams.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("basket")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private Long id;

    @BsonProperty("name")
    private String name;

    @BsonProperty("type")
    private String type;

    @BsonProperty("price")
    private Double price;

    @BsonProperty("quantity")
    private Integer quantity;
}
