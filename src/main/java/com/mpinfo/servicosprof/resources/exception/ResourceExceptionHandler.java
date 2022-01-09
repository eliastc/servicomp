package com.mpinfo.servicosprof.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mpinfo.servicosprof.services.exceptions.ExcessaoIntegridadeDados;
import com.mpinfo.servicosprof.services.exceptions.ExcessaoNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {	
	
	@ExceptionHandler(ExcessaoNaoEncontradaException.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ExcessaoNaoEncontradaException e, HttpServletRequest request) {
		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(ExcessaoIntegridadeDados.class)
	public ResponseEntity<ErroPadrao> integridadeDados(ExcessaoIntegridadeDados e, HttpServletRequest request) {
		ErroPadrao erro = new ErroPadrao(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroPadrao> validacao(MethodArgumentNotValidException e, HttpServletRequest request) {
		ErroValidacao erro = new ErroValidacao(HttpStatus.BAD_REQUEST.value(), "Erro de Validação", System.currentTimeMillis());
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			erro.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
