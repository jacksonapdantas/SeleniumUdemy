package JunitBasicWeb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementState {
	
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.google.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}

	@Test
	public void test() {
		WebElement el = driver.findElement(By.name("q"));
		el.sendKeys("teste");
		el.sendKeys("teste 1");
		System.out.println("el is enable? " + el.isEnabled());
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}

}
