package br.com.ydcns.AppPessoas.exceptions;

public class UfValidateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UfValidateException() {
		super("UF inválida. Limite máximo 2 caracteres");
	}
	
	public UfValidateException(String message) {
		super(message);
	}
}
