package br.com.ydcns.AppPessoas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ydcns.AppPessoas.models.Pessoas;
import br.com.ydcns.AppPessoas.models.PessoasMalaDiretaDto;
import br.com.ydcns.AppPessoas.repositories.PessoasRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoasService {
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	public Pessoas createPessoa(Pessoas pessoa) {
		if (pessoa.getNome() == null) {
			System.out.println("O nome não pode ser nulo");
			return null; 
		}
		return pessoasRepository.save(pessoa);
	}
	
	public Optional<Pessoas> findById(Long id){
	    Optional<Pessoas> pessoa = pessoasRepository.findById(id);
	    if (pessoa.isEmpty()) {
	        System.out.println("Não tem ninguém com esse ID");
	        return null;
	    }
	    return pessoa; 
	}
	
	public PessoasMalaDiretaDto findByIdMalaDireta(Long id) {
	    Optional<Pessoas> pessoa = pessoasRepository.findById(id);
	    if (pessoa.isEmpty()) {
	        System.out.println("Não tem ninguém com esse ID");
	        return null;
	    }
	    return new PessoasMalaDiretaDto(pessoa.get());
	}
	
	public List<Pessoas> findAll(){
		List<Pessoas> pessoas = pessoasRepository.findAll();
		if (pessoas == null) {
			System.out.println("Não existe nenhuma lista");
			return null;
		}
		if (pessoas.size() == 0) {
			System.out.println("Não tem nenhuma pessoa cadastrada");
			return null;
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
		return pessoasRepository.save(pessoa); 
	}

	public void deleteById(Long id) {
		if (!pessoasRepository.existsById(id)) {
			 System.out.println("Pessoa não encontrada para deletar");
			 throw new EntityNotFoundException("Pessoa não encontrada com o ID: " + id);
		}
		pessoasRepository.deleteById(id);
	}
}
	