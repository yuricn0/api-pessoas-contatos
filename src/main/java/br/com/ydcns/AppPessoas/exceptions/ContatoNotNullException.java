package br.com.ydcns.AppPessoas.exceptions;

public class ContatoNotNullException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ContatoNotNullException() {
		super("O contato deve ser preenchido");
	}
	
	public ContatoNotNullException(String message) {
		super(message);
	}

}
