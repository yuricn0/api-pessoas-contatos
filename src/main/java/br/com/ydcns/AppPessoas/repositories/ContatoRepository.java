package br.com.ydcns.AppPessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ydcns.AppPessoas.models.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
