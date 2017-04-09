package testeJunit;

import static org.junit.Assert.assertEquals;

//import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.AeronavaPasageri;
import clase.Companie;
//import clase.InterfataAbstractaAeronava;

public class TestListaAeronave {

	Companie companie;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste JUnit pentru lista de aeronave");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste JUnit pentru lista de aeronave\n");
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

	// 11.
	@Test
	public void testAdaugaAeronavaInLista() {
		// ArrayList<InterfataAbstractaAeronava> lista = Companie.listaAeronave;
		AeronavaPasageri aeronavaPasageri = new AeronavaPasageri();
		Companie.adaugaAeronava(aeronavaPasageri);
		assertEquals("test adaugare aeronava in lista: ", 1, companie.getNumarAeronave2());
	}

	@Test
	public void testStergeAeronavaDinLista() {
		// ArrayList<InterfataAbstractaAeronava> lista = Companie.listaAeronave;
		AeronavaPasageri aeronavaPasageri = new AeronavaPasageri();
		Companie.stergeAeronava(aeronavaPasageri);
		assertEquals("test sterge aeronava din lista: ", 1, companie.getNumarAeronave2());
	}
}
