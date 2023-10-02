package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/helloworld")
@Slf4j
public class AppController {


  @GetMapping
  public Mono<String> helloWorld() {
    log.info("returning Helloworld!");
    return Mono.just("Hello world!").doOnSuccess((e) -> log.info("Successful!"));
  }
}
