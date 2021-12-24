package com.mpinfo.servicosprof.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mpinfo.servicosprof.services.exceptions.ExcessaoNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {	
	
	@ExceptionHandler(ExcessaoNaoEncontradaException.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ExcessaoNaoEncontradaException e, HttpServletRequest request) {
		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
