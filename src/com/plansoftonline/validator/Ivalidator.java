package com.plansoftonline.validator;

import com.plansoftonline.exception.ValidationException;

public interface Ivalidator {

	public boolean validar(Object objeto) throws ValidationException;
	
}
