package br.com.ydcns.AppPessoas.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_pessoas")
@Schema(hidden = true)
public class Pessoas{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Size(min = 9, max = 9)
	@Column(length = 9)
	private String cep;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Size(min = 2, max = 2)
	@Column(length = 2)
	private String uf;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
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