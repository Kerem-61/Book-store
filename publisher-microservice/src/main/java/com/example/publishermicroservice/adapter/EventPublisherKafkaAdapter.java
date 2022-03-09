package com.example.publishermicroservice.adapter;

import com.bookstore.order.infra.EventPublisher;
import com.example.publishermicroservice.application.events.PublisherEvent;
import com.example.publishermicroservice.document.PublisherDocument;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EventPublisherKafkaAdapter implements EventPublisher {
    private static final Logger logger =
            (Logger) LoggerFactory.getLogger(EventPublisherKafkaAdapter.class);
    @Value("${employee.events.topic}")
    private String topicName;

    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper mapper;

    public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    @Override
    public void PublishEvent(PublisherEvent businessEvent) {
        try {
            var eventAsJson = mapper.writeValueAsString(businessEvent);
            kafkaTemplate.send(topicName, eventAsJson);
        } catch (JsonProcessingException e) {
            logger.error("Error while converting the event to json: {}",
                    e.getMessage());
        }
    }

    @Override
    public void publishEvent(com.bookstore.application.business.events.PublisherEvent event) {

    }
}
