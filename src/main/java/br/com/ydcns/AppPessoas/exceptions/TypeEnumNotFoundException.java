package br.com.ydcns.AppPessoas.exceptions;

public class TypeEnumNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TypeEnumNotFoundException() {
	super("Digite um tipo de contato válido.");
	}
	
	public TypeEnumNotFoundException(String message) {
		super(message);
	}
}