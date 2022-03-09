package com.bookstore.customer.infastructure;

import com.bookstore.customer.application.business.events.CustomerEvent;

public interface EventPublisher {
void publishEvent(CustomerEvent businessEvent);
}
