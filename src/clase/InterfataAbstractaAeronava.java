package clase;

public abstract class InterfataAbstractaAeronava {

	String idAeronava;
	protected int nrLocuriEconomy;
	protected int nrLocuriBusiness;
	protected double greutateMaxima;

	public String getIdAeronava() {
		return idAeronava;
	}

	public void setIdAeronava(String idAeronava) throws Exception {
		if (idAeronava != null && !idAeronava.equals("")) {
			this.idAeronava = idAeronava;
		} else {
			throw new Exception("id-ul aeronavei este null sau un string gol");
		}
	}

	public int getNrLocuriEconomy() {
		return nrLocuriEconomy;
	}

	public void setNrLocuriEconomy(int nrLocuriEconomy) {
		if (nrLocuriEconomy >= 100)
			this.nrLocuriEconomy = nrLocuriEconomy;
	}

	public int getNrLocuriBusiness() {
		return nrLocuriBusiness;
	}

	public void setNrLocuriBusiness(int nrLocuriBusiness) {
		if (nrLocuriBusiness >= 20)
			this.nrLocuriBusiness = nrLocuriBusiness;
	}

	public double getGreutateMaxima() {
		return greutateMaxima;
	}

	public void setGreutateMaxima(double greutateMaxima) {
		this.greutateMaxima = greutateMaxima;
	}

	public abstract String calculeazaCostTotal();

	public abstract void afiseazaAeronava();

	public abstract void setStrategie(String modPlata);

}
