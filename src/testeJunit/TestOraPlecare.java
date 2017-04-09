package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Comanda;

public class TestOraPlecare {

	// fixture
	private Comanda comanda;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste pentru ora plecare aleasa de client din Comanda");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste pentru ora plecare aleasa de client din Comanda\n");
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

	// 6.
	@Test
	public void setOraPlecareMaiMicDecatZero() {
		try {
			comanda.setOraPlecare(-2);
			fail("setOraPlecare accepta valori negative");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setOraPlecareMaiMareDecat24() {
		try {
			comanda.setOraPlecare(30);
			fail("setOraPlecare accepta valori mai mari decat 24, deci gresite");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setOraPlecareCorecta() {
		try {
			comanda.setOraPlecare(13);
			assertEquals("ora de plecare asteptata este: ", 13, comanda.getOraPlecare());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
