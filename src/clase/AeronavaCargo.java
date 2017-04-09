package clase;

public class AeronavaCargo extends InterfataAbstractaAeronava {

	int TARIF_UNITAR = 7;
	double NIVEL_RISC = 3;

	InterfataStrategy strategie;

	public AeronavaCargo(String idAeronava) {
		super();
		this.idAeronava = idAeronava;
	}

	public AeronavaCargo() {

	}

	@Override
	public String calculeazaCostTotal() {
		return "costul total pt aeronava cu id-ul: " + this.idAeronava + " este: "
				+ TARIF_UNITAR * NIVEL_RISC * this.greutateMaxima + " euro";
	}

	@Override
	public String toString() {
		return "AeronavaCargo [idAeronava=" + idAeronava + ", greutateMaxima=" + greutateMaxima + "]";
	}

	@Override
	public void afiseazaAeronava() {
		System.out.println(this.toString());
	}

	@Override
	public void setStrategie(String metodaPlata) {
		if (metodaPlata.equalsIgnoreCase("CARD")) {
			strategie = new PlataCard();
			System.out.println(strategie.getModPlata());
		} else if (metodaPlata.equalsIgnoreCase("TRANSFER")) {
			strategie = new PlataTransfer();
			System.out.println(strategie.getModPlata());
		} else if (metodaPlata.equalsIgnoreCase("CASH")) {
			strategie = new PlataCash();
			System.out.println(strategie.getModPlata());
		} else {
			System.out.println("ne pare rau, nu putem accepta aceasta modalitatea de plata");
		}
	}

}
