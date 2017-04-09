package clase;

public class AeronavaFactory {

	InterfataAbstractaAeronava aeronava = null;

	public InterfataAbstractaAeronava createAeronava(TipAeronava tipAeronava, String idAeronava) throws Exception {

		switch (tipAeronava) {
		case CARGO:
			aeronava = new AeronavaCargo();
			aeronava.setIdAeronava(idAeronava);
			aeronava.setGreutateMaxima(250000);
			break;
		case PASAGERI:
			aeronava = new AeronavaPasageri();
			aeronava.setIdAeronava(idAeronava);
			aeronava.setNrLocuriEconomy(250);
			aeronava.setNrLocuriBusiness(50);
			break;
		default:
			break;
		}
		return aeronava;
	}

}
