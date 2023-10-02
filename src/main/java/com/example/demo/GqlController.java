package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class GqlController {

  @Autowired private DemoRepository demoRepository;

  @QueryMapping
  public Mono<String> query1() {
    log.info("logging out traceId");
    return Mono.just("Query1").doOnSuccess((r) -> log.info("Successful!"));
  }

  @QueryMapping
  public Mono<String> query2() {
    log.info("logging out traceId");
    return demoRepository.getOne().map(v -> "Received: " + v).doOnSuccess((r) -> log.info("Successful!"));
  }
}
