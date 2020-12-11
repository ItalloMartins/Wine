package br.com.TesteWine.CEPapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.TesteWine.CEPapi.model.Model;
import br.com.TesteWine.CEPapi.repository.Repositorio;

@Service
public class CEPServive {

	@Autowired
	private Repositorio buscaRepo;

	public List<Model> findAllCEPs() {
		return buscaRepo.findAll();
	}

	public Model save(Model m) {
		List<Model> listaDeCeps = findAllCEPs();
		for (Model c : listaDeCeps) {
			if (c.getFaixaInicio() == (m.getFaixaInicio()) || c.getFaixaFim() == (m.getFaixaFim())
					|| c.getFaixaFim() < c.getFaixaInicio()) {
				return null;
			}
		}
		return buscaRepo.save(m);
	}
}
