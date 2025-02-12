package br.com.ydcns.AppPessoas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ydcns.AppPessoas.enums.TipoContato;
import br.com.ydcns.AppPessoas.exceptions.ContatoNotNullException;
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
	
    public Contato createContato(String tipoContatoStr,
    							 String contato,
    							 Long pessoaId) {
    	
    	Pessoas pessoa = pessoasRepository.findById(pessoaId)
                .orElseThrow(PessoaNotFoundException::new);
    	
    	TipoContato tipoContato = TipoContato.fromString(tipoContatoStr);
    	
    	if (contato == null || contato.trim().isEmpty()) {
            throw new ContatoNotNullException();
        }
    	
	    Contato novoContato = new Contato();
	    novoContato.setTipoContato(tipoContato);
	    novoContato.setContato(contato);
	    novoContato.setPessoa(pessoa);
	    
	    pessoa.getContato().add(novoContato);
	    
	    contatoRepository.save(novoContato);
	    pessoasRepository.save(pessoa);
	    
	    return novoContato;
    }
}

