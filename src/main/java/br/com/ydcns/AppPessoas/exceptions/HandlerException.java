package br.com.ydcns.AppPessoas.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{
	
   @ExceptionHandler(NameNotNullException.class)
    public ResponseEntity<Map<String, String>> tratarNomeNulo(NameNotNullException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", ex.getMessage());
		        
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		}	
   
   @ExceptionHandler(FindByIdException.class)
   public ResponseEntity<Map<String, String>> tratarId(FindByIdException ex) {
       Map<String, String> erro = new HashMap<>();
       erro.put("erro", ex.getMessage());
		        
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		}
   
   @ExceptionHandler(ListNullException.class)
   public ResponseEntity<Map<String, String>> tratarListaVazia(ListNullException ex) {
       Map<String, String> erro = new HashMap<>();
       erro.put("erro", ex.getMessage());
		        
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		}	
}
