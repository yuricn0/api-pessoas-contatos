package br.com.ydcns.AppPessoas.dto;

import br.com.ydcns.AppPessoas.models.Pessoas;

public record PessoasMalaDiretaDTO(Long id, String nome, String malaDireta) {
    
    public PessoasMalaDiretaDTO(Pessoas pessoa) {
        this(
            pessoa.getId(),
            pessoa.getNome(),
            pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + 
            " - " + pessoa.getCidade() + "-" + pessoa.getUf()
        );
    }

} 	