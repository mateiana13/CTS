package clase;

import java.util.ArrayList;
import java.util.HashMap;

public class Companie {

	private String nume;

	public static ArrayList<InterfataAbstractaAeronava> listaAeronave = new ArrayList<>();

	HashMap<String, Comanda> mapComenzi = new HashMap<>(); // cheia e numele
															// persoanei

	private static Companie companie = null;

	private Companie() {

	}

	public static Companie getInstance() {
		if (companie == null) {
			companie = new Companie();
		}
		return companie;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) throws Exception {
		if (nume != null && !nume.isEmpty()) {
			this.nume = nume;
		} else {
			throw new Exception("numele companiei este null!");
		}
	}

	public static void adaugaAeronava(InterfataAbstractaAeronava aeronava) {
		if (!listaAeronave.contains(aeronava)) {
			listaAeronave.add(aeronava);
		}
	}

	public static void stergeAeronava(InterfataAbstractaAeronava aeronava) {
		if (listaAeronave.contains(aeronava)) {
			listaAeronave.remove(aeronava);
		}
	}

	public static void afiseazaListaAeronave() throws Exception {
		for (InterfataAbstractaAeronava aeronava : listaAeronave) {
			if (aeronava instanceof AeronavaPasageri) {
				aeronava.afiseazaAeronava();
			} else if (aeronava instanceof AeronavaCargo) {
				aeronava.afiseazaAeronava();
			} else {
				throw new Exception("eroare, nu exista acest tip de aeronava");
			}
		}
	}

	public void getNumarAeronave() {
		System.out.println(
				"numarul de aeronave al companiei " + this.nume + " este de: " + listaAeronave.size() + " aeronave");
	}

	public int getNumarAeronave2() {
		return listaAeronave.size();
	}

	public void adaugaComanda(String nume, Comanda comanda) {
		if (mapComenzi.get(nume) != null) {
			System.out.println("NU AVETI VOIE SA CUMPARATI MAI MULT DE UN BILET PE NUMELE DUMNEAVOASTRA");
		}
		mapComenzi.put(nume, comanda);
	}

	public void stergeComanda(String nume) {
		mapComenzi.remove(nume);
	}

	public void getNumarComenzi() {
		System.out.println("numarul de comenzi inregistrate: " + mapComenzi.size());
	}

	public int getNumarComenzi2() {
		return mapComenzi.size();
	}

	public void arataListaComenzi() {
		System.out.println("\nLISTA DE COMENZI:");
		for (String nume : mapComenzi.keySet()) {
			String key = nume.toUpperCase();
			String value = mapComenzi.get(nume).toString();
			System.out.println("\t" + key + " - " + value);
		}
	}

}
