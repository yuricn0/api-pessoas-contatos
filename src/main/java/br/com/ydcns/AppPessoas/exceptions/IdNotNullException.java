package br.com.ydcns.AppPessoas.exceptions;

public class IdNotNullException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IdNotNullException() {
		super("É necessário informar um ID para atualizar.");
	}
	
	public IdNotNullException(String message) {
		super(message);
	}
}

