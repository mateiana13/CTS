package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Comanda;
import clase.TipBilet;

public class TestTipBilet {

	// fixture
	private Comanda comanda;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste pentru tipul de bilet ales de client din Comanda");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste pentru tipul de bilet ales de client din Comanda\n");
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

	// 7.
	@Test
	public void setTipBiletNull() {
		try {
			comanda.setTipBilet(null);
			assertNotNull(comanda.getTipBilet());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void setTipBiletCorect() {
		try {
			comanda.setTipBilet(TipBilet.BEBELUS);
			assertEquals("tipul de bilet asteptat este: ", TipBilet.BEBELUS, comanda.getTipBilet());
			comanda.setTipBilet(TipBilet.COPIL);
			assertEquals("tipul de bilet asteptat este: ", TipBilet.COPIL, comanda.getTipBilet());
			comanda.setTipBilet(TipBilet.ADULT);
			assertEquals("tipul de bilet asteptat este: ", TipBilet.ADULT, comanda.getTipBilet());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
