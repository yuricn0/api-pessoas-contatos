package br.com.ydcns.AppPessoas.models;

public record PessoasMalaDiretaDto(Long id, String nome, String malaDireta) {
    
    public PessoasMalaDiretaDto(Pessoas pessoa) {
        this(
            pessoa.getId(),
            pessoa.getNome(),
            pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + 
            " - " + pessoa.getCidade() + "-" + pessoa.getUf()
        );
    }

} 	