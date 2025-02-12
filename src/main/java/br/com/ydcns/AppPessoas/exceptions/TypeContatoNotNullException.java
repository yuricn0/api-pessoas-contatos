package br.com.ydcns.AppPessoas.exceptions;

public class TypeContatoNotNullException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TypeContatoNotNullException() {
		super("O tipo de contato precisa ser fornecido.");
	}
	
	public TypeContatoNotNullException(String message) {
		super(message);
	}
}
