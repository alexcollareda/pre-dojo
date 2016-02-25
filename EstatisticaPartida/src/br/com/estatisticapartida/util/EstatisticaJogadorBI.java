package br.com.estatisticapartida.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.estatisticapartida.entidade.EventoPartida;
import br.com.estatisticapartida.entidade.Jogador;
import br.com.estatisticapartida.entidade.Partida;
import br.com.estatisticapartida.util.dominios.Acoes;

public class EstatisticaJogadorBI {

	public List<Jogador> buscarBIJogador(Partida partida) {
		List<Jogador> listaJogadorRetorno = new ArrayList<Jogador>();

		for (EventoPartida eventoItem : partida.getListaEventoPartida()) {

			if (listaJogadorRetorno.contains(eventoItem.getJogadorAfetado())) {
				for (Jogador jogador : listaJogadorRetorno) {
					if (jogador.equals(eventoItem.getJogadorAfetado()))
						jogador.setQntdMortes(jogador.getQntdMortes() + 1);
				}

			}

			if (listaJogadorRetorno.contains(eventoItem.getJogarEfetuou()) && !eventoItem.getJogarEfetuou().getNome().equals(Acoes.WORLD.getAcao())) {
				for (Jogador jogador : listaJogadorRetorno) {
					if (jogador.equals(eventoItem.getJogarEfetuou()))
						jogador.setQntdEliminacoes(jogador.getQntdEliminacoes() + 1);
				}
			}

			if (!listaJogadorRetorno.contains(eventoItem.getJogarEfetuou()) && !eventoItem.getJogarEfetuou().getNome().equals(Acoes.WORLD.getAcao())) {
				Jogador novoJogador = new Jogador(eventoItem.getJogarEfetuou().getNome());
				novoJogador.setQntdEliminacoes(novoJogador.getQntdEliminacoes() + 1);
				listaJogadorRetorno.add(novoJogador);
			}

			if (!listaJogadorRetorno.contains(eventoItem.getJogadorAfetado())) {
				Jogador novoJogador = new Jogador(eventoItem.getJogadorAfetado().getNome());
				novoJogador.setQntdMortes(novoJogador.getQntdMortes() + 1);
				listaJogadorRetorno.add(novoJogador);
			}

		}

		Collections.sort(listaJogadorRetorno);
		atribuirRecompensaJogador(listaJogadorRetorno, partida.getListaEventoPartida());

		return listaJogadorRetorno;
	}

	private void atribuirRecompensaJogador(List<Jogador> jogadoresEAcoes, List<EventoPartida> eventoPartida) {
		for (Jogador jogador : jogadoresEAcoes) {

			if (jogador.getQntdMortes() == 0)
				jogador.setRecompesaInvict(true);

			for (EventoPartida ep : eventoPartida) {
				int sequenciaEliminacoes = 0;
				if (ep.getJogarEfetuou().equals(jogador)) {

					for (EventoPartida ep2 : eventoPartida) {
						if (ep2.getJogarEfetuou().equals(ep.getJogarEfetuou()))
							if (ep2.getDataAcontecimento().equals(ep.getDataAcontecimento())
									|| (ep2.getDataAcontecimento().after(ep.getDataAcontecimento()) && ep2.getDataAcontecimento().before(adicionarMinutoData(ep.getDataAcontecimento()))))
								sequenciaEliminacoes++;
					}
				}
				if (sequenciaEliminacoes == 5 || sequenciaEliminacoes > 5)
					jogador.setRecompesaMultiKill(true);
			}
		}
	}

	public Date adicionarMinutoData(Date dataInicio) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dataInicio);
		gc.add(Calendar.MINUTE, 1);
		return gc.getTime();
	}
}