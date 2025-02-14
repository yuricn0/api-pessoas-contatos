package br.com.ydcns.AppPessoas.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class PessoasDTO {
	
	@Schema(hidden = true)
	private Long id;
	
	@Schema(description = "Nome da pessoa", example = "João")
	private String nome;
	
	@Schema(description = "Endereço da pessoa", example = "Rua Santos, 154")
	private String endereco;
	
	@Schema(description = "Cep da pessoa no formato XXXXX-XXX", example = "09361-080")
	private String cep;
	
	@Schema(description = "Cidade da pessoa", example = "São Paulo")
	private String cidade;
	
	@Schema(description = "Estado da pessoa (UF)", example = "SP")
	private String uf;
	
	public PessoasDTO() {}

	public PessoasDTO(Long id, String nome, String endereco, String cep, String cidade, String uf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "PessoasDTO [id=" + id + ", nome=" + nome + ", endereco=" + endereco + 
				           ", cep=" + cep + ", cidade=" + cidade + ", uf=" + uf + "]";
	}	
}
