package clase;

public class Comanda {

	private String nume;
	private int varsta;
	private String nationalitate;
	private String orasPlecare;
	private String ziPlecare;
	private int oraPlecare;
	private String orasDestinatie;
	private String ziSosire;
	private int oraSosire;
	private TipBilet tipBilet;
	private boolean bagajCala;
	private String modPlata;
	private String clasa;

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) throws Exception {
		if (nume != null && nume.length() >= 2) {
			this.nume = nume;
		} else {
			throw new Exception("Lipsa nume");
		}

	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) throws Exception {
		if (varsta > 0 && varsta <= 90) {
			this.varsta = varsta;
		} else {
			throw new Exception("Valoarea pentru varsta este gresita");
		}
	}

	public String getNationalitate() {
		return nationalitate;
	}

	public void setNationalitate(String nationalitate) {
		this.nationalitate = nationalitate;
	}

	public String getOrasPlecare() {
		return orasPlecare;
	}

	public void setOrasPlecare(String orasPlecare) throws Exception {
		if (orasPlecare != null && !orasPlecare.isEmpty()) {
			this.orasPlecare = orasPlecare;
		} else {
			throw new Exception("va rugam sa completati orasul de plecare");
		}
	}

	public String getZiPlecare() {
		return ziPlecare;
	}

	public void setZiPlecare(String ziPlecare) throws Exception {
		if (ziPlecare != null && !ziPlecare.isEmpty()) {
			this.ziPlecare = ziPlecare;
		} else {
			throw new Exception("va rugam completati ziua de plecare");
		}
	}

	public int getOraPlecare() {
		return oraPlecare;
	}

	public void setOraPlecare(int oraPlecare) throws Exception {
		if (oraPlecare >= 0 && oraPlecare <= 24) {
			this.oraPlecare = oraPlecare;
		} else {
			throw new Exception("ora este gresita");
		}
	}

	public String getOrasDestinatie() {
		return orasDestinatie;
	}

	public void setOrasDestinatie(String orasDestinatie) throws Exception {
		if (orasDestinatie != null && !orasDestinatie.isEmpty()) {
			this.orasDestinatie = orasDestinatie;
		} else {
			throw new Exception("va rugam completati orasul destinatie");
		}
	}

	public String getZiSosire() {
		return ziSosire;
	}

	public void setZiSosire(String ziSosire) {
		this.ziSosire = ziSosire;
	}

	public int getOraSosire() {
		return oraSosire;
	}

	public void setOraSosire(int oraSosire) {
		this.oraSosire = oraSosire;
	}

	public TipBilet getTipBilet() {
		return tipBilet;
	}

	public void setTipBilet(TipBilet tipBilet) throws Exception {
		if (tipBilet != null) {
			this.tipBilet = tipBilet;
		} else {
			throw new Exception("va rugam selectati tipul de bilet dorit");
		}

	}

	public boolean isBagajCala() {
		return bagajCala;
	}

	public void setBagajCala(boolean bagajCala) {
		this.bagajCala = bagajCala;
	}

	public void getModPlata(InterfataStrategy plata) {
		System.out.println(plata.getModPlata());

	}

	public void setModPlata(String plata) {
		if (plata.equalsIgnoreCase("card")) {
			PlataCard card = new PlataCard();
			modPlata = card.getModPlata();
		} else if (modPlata.equalsIgnoreCase("transfer")) {
			PlataTransfer transfer = new PlataTransfer();
			modPlata = transfer.getModPlata();
		} else if (modPlata.equalsIgnoreCase("cash")) {
			PlataCash cash = new PlataCash();
			modPlata = cash.getModPlata();
		}
	}

	public String getClasa() {
		return this.clasa;
	}

	public void setClasa(String clasa) throws Exception {
		if (clasa.equals("economy") || clasa.equals("business")) {
			this.clasa = clasa;
		} else {
			throw new Exception("clasa este gresita. va rugam verificati alegerea d-voastra");
		}
	}

	@Override
	public String toString() {
		return "Comanda [nume=" + nume + ", varsta=" + varsta + ", nationalitate=" + nationalitate + ", orasPlecare="
				+ orasPlecare + ", ziPlecare=" + ziPlecare + ", oraPlecare=" + oraPlecare + ", \norasDestinatie="
				+ orasDestinatie + ", ziSosire=" + ziSosire + ", oraSosire=" + oraSosire + ", tipBilet=" + tipBilet
				+ ", bagajCala=" + bagajCala + ", modPlata=" + modPlata + ", clasa=" + clasa + "]";
	}

}
