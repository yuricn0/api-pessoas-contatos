package br.com.ydcns.AppPessoas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ContatoDTO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long id;
	
	private String tipoContato;

	private String contato;
	
    private Long pessoaId;
    
    public ContatoDTO() {};
 
	public ContatoDTO(String tipoContato, String contato, Long pessoaId) {
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.pessoaId = pessoaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "ContatoDTO [id = " + id + ", tipoContato=" + tipoContato + ", contato=" + contato + ", pessoaId=" + pessoaId + "]";
	}
}