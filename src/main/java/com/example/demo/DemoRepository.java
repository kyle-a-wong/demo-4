package com.example.demo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface DemoRepository extends R2dbcRepository<DemoEntity, Integer> {
  Mono<DemoEntity> findById(int id);

  @Query("select 1;")
  Mono<Integer> getOne();
}
