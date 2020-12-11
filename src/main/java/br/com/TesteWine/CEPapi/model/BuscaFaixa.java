package br.com.TesteWine.CEPapi.model;

public class BuscaFaixa {

	private Long id;
	private String codigoLoja;
	private int faixaInicio;
	private int faixaFim;

	public class BFaixa {
		private int faixa;

		public int getFaixa() {
			return faixa;
		}

		public void setFaixa(int faixa) {
			this.faixa = faixa;
		}

	}

	public static BuscaFaixa converter(Model b) {
		var busca = new BuscaFaixa();
		busca.setId(b.getId());
		busca.setCodigoLoja(b.getCodigoLoja());
		busca.setFaixaInicio(b.getFaixaInicio());
		busca.setFaixaFim(b.getFaixaFim());
		return busca;
	}

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