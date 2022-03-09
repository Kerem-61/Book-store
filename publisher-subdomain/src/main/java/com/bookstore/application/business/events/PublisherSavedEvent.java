package com.bookstore.application.business.events;

import com.bookstore.domain.Publisher;

public class PublisherSavedEvent extends PublisherEvent{
    private Publisher publisher;

    public Publisher getPublisher(){
        return publisher;
    }
    public PublisherSavedEvent(Publisher publisher) {
        this.publisher = publisher;
    }
}
