package br.com.ydcns.AppPessoas.exceptions;

public class ContatoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ContatoNotFoundException() {
		super("O contato informado não foi encontrado.");
	}
	
	public ContatoNotFoundException(String message) {
		super(message);
	}

}
