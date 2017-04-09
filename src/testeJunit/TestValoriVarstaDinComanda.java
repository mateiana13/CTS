package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Comanda;

public class TestValoriVarstaDinComanda {

	// fixture
	private Comanda comanda;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste pentru varsta client din Comanda");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste pentru varsta client din Comanda\n");
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

	// 2.
	@Test
	public void setVarstaValoriNormale() {
		try {
			comanda.setVarsta(50);
			assertEquals("varsta asteptata este: ", 50, comanda.getVarsta());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setVarstaEgalZero() {
		try {
			comanda.setVarsta(0);
			fail("setVarsta accepta 0");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setVarstaMaiMicaDecatZero() {
		try {
			comanda.setVarsta(-23);
			fail("setVarsta accepta valori negative");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setVarstaMaiMareCa90() {
		try {
			comanda.setVarsta(91);
			fail("setVarsta accepta valori mai mari decat 90");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
