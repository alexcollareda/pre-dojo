package br.com.estatisticapartida.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.estatisticapartida.entidade.Arma;
import br.com.estatisticapartida.entidade.EventoPartida;
import br.com.estatisticapartida.entidade.Jogador;
import br.com.estatisticapartida.entidade.Partida;
import br.com.estatisticapartida.util.dominios.Acoes;

public class DesmontarLinha implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final int POSICAO_APOS_DATA = 22;

	private Partida partida;

	private EventoPartida eventoPartida;

	private SimpleDateFormat formatar;

	public DesmontarLinha(Partida partida) {
		this.partida = partida;
		formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}

	public void desmontarMortesPorArma(String linha) throws ParseException {
		int indexKilled = linha.indexOf(Acoes.KILLED.getAcao());
		int indexUsing = linha.indexOf(Acoes.USING.getAcao());

		eventoPartida = new EventoPartida();
		eventoPartida.setJogarEfetuou(new Jogador(linha.substring(POSICAO_APOS_DATA, indexKilled).trim()));
		eventoPartida.setJogadorAfetado(new Jogador(linha.substring(linha.lastIndexOf(Acoes.KILLED.getAcao()), indexUsing).replace(Acoes.KILLED.getAcao(), "").trim()));
		eventoPartida.setArma(new Arma(linha.substring(linha.indexOf(Acoes.USING.getAcao()), linha.length()).replace(Acoes.USING.getAcao(), "").trim()));
		eventoPartida.setDataAcontecimento(formatar.parse(linha.substring(0, 19)));

		if (partida.getListaEventoPartida() == null)
			partida.setListaEventoPartida(new ArrayList<EventoPartida>());

		partida.getListaEventoPartida().add(eventoPartida);
	}

	public void desmonstarFimPartinda(String linha) throws ParseException {
		partida.setDataFim(formatar.parse(linha.substring(0, 19)));
	}

	public void desmonstarInicioPartinda(String linha) throws ParseException {
		partida.setDataInicio(formatar.parse(linha.substring(0, 19)));
		partida.setNomePartida(linha.substring(linha.indexOf("New match "), linha.indexOf(Acoes.HAS_STARTED.getAcao())).replace("New match ", "").trim());
	}

	public void desmontarMorte(String linha) throws ParseException {
		int indexKilled = linha.indexOf(Acoes.KILLED.getAcao());
		int indexUsing = linha.indexOf(Acoes.BY.getAcao());

		eventoPartida = new EventoPartida();
		eventoPartida.setJogarEfetuou(new Jogador(linha.substring(POSICAO_APOS_DATA, indexKilled).trim()));
		eventoPartida.setJogadorAfetado(new Jogador(linha.substring(linha.lastIndexOf(Acoes.KILLED.getAcao()), indexUsing).replace(Acoes.KILLED.getAcao(), "").trim()));
		eventoPartida.setArma(new Arma(linha.substring(linha.indexOf(Acoes.BY.getAcao()), linha.length()).replace(Acoes.BY.getAcao(), "").trim()));
		eventoPartida.setDataAcontecimento(formatar.parse(linha.substring(0, 19)));

		if (partida.getListaEventoPartida() == null)
			partida.setListaEventoPartida(new ArrayList<EventoPartida>());

		partida.getListaEventoPartida().add(eventoPartida);
	}

}
