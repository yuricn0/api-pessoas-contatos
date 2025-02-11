package br.com.ydcns.AppPessoas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ydcns.AppPessoas.exceptions.PessoaNotFoundException;
import br.com.ydcns.AppPessoas.models.Contato;
import br.com.ydcns.AppPessoas.models.Pessoas;
import br.com.ydcns.AppPessoas.repositories.ContatosRepository;
import br.com.ydcns.AppPessoas.repositories.PessoasRepository;

@Service
public class ContatosService {
	
	@Autowired
	private ContatosRepository contatosRepository;
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	public Contato createContato(Contato contato) {
		if (contato.getPessoa() == null || contato.getPessoa().getId() == null) {
            throw new PessoaNotFoundException();
       }
		Pessoas pessoa = pessoasRepository.findById(contato.getPessoa().getId())
		            .orElseThrow(() -> new PessoaNotFoundException());

        contato.setPessoa(pessoa);
    
        pessoa.getContato().add(contato);
 
        Contato contatoSalvo = contatosRepository.save(contato);
        pessoasRepository.save(pessoa);
        
        return contatoSalvo;
   }
}	

