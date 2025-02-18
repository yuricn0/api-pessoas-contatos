package br.com.ydcns.AppPessoas.dto;

import br.com.ydcns.AppPessoas.models.Pessoas;
import io.swagger.v3.oas.annotations.media.Schema;

public record PessoasMalaDiretaDTO(
		@Schema(description = "Identificador único da pessoa",
		        example = "1")
		Long id,
		
		@Schema(description = "Nome da pessoa",
		        example = "Yuri")
		String nome,
		
		@Schema(description = "Endereço completo para mala direta",
		        example = "Rua Santos, 156 - CEP: 09361-080 - São Paulo - SP")
	    String malaDireta) {
    
    public PessoasMalaDiretaDTO(Pessoas pessoa) {
        this(pessoa.getId(),
             pessoa.getNome(),
             pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + 
             " - " + pessoa.getCidade() + "-" + pessoa.getUf()
        );
    }
}
