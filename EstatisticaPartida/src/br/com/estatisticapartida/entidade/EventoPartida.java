package br.com.estatisticapartida.entidade;

import java.io.Serializable;
import java.util.Date;

public class EventoPartida implements Serializable {
	private static final long serialVersionUID = 1L;

	private Jogador jogarEfetuou;

	private Jogador jogadorAfetado;

	private Arma arma;

	private Date dataAcontecimento;

	public Jogador getJogarEfetuou() {
		return jogarEfetuou;
	}

	public void setJogarEfetuou(Jogador jogarEfetuou) {
		this.jogarEfetuou = jogarEfetuou;
	}

	public Jogador getJogadorAfetado() {
		return jogadorAfetado;
	}

	public void setJogadorAfetado(Jogador jogadorAfetado) {
		this.jogadorAfetado = jogadorAfetado;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Date getDataAcontecimento() {
		return dataAcontecimento;
	}

	public void setDataAcontecimento(Date dataAcontecimento) {
		this.dataAcontecimento = dataAcontecimento;
	}
}
