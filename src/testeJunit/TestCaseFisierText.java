package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Comanda;
import clase.ComandaBuilder;

public class TestCaseFisierText {

	static FileReader reader;
	static BufferedReader buffer;
	static Comanda comanda;
	static ComandaBuilder builder;
	static List<Comanda> lista = new Vector<Comanda>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste fisier text");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste fisier text");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("inceput");
		reader = new FileReader("comanda.txt");
		buffer = new BufferedReader(reader);

		assertNotNull(reader);

		String linie = null;
		String[] atribute = null;

		try {
			while ((linie = buffer.readLine()) != null) {
				atribute = linie.split(" ");
				builder = new ComandaBuilder();
				comanda = builder.buildNume(atribute[0]).buildVarsta(Integer.parseInt(atribute[1]))
						.buildNationaliate(atribute[2]).build();
				lista.add(comanda);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("sfarsit");
	}

	@Test
	public void testFisierText() throws IOException {
		System.out.println("in testul pt file text");

		assertEquals("nume: ", lista.get(0).getNume(), "ana");
		assertEquals("varsta: ", lista.get(0).getVarsta(), 22);
		assertEquals("nationalitate: ", lista.get(0).getNationalitate(), "roman");

		assertEquals("nume: ", lista.get(1).getNume(), "john");
		assertEquals("varsta: ", lista.get(1).getVarsta(), 23);
		assertEquals("nationalitate: ", lista.get(1).getNationalitate(), "canadian");

		assertEquals("nume: ", lista.get(2).getNume(), "amellie");
		assertEquals("varsta: ", lista.get(2).getVarsta(), 24);
		assertEquals("nationalitate: ", lista.get(2).getNationalitate(), "francez");
	}

}
