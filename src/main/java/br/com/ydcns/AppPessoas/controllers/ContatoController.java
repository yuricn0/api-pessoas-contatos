package br.com.ydcns.AppPessoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ydcns.AppPessoas.models.Contato;
import br.com.ydcns.AppPessoas.services.ContatosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
	
	@Autowired
	private ContatosService contatosService;	
	
	@Operation(summary = "Cadastra novo contato",
			   description = "Cadastra um novo contato a uma pessoa.")
	@PostMapping
	public ResponseEntity<Contato> createContato(@RequestBody Contato contato) {
		System.out.println("Recebendo requisição: " + contato);
		Contato newContato = contatosService.createContato(contato);
		return ResponseEntity.status(HttpStatus.CREATED).body(newContato);	
	}
}
