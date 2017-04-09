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

public class TestZiPlecare {

	// fixture
	private Comanda comanda;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste pentru zi plecare aleasa de client din Comanda");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste pentru zi plecare aleasa de client din Comanda\n");
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

	// 5.
	@Test
	public void setZiPlecareNull() {
		try {
			comanda.setZiPlecare(null);
			assertNotNull(comanda.getZiPlecare());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setZiPlecareEmptyString() {
		try {
			comanda.setZiPlecare("");
			assertFalse(comanda.getZiPlecare().isEmpty());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setZiPlecareCorect() {
		try {
			comanda.setZiPlecare("23/04/2016");
			assertEquals("ziua asteptata este: ", "23/04/2016", comanda.getZiPlecare());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
