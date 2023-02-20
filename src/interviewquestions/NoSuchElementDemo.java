package interviewquestions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NoSuchElementDemo {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://aprovatotal.com.br/login";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseURL);
		
		//Elemento não visivel, pois depende de ação em outro elemento
		//solução: fazer ação no elemento que deixa visivel o elemento que precisamos clicar
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("teste@hotmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='button']"));
		loginButton.click();

	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
