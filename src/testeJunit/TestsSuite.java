package testeJunit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCaseFisierText.class, TestClasa.class, TestHashMapComenzi.class, TestIdAeronava.class,
		TestListaAeronave.class, TestMockObject.class, TestNumeClient.class, TestNumeCompanie.class,
		TestOraPlecare.class, TestOrasDestinatie.class, TestOrasPlecare.class, TestTipBilet.class,
		TestValoriVarstaDinComanda.class, TestZiPlecare.class })
public class TestsSuite {

}
