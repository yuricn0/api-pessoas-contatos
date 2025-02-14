package br.com.ydcns.AppPessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ydcns.AppPessoas.dto.ContatoDTO;
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
	public ResponseEntity<ContatoDTO> createContato(@RequestBody ContatoDTO contatoDTO) {
		ContatoDTO newContato = contatoService.createContato(contatoDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newContato);	
	}
	
	@Operation(summary = "Busca um contato pelo ID",
			   description = "Retorna os dados de um contato específico.")
	@GetMapping("{id}")
	public ResponseEntity<ContatoDTO> findById(@PathVariable Long id) {
		ContatoDTO findContatoDTO = contatoService.findById(id);
		
		return ResponseEntity.ok(findContatoDTO);	
	}
	
	@Operation(summary = "Lista todos os contatos de uma pessoa pelo ID",
			   description = "Retorna uma lista de contatos de uma pessoa.")
	@GetMapping("/pessoa/{pessoaId}")
	public ResponseEntity<List<ContatoDTO>> findAllById(@PathVariable Long pessoaId) {
		List<ContatoDTO> contatosDTO = contatoService.findContatosByPessoaId(pessoaId);
		
		return ResponseEntity.ok(contatosDTO);				
	}
	
	@Operation(summary = "Atualiza um contato pelo ID",
			   description = "Atualiza um contato existente.")
	@PutMapping("{id}")
	public ResponseEntity<ContatoDTO> update(@RequestBody ContatoDTO contatoDTO) {
		ContatoDTO updContatoDTO = contatoService.update(contatoDTO);
		
		return ResponseEntity.ok(updContatoDTO);
	}
	
	@Operation(summary = "Remove um contato",
			   description = "Exclui um contato existente pelo ID.")
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteByID(@PathVariable Long id) {
		contatoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}