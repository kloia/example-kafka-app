package com.kloia.kafkademo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class BookListener {
    private static final Logger log = LoggerFactory.getLogger(BookListener.class);
    @StreamListener(BookStreams.INPUT)
    public void handleBook(@Payload Book book) {
        log.info("Received book: {}", book);
    }
}
