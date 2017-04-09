package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Comanda;

public class TestOrasDestinatie {

	// fixture
	private Comanda comanda;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste pentru orasul destinatie ales de client din Comanda");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste pentru orasul destinatie ales de client din Comanda\n");
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

	// 4.
	@Test
	public void setOrasDestinatieNull() {
		try {
			comanda.setOrasDestinatie(null);
			assertNotNull(comanda.getOrasDestinatie());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setOrasDestinatieEmptyString() {
		try {
			comanda.setOrasDestinatie("");
			assertFalse(comanda.getOrasDestinatie().isEmpty());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setOrasDestinatieCorect() {
		try {
			comanda.setOrasDestinatie("londra");
			assertEquals("orasul asteptat este: ", "londra", comanda.getOrasDestinatie());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
