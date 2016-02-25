package br.com.estatisticapartida.entidade;


public class Jogador extends EstatisticaJogador implements Comparable<Jogador> {
	private static final long serialVersionUID = 1L;

	private String nome;

	public Jogador() {
	}

	public Jogador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return " Jogador: " + this.getNome() + " Elminações: " + this.getQntdEliminacoes() + " Mortes: " + this.getQntdMortes();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public int compareTo(Jogador jogador) {
		if (this.getQntdEliminacoes() < jogador.getQntdEliminacoes())
			return 1;

		if (this.getQntdEliminacoes() > jogador.getQntdEliminacoes())
			return -1;

		if (this.getQntdEliminacoes() == jogador.getQntdEliminacoes()) {
			if (this.getQntdMortes() < jogador.getQntdMortes())
				return -1;
		}

		return 0;
	}

}
