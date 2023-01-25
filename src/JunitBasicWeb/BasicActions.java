package JunitBasicWeb;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicActions {

	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		//utilizamos o @before para configurar webdriver e janela inicial//
		
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseURL);
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement(By.id("email")).sendKeys("teste@teste.com");
		driver.findElement(By.id("password")).sendKeys("123456");
	}
	
	@After
	public void tearDown() throws Exception {
	}

	

}
