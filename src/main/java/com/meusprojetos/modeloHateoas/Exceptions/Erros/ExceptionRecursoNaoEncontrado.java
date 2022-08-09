package com.meusprojetos.modeloHateoas.Exceptions.Erros;

public class ExceptionRecursoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionRecursoNaoEncontrado() {
		super();
	}

	public ExceptionRecursoNaoEncontrado(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionRecursoNaoEncontrado(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionRecursoNaoEncontrado(String message) {
		super(message);
	}

	public ExceptionRecursoNaoEncontrado(Throwable cause) {
		super(cause);
	}
	
	

}
