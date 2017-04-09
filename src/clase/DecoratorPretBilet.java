package clase;

public class DecoratorPretBilet extends AbstractPretBilet {

	AbstractPretBilet pretBilet;

	public DecoratorPretBilet(String clasa, AbstractPretBilet pretBilet) {
		super(clasa);
		this.pretBilet = pretBilet;
	}

	@Override
	public double getPret(TipBilet tipBilet) {
		return pretBilet.getPret(tipBilet);
	}

}
