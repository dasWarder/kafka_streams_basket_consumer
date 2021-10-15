package com.example.kafkaconsumerstreams.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

  private String name;

  private String type;

  private Double price;

  private Integer quantity;
}
