package com.bookstore.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsbnValidator implements 
ConstraintValidator<Isbn, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 int n = value.length();
	        if (n != 10)
	            return false;
	 
	        // Computing weighted sum
	        // of first 9 digits
	        int sum = 0;
	        for (int i = 0; i < 9; i++)
	        {
	            int digit = value.charAt(i) - '0';
	            if (0 > digit || 9 < digit)
	                return false;
	            sum += (digit * (10 - i));
	        }
	 
	        // Checking last digit.
	        char last = value.charAt(9);
	        if (last != 'X' && (last < '0' ||
	                            last > '9'))
	            return false;
	 
	        // If last digit is 'X', add 10
	        // to sum, else add its value
	        sum += ((last == 'X') ? 10 : (last - '0'));
	 
	        // Return true if weighted sum
	        // of digits is divisible by 11.
	        return (sum % 11 == 0);
	}

}
