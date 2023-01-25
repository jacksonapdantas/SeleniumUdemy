package waittypes;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWaitDemo {
	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://courses.letskodeit.com/practice";
		driver.manage().window().maximize();
		
		/**O Wait Implicity é configurado apenas uma vez e dura por toda vida útil do driver.
		 * Ele fará a espera pelos elementos até o tempo máximo estipulado
		 **/
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception{
		driver.get(baseURL);
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		
		driver.findElement(By.id("email")).sendKeys("teste");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
