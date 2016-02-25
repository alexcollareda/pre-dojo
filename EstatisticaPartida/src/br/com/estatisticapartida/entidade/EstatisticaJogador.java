package br.com.estatisticapartida.entidade;

import java.io.Serializable;

public class EstatisticaJogador implements Serializable {
	private static final long serialVersionUID = 1L;

	private int qntdEliminacoes;

	private int qntdMortes;

	private Arma armaPrincipal;

	private boolean recompesaInvict;

	private boolean recompesaMultiKill;

	public int getQntdEliminacoes() {
		return qntdEliminacoes;
	}

	public void setQntdEliminacoes(int qntdEliminacoes) {
		this.qntdEliminacoes = qntdEliminacoes;
	}

	public int getQntdMortes() {
		return qntdMortes;
	}

	public void setQntdMortes(int qntdMortes) {
		this.qntdMortes = qntdMortes;
	}

	public boolean isRecompesaMultiKill() {
		return recompesaMultiKill;
	}

	public void setRecompesaMultiKill(boolean recompesaMultiKill) {
		this.recompesaMultiKill = recompesaMultiKill;
	}

	public boolean isRecompesaInvict() {
		return recompesaInvict;
	}

	public void setRecompesaInvict(boolean recompesaInvict) {
		this.recompesaInvict = recompesaInvict;
	}

	public Arma getArmaPrincipal() {
		return armaPrincipal;
	}

	public void setArmaPrincipal(Arma armaPrincipal) {
		this.armaPrincipal = armaPrincipal;
	}

}