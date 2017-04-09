package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.AeronavaCargo;
import clase.AeronavaFactory;
import clase.AeronavaPasageri;
import clase.TipAeronava;

public class TestIdAeronava {

	AeronavaFactory factory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste JUnit pentru setarea idAeronava");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste JUnit pentru setarea idAeronava\n");
	}

	@Before
	public void setUp() throws Exception {
		factory = new AeronavaFactory();
		System.out.println("inceput test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("sfarsit test");
	}

	// 9.
	@Test
	public void testSetIdAeronavaNull() {
		AeronavaPasageri aeronavaPasageri;
		AeronavaCargo aeronavaCargo;
		try {
			aeronavaPasageri = (AeronavaPasageri) factory.createAeronava(TipAeronava.PASAGERI, null);
			assertNotNull(aeronavaPasageri.getIdAeronava());
			aeronavaCargo = (AeronavaCargo) factory.createAeronava(TipAeronava.CARGO, null);
			assertNotNull(aeronavaCargo.getIdAeronava());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void testSetIdAeronavaEmptyString() {
		AeronavaPasageri aeronavaPasageri;
		AeronavaCargo aeronavaCargo;
		try {
			aeronavaPasageri = (AeronavaPasageri) factory.createAeronava(TipAeronava.PASAGERI, "");
			assertFalse(aeronavaPasageri.getIdAeronava().isEmpty());
			aeronavaCargo = (AeronavaCargo) factory.createAeronava(TipAeronava.CARGO, "");
			assertFalse(aeronavaCargo.getIdAeronava().isEmpty());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void testSetIdAeronavaCorect() {
		AeronavaPasageri aeronavaPasageri;
		AeronavaCargo aeronavaCargo;
		try {
			String myId = "23xdf";
			aeronavaPasageri = (AeronavaPasageri) factory.createAeronava(TipAeronava.PASAGERI, myId);
			assertEquals("id-ul asteptat este: ", myId, aeronavaPasageri.getIdAeronava());
			aeronavaCargo = (AeronavaCargo) factory.createAeronava(TipAeronava.CARGO, myId);
			assertEquals("id-ul asteptat este: ", myId, aeronavaCargo.getIdAeronava());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
