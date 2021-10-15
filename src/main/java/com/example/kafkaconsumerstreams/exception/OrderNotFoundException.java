package com.example.kafkaconsumerstreams.exception;

public class OrderNotFoundException extends Throwable {

  public OrderNotFoundException() {}

  public OrderNotFoundException(String message) {
    super(message);
  }
}
