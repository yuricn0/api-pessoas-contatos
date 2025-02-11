package br.com.ydcns.AppPessoas.models;

import java.io.Serializable;
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
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador único do contato")
	private Long id;
	
	// @NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@Schema(description = "Tipo de Contato",
			example = "(0 = TELEFONE, 1 = CELULAR, 2 = EMAIL)")
	@JsonProperty("tipoContato")
	private TipoContato tipoContato;
	
	// @NotBlank
	@Column(nullable = false)
	@Schema(description = "Telefone, celular ou email",
			example = "Telefone: XXXX-XXXX | Celular:(XX) XXXXX-XXXX | E-mail: joao@xxx.com ")
	@JsonProperty("contato")
	private String contato;
	
	@ManyToOne
    @JoinColumn(name = "pessoa_id")
	@JsonProperty("pessoa")
	private Pessoas pessoa;
	
	public Contato() {}

	public Contato(Long id, TipoContato tipoContato, String contato, Pessoas pessoa) {
		super();
		this.id = id;
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
		return "Contatos [id=" + this.id + ", tipoContato=" + this.tipoContato +
				", contato=" + this.contato + ", pessoa=" + this.pessoa + "]";
	};
}
