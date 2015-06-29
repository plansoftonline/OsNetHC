package com.plansoftonline.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.plansoftonline.exception.ValidationException;
import com.plansoftonline.util.MensagensConstantes;

public class DataValidador implements Ivalidator {

    public boolean validar(Object objeto) throws ValidationException {
    	String data = (String) objeto;
    	try {
			new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			throw new ValidationException(MensagensConstantes.MSG_ERR_DATA_VALIDATOR);
		}
    	return true;
    }
       
}
