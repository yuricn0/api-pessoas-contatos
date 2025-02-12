package br.com.ydcns.AppPessoas.controllers;

import java.util.List;
import java.util.Optional;

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

import br.com.ydcns.AppPessoas.models.Pessoas;
import br.com.ydcns.AppPessoas.models.PessoasMalaDiretaDTO;
import br.com.ydcns.AppPessoas.services.PessoasService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pessoas")
public class PessoasController {
	
	@Autowired
	PessoasService pessoasService;
	
	@Operation(summary = "Cadastra nova pessoa",
			   description = "Cadastra uma nova pessoa no sistema.")
	@PostMapping  
	public ResponseEntity<Pessoas> createPessoa(@Valid @RequestBody Pessoas pessoa) {
		Pessoas newPessoa = pessoasService.create(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(newPessoa);
	}
	
	@Operation(summary = "Busca uma pessoa pelo ID",
			   description = "Retorna os dados de uma pessoa específica.")
	@GetMapping("{id}") 
	public ResponseEntity<Optional<Pessoas>> findById(@PathVariable Long id) { 
		Optional<Pessoas> pessoa = pessoasService.findById(id);
		return ResponseEntity.ok(pessoa);
	}
	
	@Operation(summary = "Busca uma pessoa pelo ID para mala direta", 
			   description = "Retorna nome e endereço completo de uma pessoa específica para mala direta.")
    @GetMapping("maladireta/{id}")
    public ResponseEntity<Object> findByIdMalaDireta(@PathVariable Long id) {
    	PessoasMalaDiretaDTO pessoaDto = pessoasService.findByIdMalaDireta(id);
		return ResponseEntity.ok(pessoaDto);
    }
    
	@Operation(summary = "Lista todas as pessoas", 
			   description = "Retorna uma lista de todas as pessoas cadastradas.")
    @GetMapping
    public ResponseEntity<List<Pessoas>> findAll(){
    	List<Pessoas> pessoas = pessoasService.findAll();
    	return ResponseEntity.ok(pessoas);
	}
	
	@Operation(summary = "Atualiza uma pessoa",
			   description = "Atualiza os dados de uma pessoa existente pelo ID.")
    @PutMapping("/{id}")
    public ResponseEntity<Pessoas> update(@Valid @RequestBody Pessoas pessoa){
		Pessoas updPessoas = pessoasService.update(pessoa);
		return ResponseEntity.ok(updPessoas);
	}
	
	@Operation(summary = "Remove uma pessoa",
			   description = "Exclui uma pessoa pelo ID.")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pessoasService.deleteById(id); 
        return ResponseEntity.noContent().build();
    }
}
