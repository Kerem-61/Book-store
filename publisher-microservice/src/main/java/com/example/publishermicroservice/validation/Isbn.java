package com.example.publishermicroservice.validation;

import org.springframework.messaging.handler.annotation.Payload;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=IsbnValidator.class)
public @interface Isbn {
	String message() default "{validation.isbn}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
