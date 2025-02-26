package br.com.ydcns.AppPessoas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ydcns.AppPessoas.dto.PessoasDTO;
import br.com.ydcns.AppPessoas.dto.PessoasMalaDiretaDTO;
import br.com.ydcns.AppPessoas.exceptions.FindByIdException;
import br.com.ydcns.AppPessoas.exceptions.ListNullException;
import br.com.ydcns.AppPessoas.models.Pessoas;
import br.com.ydcns.AppPessoas.repositories.PessoasRepository;
import br.com.ydcns.AppPessoas.validations.PessoaValidator;

@Service
public class PessoasService {
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	public PessoasDTO create(PessoasDTO pessoaDTO) {
		PessoaValidator.validarNome(pessoaDTO.getNome());
		PessoaValidator.validarCep(pessoaDTO.getCep());
		PessoaValidator.validarUf(pessoaDTO.getUf());
		
		PessoaValidator.formatarNome(pessoaDTO.getNome());
		PessoaValidator.formatarCep(pessoaDTO.getCep());
		PessoaValidator.formatarUf(pessoaDTO.getUf());
		
		Pessoas pessoa = new Pessoas();
		BeanUtils.copyProperties(pessoaDTO, pessoa);

		pessoa = pessoasRepository.save(pessoa);
		
		return new PessoasDTO(pessoa.getId(), pessoa.getNome(), pessoa.getEndereco(),
							  pessoa.getCep(), pessoa.getCidade(), pessoa.getUf());
	}
	
	public PessoasDTO findById(Long id){
	    Pessoas findPessoa = pessoasRepository.findById(id)
	    		.orElseThrow(FindByIdException::new);
	    
	    PessoasDTO pessoaDTO = new PessoasDTO();
	    BeanUtils.copyProperties(findPessoa, pessoaDTO);
	    
	    return pessoaDTO;
	}
	
	public PessoasMalaDiretaDTO findByIdMalaDireta(Long id) {
	    Pessoas findPessoa = pessoasRepository.findById(id)
	    		.orElseThrow(FindByIdException::new);
	    
	    return new PessoasMalaDiretaDTO(findPessoa);
	}
	
	public List<PessoasDTO> findAll(){
		List<Pessoas> pessoas = pessoasRepository.findAll();
		
		if (pessoas == null) {
			throw new ListNullException();
		}
		if (pessoas.size() == 0) {
			throw new ListNullException();
		}
		
		List<PessoasDTO> pessoasDTOList = new ArrayList<>();
	    for (Pessoas pessoa : pessoas) {	    	
	        PessoasDTO pessoaDTO = new PessoasDTO();
	        
	        pessoaDTO.setId(pessoa.getId());
	        pessoaDTO.setNome(pessoa.getNome());
	        pessoaDTO.setEndereco(pessoa.getEndereco());
	        pessoaDTO.setCep(pessoa.getCep());
	        pessoaDTO.setCidade(pessoa.getCidade());
	        pessoaDTO.setUf(pessoa.getUf());
	        
	        pessoasDTOList.add(pessoaDTO);
	    }		
		return pessoasDTOList;
	}

	public PessoasDTO update(Long id, PessoasDTO pessoaDTO) {		
		
		PessoaValidator.validarNome(pessoaDTO.getNome());
		PessoaValidator.validarCep(pessoaDTO.getCep());
		PessoaValidator.validarUf(pessoaDTO.getUf());

		Pessoas findPessoa = pessoasRepository.findById(id)
				.orElseThrow(FindByIdException::new);

		PessoaValidator.formatarNomeUpd(findPessoa, pessoaDTO.getNome());
	    PessoaValidator.formatarCepUpd(findPessoa, pessoaDTO.getCep());
	    PessoaValidator.formatarUfUpd(findPessoa, pessoaDTO.getUf());

	    pessoasRepository.save(findPessoa);
	    PessoasDTO updPessoaDTO = new PessoasDTO();
	    BeanUtils.copyProperties(findPessoa, updPessoaDTO);

	    return updPessoaDTO;
	}

	
	public void deleteById(Long id) {
		Pessoas pessoa = pessoasRepository.findById(id)
				.orElseThrow(FindByIdException::new);
		pessoasRepository.delete(pessoa);
	}	
}
	