package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Comanda;
import clase.Companie;

public class TestHashMapComenzi {

	Companie companie;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste JUnit pentru hashmap comenzi");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste JUnit pentru hashmap comenzi\n");
	}

	@Before
	public void setUp() throws Exception {
		companie = Companie.getInstance();
		System.out.println("@Before - setUp pentru Companie");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After - tearDown pentru Companie");
	}

	// 12.
	@Test
	public void testHashMapComenziGoala() {
		HashMap<String, Comanda> map = new HashMap<>();
		assertTrue(map.isEmpty());
	}

	@Test
	public void testAdaugaComandaInHashMap() {
		HashMap<String, Comanda> map = new HashMap<>();
		map.put("nume1", new Comanda());
		map.put("nume2", new Comanda());
		assertEquals("test adauga comanda in HashMap: ", 2, map.size());
	}

	@Test
	public void testStergeComandaDinHashMap() {
		HashMap<String, Comanda> map = new HashMap<>();
		map.put("nume1", new Comanda());
		map.put("nume2", new Comanda());
		map.remove("nume1");
		assertEquals("test sterge comanda din HashMap: ", 1, map.size());
		map.remove("nume2");
		assertEquals("test sterge comanda din HashMap: ", 0, map.size());
	}

	@Test
	public void testDimensiuneHashMap() {
		// HashMap<String, Comanda> map = new HashMap<>();
		companie.adaugaComanda("nume1", new Comanda());
		companie.adaugaComanda("nume2", new Comanda());
		assertEquals("test lungime tabela comenzi: ", 2, companie.getNumarComenzi2());
	}

}
