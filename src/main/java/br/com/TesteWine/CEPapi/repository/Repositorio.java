package br.com.TesteWine.CEPapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.TesteWine.CEPapi.model.Model;

@Repository
public interface Repositorio extends JpaRepository<Model, Long> {

	@Query("FROM Model where ?1 between faixa_inicio and faixa_fim")
	List<Model> findByFaixaCep(int faixaInicio);

}
