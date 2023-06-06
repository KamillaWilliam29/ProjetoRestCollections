package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
	
}
