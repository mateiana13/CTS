package clase;

import java.util.ArrayList;

public class AeronavaPasageri extends InterfataAbstractaAeronava implements InterfataBiletPasager {

	InterfataStrategy strategie;

	int PRET_ECONOMY = 150;
	int PRET_BUSINESS = 270;

	ArrayList<HandlerCheckin> listaInsotoriZbor = new ArrayList<>(); // lista de
																		// observatori
	static ArrayList<Pasager> listaPasageri = new ArrayList<>();

	public AeronavaPasageri(String idAeronava) {
		super();
		this.idAeronava = idAeronava;
	}

	public AeronavaPasageri() {

	}

	@Override
	public String calculeazaCostTotal() {
		return "costul total pt aeronava cu id-ul:" + this.idAeronava + " este: "
				+ (PRET_ECONOMY * this.nrLocuriEconomy + PRET_BUSINESS * this.nrLocuriBusiness) + " euro";
	}

	@Override
	public String toString() {
		return "AeronavaPasageri [idAeronava=" + idAeronava + ", nrLocuriEconomy=" + nrLocuriEconomy
				+ ", nrLocuriBusiness=" + nrLocuriBusiness + "]";
	}

	@Override
	public void afiseazaAeronava() {
		System.out.println(this.toString());
	}

	@Override
	public double setClasa(String clasa) {
		double cost = 0;
		if (clasa.equalsIgnoreCase("ECONOMY")) {
			cost = PRET_ECONOMY * this.nrLocuriEconomy;
		} else if (clasa.equalsIgnoreCase("BUSINESS")) {
			cost = PRET_BUSINESS * this.nrLocuriBusiness;
		}
		return cost;
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

	public void abonareHandler(HandlerCheckin handler) {
		if (listaInsotoriZbor != null)
			listaInsotoriZbor.add(handler);
	}

	public void dezabonareHandler(HandlerCheckin handler) {
		if (listaInsotoriZbor != null)
			listaInsotoriZbor.remove(handler);
	}

	public void notificareObservatoriLaCheckin() {
		if (listaInsotoriZbor != null)
			for (int i = 0; i < listaInsotoriZbor.size(); i++)
				listaInsotoriZbor.get(i).checkin();
	}

	public void notificareObservatoriLaCheckout() {
		if (listaInsotoriZbor != null)
			for (int i = 0; i < listaInsotoriZbor.size(); i++)
				listaInsotoriZbor.get(i).checkout();
	}

	public void adaugaPasager(Pasager pasager) {
		if (!listaPasageri.contains(pasager)) {
			listaPasageri.add(pasager);
			notificareObservatoriLaCheckin();
		} else {
			System.out.println("pasagerul a urcat deja");
		}
	}

	public void stergePasager(Pasager pasager) {
		if (listaPasageri.contains(pasager)) {
			listaPasageri.remove(pasager);
			notificareObservatoriLaCheckout();
		} else {
			System.out.println("acest pasager nu a zburat cu acest avion");
		}
	}

}
