package client;

import clase.AeronavaCargo;
import clase.AeronavaFactory;
import clase.AeronavaPasageri;
import clase.Comanda;
import clase.ComandaBuilder;
import clase.ComandaInfo;
import clase.Companie;
import clase.InformatiiComanda;
import clase.InsotitorZbor;
import clase.Pasager;
import clase.PretBilet;
import clase.PretBiletBusiness;
import clase.PretBiletEconomy;
import clase.TipAeronava;
import clase.TipBilet;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("==============test Simple Factory=============");
		AeronavaFactory factory = new AeronavaFactory();
		AeronavaPasageri pasageri = (AeronavaPasageri) factory.createAeronava(TipAeronava.PASAGERI, "P233");
		pasageri.afiseazaAeronava();
		pasageri.setStrategie("card");

		System.out.println("costuri bilete economy: " + pasageri.setClasa("economy"));
		System.out.println("costuri bilete business: " + pasageri.setClasa("business"));
		System.out.println(pasageri.calculeazaCostTotal());
		System.out.println();
		AeronavaCargo cargo = (AeronavaCargo) factory.createAeronava(TipAeronava.CARGO, "C435");
		cargo.afiseazaAeronava();
		cargo.setStrategie("transfer");
		System.out.println(cargo.calculeazaCostTotal());

		System.out.println();
		System.out.println("==============test Singleton Companie=============");
		Companie companie1 = Companie.getInstance();
		companie1.setNume("EasyFlight");
		Companie companie2 = Companie.getInstance();
		companie2.setNume("tarom");
		if (companie1 == companie2) {
			System.out.println("referinte egale");
		} else {
			System.out.println("referinte diferite");
		}
		System.out.println("*********adaug aeronavele in lista*********");
		companie1.adaugaAeronava(pasageri);
		companie1.adaugaAeronava(cargo);
		companie1.getNumarAeronave();
		companie1.afiseazaListaAeronave();
		System.out.println("*********sterg o aeronava din lista*********");
		companie1.stergeAeronava(pasageri);
		companie1.getNumarAeronave();
		companie1.afiseazaListaAeronave();
		System.out.println("*********sterg toata lista de aeronave********");
		companie1.stergeAeronava(cargo);
		companie1.afiseazaListaAeronave();
		companie1.getNumarAeronave();

		System.out.println();

		System.out.println("==========test Builder Comanda===========");
		Comanda comanda1 = new ComandaBuilder().buildNume("ana").buildVarsta(23).buildNationaliate("roman")
				.buildOrasPleacare("bucuresti").buildZiPlecare("23.05.2016").buildOraPlecare(12)
				.buildOrasDestinatie("madrid").buildZiSosire("23.05.2016").buildOraSosire(16)
				.buildTipBilet(TipBilet.ADULT).buildBagajCala(false).buildModPlata("card").buildClasaBilet("economy")
				.build();

		System.out.println(comanda1.toString());
		companie1.adaugaComanda("ana", comanda1);
		companie1.arataListaComenzi();
		companie1.getNumarComenzi();
		Comanda comanda2 = new ComandaBuilder().buildNume("mark").buildVarsta(23).buildNationaliate("roman")
				.buildOrasPleacare("bucuresti").buildZiPlecare("23.05.2016").buildOraPlecare(12)
				.buildOrasDestinatie("madrid").buildZiSosire("23.05.2016").buildOraSosire(16)
				.buildTipBilet(TipBilet.ADULT).buildBagajCala(false).buildModPlata("card").buildClasaBilet("economy")
				.build();

		companie1.adaugaComanda("mark", comanda2);
		companie1.getNumarComenzi();
		companie1.arataListaComenzi();
		companie1.stergeComanda("ana");
		companie1.getNumarComenzi();
		companie1.arataListaComenzi();

		System.out.println();
		System.out.println("===========test Memento pentru Comanda=============");
		System.out.println();

		InformatiiComanda informatiiComanda = new InformatiiComanda();
		ComandaInfo comandaInfo = new ComandaInfo("m3v5k");
		comandaInfo.adaugaInfo("matei", 20, "roman", "brasov", "25/05/2016", 23, "oslo", "26/05/2016", 4,
				TipBilet.ADULT, false, "card", "business");

		informatiiComanda.addSalvare(comandaInfo.salveazaComanda());

		comandaInfo.adaugaInfo("dumitru", 56, "roman", "cluj", "12/05/2016", 12, "budapesta", "12/05/2016", 14,
				TipBilet.ADULT, true, "cash", "economy");

		informatiiComanda.addSalvare(comandaInfo.salveazaComanda());

		comandaInfo.restoreFromMemento(informatiiComanda.recupereazaUltimaSalvare());
		// comandaInfo.restoreFromMemento(informatiiComanda.recupereazaUltimaSalvare());
		// comandaInfo.restoreFromMemento(informatiiComanda.recupereazaUltimaSalvare());
		System.out.println(comandaInfo.getInformatii());

		System.out.println("=================test Observer===============");
		Pasager pasager = new Pasager("cristi", "22234", 1);
		InsotitorZbor insotitorZbor = new InsotitorZbor("suzzy");
		pasageri.abonareHandler(insotitorZbor);
		pasageri.adaugaPasager(pasager);
		System.out.println("\tadaug si al doilea pasager ~~~~");
		Pasager pasager2 = new Pasager("dan", "4334", 2);
		pasageri.adaugaPasager(pasager2);
		System.out.println("\tfac checkout celui de-al doilea pasager ~~~~");
		pasageri.stergePasager(pasager2);
		Pasager pasager3 = new Pasager("john", "das424", 3);
		System.out.println("\tmai adaug un observator ~~~~");
		InsotitorZbor insotitorZbor2 = new InsotitorZbor("carla");
		pasageri.abonareHandler(insotitorZbor2);
		pasageri.adaugaPasager(pasager3);
		System.out.println("\tdezabonez un observator ~~~~");
		pasageri.dezabonareHandler(insotitorZbor);
		pasageri.stergePasager(pasager3);

		System.out.println();

		System.out.println(
				"============test Decorator Preturi Bilete Pasageri in functie de clasa la care au cumparat==============");

		PretBilet pretGeneral = new PretBilet("economy");
		System.out.println(pretGeneral.getPret(TipBilet.COPIL));
		System.out.println(pretGeneral.getPret(TipBilet.BEBELUS));
		System.out.println(pretGeneral.getPret(TipBilet.ADULT));
		System.out.println("\tpreturile pentru economy ~~~~");
		PretBiletEconomy pretEconomy = new PretBiletEconomy("economy", pretGeneral);
		System.out.println("economy-COPIL: " + pretEconomy.getPret(TipBilet.COPIL));
		System.out.println("economy-BEBELUS: " + pretEconomy.getPret(TipBilet.BEBELUS));
		System.out.println("economy-ADULT: " + pretEconomy.getPret(TipBilet.ADULT));
		System.out.println("\tpreturile pentru business ~~~~");
		PretBiletBusiness pretBusiness = new PretBiletBusiness("business", pretGeneral);
		System.out.println("business-COPIL: " + pretBusiness.getPret(TipBilet.COPIL));
		System.out.println("business-BEBELUS: " + pretBusiness.getPret(TipBilet.BEBELUS));
		System.out.println("business-ADULT: " + pretBusiness.getPret(TipBilet.ADULT));

		System.out.println();

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		ComandaBuilder comandaBuilder = new ComandaBuilder();
		System.out.println(comandaBuilder.faScumpire(1.15, pretGeneral));
		System.out.println(comandaBuilder.faIeftinire(0.9, pretGeneral));
	}

}
