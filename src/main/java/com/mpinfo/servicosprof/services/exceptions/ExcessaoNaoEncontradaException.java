package com.mpinfo.servicosprof.services.exceptions;

public class ExcessaoNaoEncontradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExcessaoNaoEncontradaException(String msg) {
		super(msg);
	}
	
	public ExcessaoNaoEncontradaException(String msg, Throwable causa) {
		super(msg, causa);
	}
}
