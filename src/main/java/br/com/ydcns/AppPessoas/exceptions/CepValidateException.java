package br.com.ydcns.AppPessoas.exceptions;

public class CepValidateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CepValidateException() {
	super("O Cep deve conter 9 caracteres, incluindo o -");
	}
	
	public CepValidateException(String message) {
		super(message);
	}
}
