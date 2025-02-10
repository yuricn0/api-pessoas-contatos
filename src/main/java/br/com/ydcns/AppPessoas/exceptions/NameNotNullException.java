package br.com.ydcns.AppPessoas.exceptions;

public class NameNotNullException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NameNotNullException() {
		super("O nome não pode ser nulo.");
	}
	
	public NameNotNullException(String message) {
		super(message);
	}
}
