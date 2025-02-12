package br.com.ydcns.AppPessoas.models;

public class ContatoDTO {
	
	private String tipoContato;

	private String contato;
	
    private Long pessoaId;
 
	public String getTipoContato() {
    	return tipoContato;
	}

	public void setTipoContato(String tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

	@Override
	public String toString() {
		return "ContatoDTO [tipoContato=" + tipoContato + ", contato=" + contato + ", pessoaId=" + pessoaId + "]";
	}
}