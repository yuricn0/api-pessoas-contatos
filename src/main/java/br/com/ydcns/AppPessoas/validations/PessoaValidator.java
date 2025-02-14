package br.com.ydcns.AppPessoas.validations;

import br.com.ydcns.AppPessoas.exceptions.CepValidateException;
import br.com.ydcns.AppPessoas.exceptions.NameLimitException;
import br.com.ydcns.AppPessoas.exceptions.NameNotNullException;
import br.com.ydcns.AppPessoas.exceptions.UfValidateException;
import br.com.ydcns.AppPessoas.models.Pessoas;

public class PessoaValidator {
	
	public static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new NameNotNullException(); 
        } else if (nome.trim().length() > 100) {
            throw new NameLimitException();
        }
    }

    public static void validarCep(String cep) {
        if (cep != null && cep.trim().length() != 9) {
            throw new CepValidateException();
        }
    }

    public static void validarUf(String uf) {
        if (uf != null && uf.trim().length() != 2) {
            throw new UfValidateException();
        }
    }
    
    public static void formatarNome(String nome) {
        if (nome != null) {
            nome = nome.trim();
        }
    }

    public static void formatarCep(String cep) {
        if (cep != null) {
            cep = cep.trim();
        }
    }

    public static void formatarUf(String uf) {
        if (uf != null) {
            uf = uf.trim().toUpperCase();
        }
    }
    
	public static void formatarNomeUpd(Pessoas pessoa, String nome) {
        if (nome != null) {
            pessoa.setNome(nome.trim());
        }
    }

	public static void formatarEnderecoUpd(Pessoas pessoa, String endereco) {
        if (endereco != null) {
            pessoa.setEndereco(endereco.trim());
        }
    }

    public static void formatarCepUpd(Pessoas pessoa, String cep) {
        if (cep != null) {
            pessoa.setCep(cep.trim());
        }
    }

    public static void formatarCidadeUpd(Pessoas pessoa, String cidade) {
        if (cidade != null) {
            pessoa.setCidade(cidade.trim());
        }
    }

    public static void formatarUfUpd(Pessoas pessoa, String uf) {
        if (uf != null) {
            pessoa.setUf(uf.trim().toUpperCase());
        }
    }
}