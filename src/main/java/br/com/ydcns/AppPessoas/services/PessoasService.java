package br.com.ydcns.AppPessoas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ydcns.AppPessoas.exceptions.FindByIdException;
import br.com.ydcns.AppPessoas.exceptions.ListNullException;
import br.com.ydcns.AppPessoas.exceptions.NameNotNullException;
import br.com.ydcns.AppPessoas.models.Pessoas;
import br.com.ydcns.AppPessoas.models.PessoasMalaDiretaDto;
import br.com.ydcns.AppPessoas.repositories.PessoasRepository;

@Service
public class PessoasService {
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	public Pessoas createPessoa(Pessoas pessoa) {
		if (pessoa.getNome() == null) {
			throw new NameNotNullException(); 
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
	
	public PessoasMalaDiretaDto findByIdMalaDireta(Long id) {
	    Optional<Pessoas> pessoa = pessoasRepository.findById(id);
	    if (pessoa.isEmpty()) {
	        throw new FindByIdException();
	    }
	    return new PessoasMalaDiretaDto(pessoa.get());
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
		Optional<Pessoas> findPessoa = pessoasRepository.findById(pessoa.getId());
		if(findPessoa.isPresent()) {
			Pessoas updPessoa = findPessoa.get();
			updPessoa.setNome(pessoa.getNome());
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setUf(pessoa.getUf());
			return pessoasRepository.save(updPessoa); 
		}
		throw new FindByIdException(); 
	}

	public void deleteById(Long id) {
		if (!pessoasRepository.existsById(id)) {
			 throw new FindByIdException();
		}
		pessoasRepository.deleteById(id);
	}
}
	