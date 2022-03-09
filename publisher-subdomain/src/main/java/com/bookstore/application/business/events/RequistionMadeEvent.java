package com.bookstore.application.business.events;

import com.bookstore.domain.Requistion;

public class RequistionMadeEvent extends PublisherEvent {
	private final Requistion requistion;

	public RequistionMadeEvent(Requistion requistion) {
		this.requistion = requistion;
	}

	public Requistion getRequistion() {
		return requistion;
	}

}
