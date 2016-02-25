package br.com.estatisticapartida.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Partida extends EstatisticaPartida {
	private static final long serialVersionUID = 1L;

	private String nomePartida;

	private Date dataInicio;

	private List<Jogador> listaJogadores;

	private List<EventoPartida> listaEventoPartida;

	private Date dataFim;

	public String getNomePartida() {
		return nomePartida;
	}

	public void setNomePartida(String nomePartida) {
		this.nomePartida = nomePartida;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public String getDataInicioFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataInicio);
	}

	public String getDataFimFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataFim);
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public List<Jogador> getListaJogadores() {
		return listaJogadores;
	}

	public void setListaJogadores(List<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}

	public List<EventoPartida> getListaEventoPartida() {
		return listaEventoPartida;
	}

	public void setListaEventoPartida(List<EventoPartida> listaEventoPartida) {
		this.listaEventoPartida = listaEventoPartida;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
