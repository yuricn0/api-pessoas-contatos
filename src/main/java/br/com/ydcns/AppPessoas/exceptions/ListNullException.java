package br.com.ydcns.AppPessoas.exceptions;

public class ListNullException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ListNullException() {
		super("Não há registros de pessoas cadastradas");
	}
	
	public ListNullException(String message) {
		super(message);
	}
}

