package com.example.demo;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class DemoEntity {
  @Id
  private int id;
}
