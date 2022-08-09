package com.meusprojetos.modeloHateoas.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.meusprojetos.modeloHateoas.Exceptions.Erros.ExceptionRecursoNaoEncontrado;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ExceptionRecursoNaoEncontrado.class)
	public ResponseEntity<?> trataRecursoInválidoException(ExceptionRecursoNaoEncontrado e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
}
