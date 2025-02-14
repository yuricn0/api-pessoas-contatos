package br.com.ydcns.AppPessoas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ydcns.AppPessoas.dto.ContatoDTO;
import br.com.ydcns.AppPessoas.enums.TipoContato;
import br.com.ydcns.AppPessoas.exceptions.ContatoNotFoundException;
import br.com.ydcns.AppPessoas.exceptions.ContatoNotNullException;
import br.com.ydcns.AppPessoas.exceptions.FindByIdException;
import br.com.ydcns.AppPessoas.exceptions.IdNotNullException;
import br.com.ydcns.AppPessoas.exceptions.PessoaIdNotNullException;
import br.com.ydcns.AppPessoas.exceptions.PessoaNotFoundException;
import br.com.ydcns.AppPessoas.models.Contato;
import br.com.ydcns.AppPessoas.models.Pessoas;
import br.com.ydcns.AppPessoas.repositories.ContatoRepository;
import br.com.ydcns.AppPessoas.repositories.PessoasRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
    public ContatoDTO createContato(ContatoDTO contatoDTO) {	
    	if(contatoDTO.getPessoaId() == null) {
    		throw new PessoaIdNotNullException();
    	}
    	
    	Pessoas pessoa = pessoasRepository.findById(contatoDTO.getPessoaId())
                .orElseThrow(PessoaNotFoundException::new);
    	
      	if (contatoDTO.getContato() == null || contatoDTO.getContato().trim().isEmpty()) {
            throw new ContatoNotNullException();
        }
    	
    	//Validação do enum
    	TipoContato tipoContato = TipoContato.fromString(contatoDTO.getTipoContato());
    	
	    Contato novoContato = new Contato();
	    novoContato.setTipoContato(tipoContato);
	    novoContato.setContato(contatoDTO.getContato());
	    novoContato.setPessoa(pessoa);
	    
	    pessoa.getContato().add(novoContato);
	    
	    contatoRepository.save(novoContato);
	    pessoasRepository.save(pessoa);
	    
	    return new ContatoDTO(novoContato.getTipoContato().name(),
	    					  novoContato.getContato(),
	    					  novoContato.getPessoa().getId());
    }
    	
	public ContatoDTO findById(Long id){
	    Contato contato = contatoRepository.findById(id)
	    		.orElseThrow(FindByIdException::new);
	    
	    ContatoDTO contatoDTO = new ContatoDTO();
	    contatoDTO.setId(contato.getId());
	    contatoDTO.setTipoContato(contato.getTipoContato().name());
	    contatoDTO.setContato(contato.getContato());
	    contatoDTO.setPessoaId(contato.getPessoa().getId());
	  	       
	    return contatoDTO; 
	}
	
	public List<ContatoDTO> findContatosByPessoaId(Long pessoaId){
		List<Contato> contatosPessoaId = contatoRepository.findByPessoaId(pessoaId);
		if (contatosPessoaId.isEmpty()) {
			throw new FindByIdException();
		}
		
		List<ContatoDTO> contatosDTO = new ArrayList<>();
		for (Contato contato : contatosPessoaId) {
			ContatoDTO contatoDTO = new ContatoDTO();
			
			contatoDTO.setId(contato.getId());
			contatoDTO.setPessoaId(contato.getPessoa().getId());
		    contatoDTO.setContato(contato.getContato());
		    contatoDTO.setTipoContato(contato.getTipoContato().name());
		    contatosDTO.add(contatoDTO);
		}
		return contatosDTO;
	}
	
	public ContatoDTO update(ContatoDTO contatoDTO){
		
		if(contatoDTO.getId() == null) {
    		throw new IdNotNullException();
    	}
		  	
      	if (contatoDTO.getContato() == null || contatoDTO.getContato().trim().isEmpty()) {
            throw new ContatoNotNullException();
        }
      	
       	//Validação do enum
    	TipoContato tipoContato = TipoContato.fromString(contatoDTO.getTipoContato());
   
		Contato updContato = contatoRepository.findById(contatoDTO.getId())
				.orElseThrow(ContatoNotFoundException::new);
	 
		updContato.setTipoContato(tipoContato);
	    updContato.setContato(contatoDTO.getContato());
	    		    
	    contatoRepository.save(updContato);
	    
	    return new ContatoDTO(updContato.getTipoContato().name(),
	    					  updContato.getContato(),
	    					  updContato.getPessoa().getId());
    }
	
	public void deleteById(Long id) {
		Contato contato = contatoRepository.findById(id)
				.orElseThrow(FindByIdException::new);
		contatoRepository.delete(contato);
	}	
}

