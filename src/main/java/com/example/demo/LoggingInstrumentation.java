package com.example.demo;


import org.springframework.stereotype.Component;

import graphql.ExecutionResult;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.InstrumentationContext;
import graphql.execution.instrumentation.InstrumentationState;
import graphql.execution.instrumentation.SimpleInstrumentationContext;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

/**
 * Logs when a graphql query is started and finishes.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class LoggingInstrumentation implements Instrumentation {
  private final Tracer tracer;

  @Override
  public InstrumentationContext<ExecutionResult> beginExecution(
      InstrumentationExecutionParameters parameters, InstrumentationState state) {
    Instant startTime = Instant.now();
    log.info("Graphql operation executed. {}", parameters.getOperation());
    log.info("Trace_span={}", tracer.currentSpan());
    return SimpleInstrumentationContext.whenCompleted(
        ((executionResult, throwable) -> {
          log.info(
              "Graphql operation finished. {} {}",
              parameters.getOperation(),
              Duration.between(startTime, Instant.now()));
          log.info("Trace_span={}", tracer.currentSpan());
        }));
  }
}
