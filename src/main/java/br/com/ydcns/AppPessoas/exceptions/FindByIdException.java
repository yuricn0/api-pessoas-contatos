package br.com.ydcns.AppPessoas.exceptions;

public class FindByIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FindByIdException() {
		super("Sem registros para esse ID.");
	}
	
	public FindByIdException(String message) {
		super(message);
	}
}
