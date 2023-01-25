package basicweb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitIntroduction {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executado antes do primeiro método da classe");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executado depois do último método da classe");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Executado antes de cada teste");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Executado depois de cada teste");
	}

	@Test
	public void test1() {
		System.out.println("Executa o teste 1");
	}
	
	@Test
	public void teste2() {
		System.out.println("Executa o teste 1");
	}

}
