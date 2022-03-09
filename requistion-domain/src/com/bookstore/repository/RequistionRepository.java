package com.bookstore.repository;

import com.bookstore.domain.Isbn;
import com.bookstore.domain.Requistion;


public interface RequistionRepository {
	
	Requistion findRequistionByIsbn(Isbn isbn);
}
