package br.com.estatisticapartida.entidade;

public class Arma implements Comparable<Arma> {

	private String modelo;

	private int vezesUtilizada;

	public Arma(String modelo) {
		this.modelo = modelo;
	}

	public Arma(Arma arma) {
		this.modelo = arma.getModelo();
		this.vezesUtilizada = arma.getVezesUtilizada();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVezesUtilizada() {
		return vezesUtilizada;
	}

	public void setVezesUtilizada(int vezesUtilizada) {
		this.vezesUtilizada = vezesUtilizada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
		Arma other = (Arma) obj;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Arma arma) {
		if (this.getVezesUtilizada() < arma.getVezesUtilizada())
			return 1;

		if (this.getVezesUtilizada() > arma.getVezesUtilizada())
			return -1;

		return 0;
	}
}
