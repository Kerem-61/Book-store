package com.example.publishermicroservice.application.events;

public class PublisherEvent {
    private final String eventId;

    public PublisherEvent(String eventId) {
        this.eventId = eventId;
    }

    public String getEventId() {
        return eventId;
    }

}

