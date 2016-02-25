package br.com.estatisticapartida.util.dominios;

public enum Acoes {
	KILLED(" killed "), HAS_STARTED("has started"), USING(" using "), WORLD("<WORLD>"), HAS_ENDED("has ended"), BY(" by ");

	private String acao;

	Acoes(String acao) {
		this.acao = acao;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
}
