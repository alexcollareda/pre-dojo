package br.com.estatisticapartida.entidade;

import java.io.Serializable;

public class EstatisticaPartida implements Serializable {
	private static final long serialVersionUID = 1L;

	private Jogador JogadorVencedor;

	public Jogador getJogadorVencedor() {
		return JogadorVencedor;
	}

	public void setJogadorVencedor(Jogador jogadorVencedor) {
		JogadorVencedor = jogadorVencedor;
	}

}