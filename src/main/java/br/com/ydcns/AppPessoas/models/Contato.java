package br.com.ydcns.AppPessoas.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ydcns.AppPessoas.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contatos")
@Schema(hidden = true)
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	@JsonProperty("tipoContato")
	private TipoContato tipoContato;
	
	@Column(nullable = false)
	@JsonProperty("contato")
	private String contato;
	
	@ManyToOne
    @JoinColumn(name = "pessoa_id")
	@JsonProperty("pessoa_id")
	private Pessoas pessoa;
	
	public Contato() {}

	public Contato(TipoContato tipoContato, String contato, Pessoas pessoa) {
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Contato [id=" + this.id + ", tipoContato=" + this.tipoContato +
				", contato=" + this.contato + ", pessoa=" + this.pessoa + "]";
	};
}
