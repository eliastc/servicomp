package com.mpinfo.servicosprof.services.exceptions;

public class ExcessaoIntegridadeDados extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExcessaoIntegridadeDados(String msg) {
		super(msg);
	}
	
	public ExcessaoIntegridadeDados(String msg, Throwable causa) {
		super(msg, causa);
	}
}
