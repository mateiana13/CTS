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

public class TestOrasPlecare {

	// fixture
	private Comanda comanda;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste pentru orasul de plecare ales de client din Comanda");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste pentru orasul de plecare ales de client din Comanda\n");
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

	// 3.
	@Test
	public void setOrasPlecareNull() {
		try {
			comanda.setOrasPlecare(null);
			assertNotNull(comanda.getOrasPlecare());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setOrasPlecareEmptyString() {
		try {
			comanda.setOrasPlecare("");
			assertFalse(comanda.getOrasPlecare().isEmpty());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setOrasPlecareCorect() {
		try {
			String orasPlecare = "londra";
			comanda.setOrasPlecare(orasPlecare);
			assertEquals("orasul asteptat este: ", orasPlecare, comanda.getOrasPlecare());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
