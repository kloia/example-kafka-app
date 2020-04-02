package com.kloia.kafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class BookService {
    private final BookStreams bookStreams;
    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private BookRepository repository;

    public BookService(BookStreams bookStreams, BookRepository repository) {
        this.bookStreams = bookStreams;
        this.repository = repository;
    }

    public void sendBook(final Book book) {
        log.info("Sending book {}", book);
        MessageChannel messageChannel = bookStreams.outboundBook();
        messageChannel.send(MessageBuilder
                .withPayload(book)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
    public void addBook(String name) {
        repository.save(new Book(name));
        log.info("Saved book {}", name);
    }
}
