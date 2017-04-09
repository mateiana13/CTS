package clase;

public class ComandaBuilder extends InterfataAbstractaComanda {

	Comanda comanda;

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

	public ComandaBuilder() {
		super();
		this.comanda = new Comanda();
	}

	public ComandaBuilder buildNume(String nume) throws Exception {
		this.comanda.setNume(nume);
		return this;
	}

	public ComandaBuilder buildVarsta(int varsta) throws Exception {
		this.comanda.setVarsta(varsta);
		return this;
	}

	public ComandaBuilder buildNationaliate(String nationalitate) {
		this.comanda.setNationalitate(nationalitate);
		return this;
	}

	public ComandaBuilder buildOrasPleacare(String orasPlecare) throws Exception {
		this.comanda.setOrasPlecare(orasPlecare);
		return this;
	}

	public ComandaBuilder buildZiPlecare(String ziPlecare) throws Exception {
		this.comanda.setZiPlecare(ziPlecare);
		return this;
	}

	public ComandaBuilder buildOraPlecare(int orePlecare) throws Exception {
		this.comanda.setOraPlecare(orePlecare);
		return this;
	}

	public ComandaBuilder buildOrasDestinatie(String orasDestinatie) throws Exception {
		this.comanda.setOrasDestinatie(orasDestinatie);
		return this;
	}

	public ComandaBuilder buildZiSosire(String ziSosire) {
		this.comanda.setZiSosire(ziSosire);
		return this;
	}

	public ComandaBuilder buildOraSosire(int oraSosire) {
		this.comanda.setOraSosire(oraSosire);
		return this;
	}

	public ComandaBuilder buildTipBilet(TipBilet tipBilet) throws Exception {
		this.comanda.setTipBilet(tipBilet);
		return this;
	}

	public ComandaBuilder buildBagajCala(boolean bagajCala) {
		this.comanda.setBagajCala(bagajCala);
		return this;
	}

	public ComandaBuilder buildModPlata(String modPlata) {
		this.comanda.setModPlata(modPlata);
		return this;
	}

	public ComandaBuilder buildClasaBilet(String clasa) throws Exception {
		this.comanda.setClasa(clasa);
		return this;
	}

	@Override
	public Comanda build() {
		return this.comanda;
	}

	public double getPret(PretBilet bilet) {

		return new PretBilet("economy").getPret(TipBilet.ADULT);
	}

	private ModificaPret modificaPret;

	public double faScumpire(double procent, PretBilet bilet) {
		return this.getPret(bilet) * procent;
	}

	public double faIeftinire(double procent, PretBilet bilet) {
		return this.getPret(bilet) * procent;
	}
}
