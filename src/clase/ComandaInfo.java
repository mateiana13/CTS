package clase;

public class ComandaInfo {

	private StringBuilder infoComanda;

	private String idComanda;

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

	public ComandaInfo(String idComanda) {

		this.infoComanda = new StringBuilder();
		this.idComanda = idComanda;
	}

	public void adaugaInfo(String nume, int varsta, String nationalitate, String orasPlecare, String ziPlecare,
			int oraPlecare, String orasDestinatie, String ziSosire, int oraSosire, TipBilet tipBilet, boolean bagajCala,
			String modPlata, String clasa) {

		infoComanda.append("\nnume: " + nume + "\n");
		infoComanda.append("varsta: " + varsta + "\n");
		infoComanda.append("nationalitatea: " + nationalitate + "\n");
		infoComanda.append("orasul de plecare: " + orasPlecare + "\n");
		infoComanda.append("ziua plecarii: " + ziPlecare + "\n");
		infoComanda.append("ora plecarii: " + oraPlecare + "\n");
		infoComanda.append("orasul destinatie: " + orasDestinatie + "\n");
		infoComanda.append("ziua sosirii: " + ziSosire + "\n");
		infoComanda.append("ora sosirii: " + oraSosire + "\n");
		infoComanda.append("tipul de bilet: " + tipBilet + "\n");
		infoComanda.append("bagaj cala?: " + bagajCala + "\n");
		infoComanda.append("modalitatea de plata: " + modPlata + "\n");
		infoComanda.append("clasa: " + clasa + "\n");
	}

	public ComandaMemento salveazaComanda() {
		System.out.println("Salvare informatii comanda");
		return new ComandaMemento(this.infoComanda.toString());
	}

	public void restoreFromMemento(ComandaMemento salvare) {
		this.infoComanda = new StringBuilder();
		this.infoComanda.append(salvare.getInformatiiSalvate());
	}

	public String getInformatii() {
		return this.infoComanda.toString();
	}

}
