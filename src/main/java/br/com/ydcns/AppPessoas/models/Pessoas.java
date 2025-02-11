package br.com.ydcns.AppPessoas.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_pessoas")
public class Pessoas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador único da pessoa")
	private Long id;
	
	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	@Schema(description = "Nome da pessoa", example = "João")
	private String nome;
	
	@Schema(description = "Endereço da pessoa", example = "Rua Santos, 154")
	private String endereco;
	
	@Size(min = 9, max = 9)
	@Column(length = 9)
	@Schema(description = "Cep da pessoa no formato XXXXX-XXX", example = "09361-080")
	private String cep;
	
	@Schema(description = "Cidade da pessoa", example = "São Paulo")
	private String cidade;
	
	@Size(min = 2, max = 2)
	@Column(length = 2)
	@Schema(description = "Estado da pessoa (UF)", example = "SP")
	private String uf;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Contato> contato = new HashSet<>();
	
	public Pessoas() {}

	public Pessoas(Long id, String nome, String endereco, String cep,
			       String cidade, String uf, Set<Contato> contato) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.contato = contato;
	}

	public Set<Contato> getContato() {
		return contato;
	}

	public void setContatos(Set<Contato> contato) {
		this.contato = contato;
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
		return "Pessoas [ id=" + this.id + ", nome=" + this.nome +
				        ", endereco=" + this.endereco + ", cep=" + this.cep + 
				        ", cidade=" + this.cidade + ", uf=" + this.uf + "contatos=" + this.contato + " ]";
	}
}