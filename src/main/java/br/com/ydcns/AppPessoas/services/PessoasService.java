package br.com.ydcns.AppPessoas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ydcns.AppPessoas.dto.PessoasMalaDiretaDTO;
import br.com.ydcns.AppPessoas.exceptions.CepValidateException;
import br.com.ydcns.AppPessoas.exceptions.FindByIdException;
import br.com.ydcns.AppPessoas.exceptions.IdNotNullException;
import br.com.ydcns.AppPessoas.exceptions.ListNullException;
import br.com.ydcns.AppPessoas.exceptions.NameLimitException;
import br.com.ydcns.AppPessoas.exceptions.NameNotNullException;
import br.com.ydcns.AppPessoas.exceptions.UfValidateException;
import br.com.ydcns.AppPessoas.models.Pessoas;
import br.com.ydcns.AppPessoas.repositories.PessoasRepository;

@Service
public class PessoasService {
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	public Pessoas create(Pessoas pessoa) {
		if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
			throw new NameNotNullException(); 
		} else if (pessoa.getNome().trim().length() > 100 ) {
			throw new NameLimitException();
		}
		
		if (pessoa.getCep() != null && pessoa.getCep().trim().length() != 9) {
			throw new CepValidateException();
		}
		
		if (pessoa.getUf() != null && pessoa.getUf().trim().length() != 2) {
			throw new UfValidateException();
		}
		
		if (pessoa.getNome() != null) {
		    pessoa.setNome(pessoa.getNome().trim());
		}

		if (pessoa.getCep() != null) {
		    pessoa.setCep(pessoa.getCep().trim());
		}
		
		if (pessoa.getUf() != null) {
		    pessoa.setUf(pessoa.getUf().trim().toUpperCase());
		}

		return pessoasRepository.save(pessoa);
	}
	
	public Optional<Pessoas> findById(Long id){
	    Optional<Pessoas> pessoa = pessoasRepository.findById(id);
	    if (pessoa.isEmpty()) {
	        throw new FindByIdException();
	    }
	    return pessoa; 
	}
	
	public PessoasMalaDiretaDTO findByIdMalaDireta(Long id) {
	    Optional<Pessoas> pessoa = pessoasRepository.findById(id);
	    if (pessoa.isEmpty()) {
	        throw new FindByIdException();
	    }
	    return new PessoasMalaDiretaDTO(pessoa.get());
	}
	
	public List<Pessoas> findAll(){
		List<Pessoas> pessoas = pessoasRepository.findAll();
		if (pessoas == null) {
			throw new ListNullException();
		}
		if (pessoas.size() == 0) {
			throw new ListNullException();
		}
		return pessoas;
	}

	public Pessoas update(Pessoas pessoa) {
		if (pessoa.getId() == null) {
			throw new IdNotNullException();
		}
		
		if (pessoa.getNome() != null && pessoa.getNome().trim().isEmpty()){
			throw new NameNotNullException();
		}
		
		if (pessoa.getNome() != null && pessoa.getNome().trim().length() > 100) {
			throw new NameLimitException();
		}
		
		if (pessoa.getCep() != null && pessoa.getCep().trim().length() != 9) {
			throw new CepValidateException();
		}
		
		if (pessoa.getUf() != null && pessoa.getUf().trim().length() != 2) {
			throw new UfValidateException();
		}
					
		Optional<Pessoas> findPessoa = pessoasRepository.findById(pessoa.getId());
		if (findPessoa.isPresent()) {
		    Pessoas updPessoa = findPessoa.get();

		    if (pessoa.getNome() != null) {
		        updPessoa.setNome(pessoa.getNome().trim());
		    }
		    
		    if (pessoa.getEndereco() != null) {
		        updPessoa.setEndereco(pessoa.getEndereco().trim());
		    }

		    if (pessoa.getCep() != null) {
		        updPessoa.setCep(pessoa.getCep().trim());
		    }

		    if (pessoa.getCidade() != null) {
		        updPessoa.setCidade(pessoa.getCidade().trim());
		    }

		    if (pessoa.getUf() != null) {
		        updPessoa.setUf(pessoa.getUf().trim().toUpperCase());
		    }

		    return pessoasRepository.save(updPessoa); 
		}
		
		throw new FindByIdException(); 
	}

	public void deleteById(Long id) {
		Pessoas pessoa = pessoasRepository.findById(id)
				.orElseThrow(FindByIdException::new);
		pessoasRepository.delete(pessoa);
	}	
}
	