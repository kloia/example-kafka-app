package com.kloia.kafkademo;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BookStreams {
    String INPUT = "books-in";
    String OUTPUT = "books-out";
    @Input(INPUT)
    SubscribableChannel inboundBook();
    @Output(OUTPUT)
    MessageChannel outboundBook();
}
