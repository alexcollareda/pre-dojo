package br.com.estatisticapartida.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.estatisticapartida.bo.RankingBO;
import br.com.estatisticapartida.entidade.Jogador;
import br.com.estatisticapartida.entidade.Partida;

public class RankingTeste {

	private RankingBO bo;

	private Partida partida;

	private List<Jogador> listaJogador;

	@Before
	public void inicializar() {
		bo = new RankingBO();
		partida = new Partida();
		listaJogador = new ArrayList<Jogador>();
	}

	@Test
	public void lerArquivoTxt() {
		bo.desmontarTxt(partida, "C:\\partida.txt");
		buscarListaJogadores();
		buscarEstatisticaPartida();
	}

	public void buscarListaJogadores() {
		listaJogador = bo.buscarEstatisticaJogador(partida);
	}

	public void buscarEstatisticaPartida() {
		bo.buscarEstatisticaPartida(listaJogador, partida);
	}
}
