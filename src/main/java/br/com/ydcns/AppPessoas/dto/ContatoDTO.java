package br.com.ydcns.AppPessoas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;

public class ContatoDTO {
	
	@Schema(hidden = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long id;
	
	@Schema(description = "Meios de contato da pessoa",
			example = "Telefone | Celular | Email | Linkedin | Github")
	private String tipoContato;
	
	@Schema(description = "Contato da pessoa", 
			example = "11 933049601")
	private String contato;
	
	@Schema(description = "ID da pessoa que possui o contato",
			example = "1")
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