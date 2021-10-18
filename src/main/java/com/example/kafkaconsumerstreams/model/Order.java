package com.example.kafkaconsumerstreams.model;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "basket")
public class Order {

  @Id private Long id;

  @BsonProperty("name")
  private String name;

  @BsonProperty("type")
  private String type;

  @BsonProperty("price")
  private Double price;

  @BsonProperty("quantity")
  private Integer quantity;
}
