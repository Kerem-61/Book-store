package com.bookstore.application;

import com.bookstore.domain.Isbn;
import com.bookstore.domain.Requistion;

public interface RequistionApplication {

	Requistion findRequistionByIsbn(Isbn isbn);
	
}
