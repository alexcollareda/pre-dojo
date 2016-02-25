package br.com.estatisticapartida.bo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import br.com.estatisticapartida.entidade.Jogador;
import br.com.estatisticapartida.entidade.Partida;
import br.com.estatisticapartida.util.DesmontarLinha;
import br.com.estatisticapartida.util.EstatisticaJogadorBI;
import br.com.estatisticapartida.util.EstatisticaPartidaBI;
import br.com.estatisticapartida.util.dominios.Acoes;

public class RankingBO {
	private DesmontarLinha dl;

	public void desmontarTxt(Partida partida, String caminhoArquivo) {
		try {
			dl = new DesmontarLinha(partida);

			FileReader arq = new FileReader(caminhoArquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {
				analizarLinha(linha);
				linha = lerArq.readLine();
			}

			arq.close();

		} catch (ParseException e) {
			System.out.println("problema encontrado na data de alguma linha de registro");
		} catch (FileNotFoundException e) {
			System.out.println("arquivo não encontrado");
		} catch (IOException e) {
			System.out.println("!Erro!");
		}
	}

	public void analizarLinha(String linha) throws ParseException {
		if (linha.contains(Acoes.HAS_STARTED.getAcao())) {
			dl.desmonstarInicioPartinda(linha);
			return;
		}

		if (linha.contains(Acoes.HAS_ENDED.getAcao())) {
			dl.desmonstarFimPartinda(linha);
			return;
		}

		if (linha.contains(Acoes.KILLED.getAcao()) && linha.contains(Acoes.USING.getAcao())) {
			dl.desmontarMortesPorArma(linha);
			return;
		}

		if (linha.contains(Acoes.WORLD.getAcao()) && linha.contains(Acoes.KILLED.getAcao())) {
			dl.desmontarMorte(linha);
			return;
		}
	}

	public List<Jogador> buscarEstatisticaJogador(Partida partida) {
		EstatisticaJogadorBI ejBI = new EstatisticaJogadorBI();
		return ejBI.buscarBIJogador(partida);
	}

	public void buscarEstatisticaPartida(List<Jogador> listaJogadores, Partida partida) {
		EstatisticaPartidaBI epBI = new EstatisticaPartidaBI();
		epBI.buscarBIPartida(listaJogadores, partida);
	}

}
