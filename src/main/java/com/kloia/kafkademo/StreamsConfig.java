package com.kloia.kafkademo;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(BookStreams.class)
public class StreamsConfig {
}