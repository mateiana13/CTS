package testeJunit;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import clase.ComandaBuilder;
import clase.ModificaPret;
import clase.PretBilet;

@RunWith(EasyMockRunner.class)
public class TestMockObject {

	PretBilet bilet = new PretBilet("economy");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("inceput test mock");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("inceput test mock");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("inceput");
		comandaBuilder = new ComandaBuilder();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("sfarsit");
	}

	@TestSubject
	ComandaBuilder comandaBuilder = new ComandaBuilder();

	@Mock
	ModificaPret modificaPret;

	@Test
	public void testFaScumpire() {
		EasyMock.expect(modificaPret.faScumpire(1.15, bilet)).andReturn(229.99999999999997);

		EasyMock.replay(modificaPret);

		assertEquals(comandaBuilder.faScumpire(1.15, bilet), 229.99999999999997, 0.1);
	}

	@Test
	public void testFaIeftinire() {
		EasyMock.expect(modificaPret.faIeftinire(0.9, bilet)).andReturn(180.0);

		EasyMock.replay(modificaPret);

		assertEquals(comandaBuilder.faIeftinire(0.9, bilet), 180.0, 0.1);
	}

}
