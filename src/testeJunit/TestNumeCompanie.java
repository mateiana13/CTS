package testeJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Companie;

public class TestNumeCompanie {

	Companie companie;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput teste JUnit pentru numele companiei");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("sfarsit teste JUnit pentru numele companiei\n");
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

	// 10.
	@Test
	public void testNumeCompanieNull() {
		try {
			companie.setNume(null);
			assertNotNull(companie.getNume());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void testNumeCompanieEmptyString() {
		try {
			companie.setNume("");
			assertFalse(companie.getNume().isEmpty());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void testNumeCompanieNenul() {
		try {
			String nume = "companie1";
			companie.setNume(nume);
			assertEquals("numele companiei este: ", nume, companie.getNume());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
