package br.com.TesteWine.CEPapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jboss.logging.Message;

@Entity
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codigoLoja;

	@Column(nullable = false, length = 8)
	private int faixaInicio;

	@Column(nullable = false, length = 8)
	private int faixaFim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoLoja() {
		return codigoLoja;
	}

	public void setCodigoLoja(String codigoLoja) {
		this.codigoLoja = codigoLoja;
	}

	public int getFaixaInicio() {
		return faixaInicio;
	}

	public void setFaixaInicio(int faixaInicio) {
		this.faixaInicio = faixaInicio;
	}

	public int getFaixaFim() {
		return faixaFim;
	}

	public void setFaixaFim(int faixaFim) {
		this.faixaFim = faixaFim;
	}

}