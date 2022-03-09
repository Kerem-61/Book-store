package com.bookstore.book.infrastruct;

import com.bookstore.book.application.bussiness.events.BookEvent;

public interface EventPublisher {

	void PublishEvent(BookEvent businessEvent);

}
