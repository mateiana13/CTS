package clase;

public abstract class AbstractPretBilet {

	String clasa;
	int pretBilet;

	public AbstractPretBilet(String clasa) {
		super();
		this.clasa = clasa;
	}

	public abstract double getPret(TipBilet tipBilet);
}
