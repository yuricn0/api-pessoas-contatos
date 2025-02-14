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

import br.com.ydcns.AppPessoas.dto.PessoasDTO;
import br.com.ydcns.AppPessoas.dto.PessoasMalaDiretaDTO;
import br.com.ydcns.AppPessoas.services.PessoasService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas")
public class PessoasController {
	
	@Autowired
	PessoasService pessoasService;
	
	@Operation(summary = "Cadastra nova pessoa",
			   description = "Cadastra uma nova pessoa no sistema.")
	@PostMapping  
	public ResponseEntity<PessoasDTO> createPessoa(@RequestBody PessoasDTO pessoaDTO) {
		PessoasDTO newPessoa = pessoasService.create(pessoaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(newPessoa);
	}
	
	@Operation(summary = "Busca uma pessoa pelo ID",
			   description = "Retorna os dados de uma pessoa específica.")
	@GetMapping("{id}") 
	public ResponseEntity<PessoasDTO> findById(@PathVariable Long id) { 
		PessoasDTO findPessoaDTO = pessoasService.findById(id);
		return ResponseEntity.ok(findPessoaDTO);
	}
	
	@Operation(summary = "Busca uma pessoa pelo ID para mala direta", 
			   description = "Retorna nome e endereço completo de uma pessoa específica para mala direta.")
    @GetMapping("maladireta/{id}")
    public ResponseEntity<PessoasMalaDiretaDTO> findByIdMalaDireta(@PathVariable Long id) {
    	PessoasMalaDiretaDTO pessoaMalaDiretaDTO = pessoasService.findByIdMalaDireta(id);
		return ResponseEntity.ok(pessoaMalaDiretaDTO);
    }
    
	@Operation(summary = "Lista todas as pessoas", 
			   description = "Retorna uma lista de todas as pessoas cadastradas.")
    @GetMapping
    public ResponseEntity<List<PessoasDTO>> findAll(){
    	List<PessoasDTO> pessoasDTO = pessoasService.findAll();
    	return ResponseEntity.ok(pessoasDTO);
	}
	
	@Operation(summary = "Atualiza uma pessoa",
			   description = "Atualiza os dados de uma pessoa existente pelo ID.")
    @PutMapping("/{id}")
    public ResponseEntity<PessoasDTO> update(@RequestBody PessoasDTO pessoaDTO){
		PessoasDTO updPessoasDTO = pessoasService.update(pessoaDTO);
		return ResponseEntity.ok(updPessoasDTO);
	}
	
	@Operation(summary = "Remove uma pessoa",
			   description = "Exclui uma pessoa pelo ID.")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pessoasService.deleteById(id); 
        return ResponseEntity.noContent().build();
    }
}
