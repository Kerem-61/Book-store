package com.bookstore.application.business.exception;

import com.bookstore.domain.PublisherId;

public class ExistingPublisherException extends RuntimeException {
    private final String identity;
    private PublisherId publisherId;

    public ExistingPublisherException(String identity, PublisherId publisherId) {
        this.identity=identity;
        this.publisherId=publisherId;
    }

    public String getIdentity() {
        return identity;
    }

    public PublisherId getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(PublisherId publisherId) {
        this.publisherId = publisherId;
    }
}
