package br.com.estatisticapartida.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.estatisticapartida.entidade.Arma;
import br.com.estatisticapartida.entidade.EventoPartida;
import br.com.estatisticapartida.entidade.Jogador;
import br.com.estatisticapartida.entidade.Partida;

public class EstatisticaPartidaBI {

	public void buscarBIPartida(List<Jogador> jogadoresEAcoes, Partida partida) {
		partida.setJogadorVencedor(buscarJogadorCampeao(jogadoresEAcoes));
		partida.getJogadorVencedor().setArmaPrincipal(buscarArmaPrincipalCampeao(partida));
	}

	private Jogador buscarJogadorCampeao(List<Jogador> jogadoresEAcoes) {
		Jogador jogadorCampeao = new Jogador();

		for (Jogador jogador : jogadoresEAcoes) {
			if (jogador.getQntdEliminacoes() > jogadorCampeao.getQntdEliminacoes())
				jogadorCampeao = jogador;
			else if (jogador.getQntdEliminacoes() == jogadorCampeao.getQntdEliminacoes() && jogador.getQntdMortes() < jogadorCampeao.getQntdMortes())
				jogadorCampeao = jogador;
		}

		return jogadorCampeao;
	}

	private Arma buscarArmaPrincipalCampeao(Partida partida) {
		List<Arma> listArma = new ArrayList<Arma>();

		for (EventoPartida ep : partida.getListaEventoPartida()) {
			if (ep.getJogarEfetuou().equals(partida.getJogadorVencedor())) {

				if (listArma.contains(ep.getArma())) {
					for (Arma a : listArma) {
						if (a.equals(ep.getArma()))
							a.setVezesUtilizada(a.getVezesUtilizada() + 1);
					}
				} else {
					listArma.add(ep.getArma());
				}
			}
		}

		Collections.sort(listArma);
		return listArma.get(0);
	}
}