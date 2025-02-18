package br.com.ydcns.AppPessoas.exceptions;

public class NameLimitException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NameLimitException() {
		super("O nome deve conter no máximo 100 caracteres.");
	}
	
	public NameLimitException(String message) {
		super(message);
	}
}
