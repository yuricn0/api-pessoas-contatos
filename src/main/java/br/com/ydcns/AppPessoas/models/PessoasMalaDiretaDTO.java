package br.com.ydcns.AppPessoas.models;

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