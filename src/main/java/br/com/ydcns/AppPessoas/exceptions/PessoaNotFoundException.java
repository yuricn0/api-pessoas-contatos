package br.com.ydcns.AppPessoas.exceptions;

public class PessoaNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException() {
		super("Não existe pessoa para atribuir esse contato.");
	}
	
	public PessoaNotFoundException(String message) {
		super(message);
	}
}
