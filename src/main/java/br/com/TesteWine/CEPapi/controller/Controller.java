package br.com.TesteWine.CEPapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.TesteWine.CEPapi.model.Model;
import br.com.TesteWine.CEPapi.model.BuscaFaixa;
import br.com.TesteWine.CEPapi.repository.Repositorio;
import br.com.TesteWine.CEPapi.service.CEPServive;

@RestController
@RequestMapping("/wine")
public class Controller {

	@Autowired
	private Repositorio buscaRepo;

	@Autowired
	private CEPServive service;

	@PostMapping
	public Model adicionaCep(@RequestBody Model addCep) {
		return service.save(addCep);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Model> update(@PathVariable("id") long id, @RequestBody Model addCep) {
		return buscaRepo.findById(id).map(record -> {
			record.setCodigoLoja(addCep.getCodigoLoja());
			record.setFaixaInicio(addCep.getFaixaInicio());
			record.setFaixaFim(addCep.getFaixaFim());
			Model updated = buscaRepo.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return buscaRepo.findById(id).map(record -> {
			buscaRepo.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<Model>> listaCEP() {
		return ResponseEntity.ok().body(buscaRepo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Model> buscaPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(buscaRepo.findById(id).get());
	}

	@GetMapping("/direcionamento")
	public List<BuscaFaixa> findCepNome(@RequestParam("cep") int faixaInicio) {
		return this.buscaRepo.findByFaixaCep(faixaInicio).stream().map(BuscaFaixa::converter)
				.collect(Collectors.toList());
	}

}
