package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Comanda;

public class TestClasa {

	// fixture
	private Comanda comanda;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste pentru clasa aleasa de client din Comanda");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste pentru clasa aleasa de client din Comanda\n");
	}

	@Before
	public void setUp() throws Exception {
		comanda = new Comanda();
		System.out.println("@Before - setUp pentru Comanda");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After - tearDown pentru Comanda");
	}

	// 8.
	@Test
	public void setClasaCorect() {
		try {
			comanda.setClasa("economy");
			assertEquals("clasa asteptata este: ", "economy", comanda.getClasa());
			comanda.setClasa("business");
			assertEquals("clasa asteptata este: ", "business", comanda.getClasa());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setClasaGresita() {
		try {
			comanda.setClasa("clasa speciala");
			fail("setClasa accepta alte valori in afara de economy si business");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
