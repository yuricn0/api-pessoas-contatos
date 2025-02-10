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
import br.com.ydcns.AppPessoas.models.PessoasMalaDiretaDto;
import br.com.ydcns.AppPessoas.services.PessoasService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoasController {
	
	@Autowired
	PessoasService pessoasService;
	
	@PostMapping  
	public ResponseEntity<Pessoas> createPessoa(@RequestBody Pessoas pessoa) {
		Pessoas newPessoa = pessoasService.createPessoa(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(newPessoa);
	}
	
	@GetMapping("{id}") 
	public ResponseEntity<Optional<Pessoas>> findById(@PathVariable Long id) { 
		Optional<Pessoas> pessoa = pessoasService.findById(id);
		return ResponseEntity.ok(pessoa);
	}
	
    @GetMapping("maladireta/{id}")
    public ResponseEntity<Object> findByIdMalaDireta(@PathVariable Long id) {
    	PessoasMalaDiretaDto pessoaDto = pessoasService.findByIdMalaDireta(id);
		return ResponseEntity.ok(pessoaDto);
    }
    
    @GetMapping
    public ResponseEntity<List<Pessoas>> findAll(){
    	List<Pessoas> pessoas = pessoasService.findAll();
    	return ResponseEntity.ok(pessoas);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Pessoas> update(@RequestBody Pessoas pessoa){
		Pessoas updPessoas = pessoasService.update(pessoa);
		return ResponseEntity.ok(updPessoas);
	}
	
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pessoasService.deleteById(id); 
        return ResponseEntity.noContent().build();
    }
}
