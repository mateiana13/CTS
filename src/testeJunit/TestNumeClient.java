package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Comanda;

public class TestNumeClient {

	// fixture
	private Comanda comanda;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste nume client din clasa Comanda");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste nume client din clasa Comanda\n");
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

	// 1.
	@Test
	public void testSetNumeDinComanda() {
		Comanda comanda = new Comanda();
		try {
			String numeClient = "angela";
			comanda.setNume(numeClient);
			assertEquals("numele asteptat este: ", numeClient, comanda.getNume());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void testSetNumeNullDinComanda() {
		try {
			comanda.setNume(null);
			fail("setNume accepta null");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void testSetNumeMaiMicDeDouaCaractere() {
		try {
			comanda.setNume("k");
			fail("setNume accepta mai putin de 2 caractere");
		} catch (Exception e) {
			// e.printStackTrace();
		}

		try {
			comanda.setNume("");
			fail("setNume accepta EmptyString");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
