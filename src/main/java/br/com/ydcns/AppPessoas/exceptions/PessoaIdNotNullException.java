package br.com.ydcns.AppPessoas.exceptions;

public class PessoaIdNotNullException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PessoaIdNotNullException() {
		super("É necessário informar o pessoaId pra vincular esse contato.");
	}
	
	public PessoaIdNotNullException(String message) {
		super(message);
	}
}
