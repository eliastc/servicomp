package com.mpinfo.servicosprof.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ErroValidacao extends ErroPadrao {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> erros = new ArrayList<>();
	
	public ErroValidacao(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
		
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName, message));
	}
}
