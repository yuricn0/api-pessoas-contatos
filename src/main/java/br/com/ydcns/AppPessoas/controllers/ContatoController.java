package br.com.ydcns.AppPessoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ydcns.AppPessoas.models.Contato;
import br.com.ydcns.AppPessoas.models.ContatoDTO;
import br.com.ydcns.AppPessoas.services.ContatoService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;	
	
	@Operation(summary = "Cadastra novo contato",
			   description = "Cadastra um novo contato a uma pessoa.")
	@PostMapping
	public ResponseEntity<Contato> createContato(@RequestBody ContatoDTO contatoDTO) {
		Contato newContato = contatoService.createContato(
				contatoDTO.getTipoContato(),
				contatoDTO.getContato(),
				contatoDTO.getPessoaId()
			);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newContato);	
	}
}
