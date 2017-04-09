package clase;

public class PretBilet extends AbstractPretBilet {

	public PretBilet(String clasa) {
		super(clasa);
	}

	@Override
	public double getPret(TipBilet tipBilet) {

		switch (tipBilet) {
		case BEBELUS:
			this.pretBilet = 100;
			break;
		case COPIL:
			this.pretBilet = 140;
			break;
		case ADULT:
			this.pretBilet = 200;
			break;
		default:
			break;
		}

		return pretBilet;

	}

}
