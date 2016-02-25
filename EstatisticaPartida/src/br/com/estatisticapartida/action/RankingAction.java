package br.com.estatisticapartida.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;

import br.com.estatisticapartida.bo.RankingBO;
import br.com.estatisticapartida.entidade.Jogador;
import br.com.estatisticapartida.entidade.Partida;
import br.com.estatisticapartida.util.upload.UploadUtils;

@ManagedBean
public class RankingAction {
	private Part file1;

	private Partida partida;

	private RankingBO rankingBO;

	private List<Jogador> listaJogador;

	@PostConstruct
	public void init() {
		rankingBO = new RankingBO();
		partida = new Partida();
	}

	public void doUpload(FileUploadEvent fileUploadEvent) throws IOException {
		carregarArquivo(UploadUtils.gravarTxt(fileUploadEvent));
	}

	public void carregarArquivo(String caminhoArquivo) {
		rankingBO.desmontarTxt(partida, caminhoArquivo);
		buscarListaJogador();
		buscarEstatistcaPartida();
	}

	private void buscarListaJogador() {
		listaJogador = rankingBO.buscarEstatisticaJogador(partida);
	}

	private void buscarEstatistcaPartida() {
		rankingBO.buscarEstatisticaPartida(listaJogador, partida);
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Jogador> getListaJogador() {
		return listaJogador;
	}

	public void setListaJogador(List<Jogador> listaJogador) {
		this.listaJogador = listaJogador;
	}

	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
	}

}