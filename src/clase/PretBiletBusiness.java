package clase;

import java.util.Random;

public class PretBiletBusiness extends DecoratorPretBilet {

	public PretBiletBusiness(String clasa, AbstractPretBilet pretBilet) {
		super(clasa, pretBilet);
	}

	@Override
	public double getPret(TipBilet tipBilet) {
		Random rand = new Random();
		return super.getPret(tipBilet) + rand.nextInt(70);
	}

}
