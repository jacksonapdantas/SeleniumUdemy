package interviewquestions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementNotInteractableExceptionDemo {
	private WebDriver driver;
	private String baseURL, baseURL2;
	
	@Before
	public void setup() throws Exception{
		driver = new FirefoxDriver();
		baseURL = "https://courses.letskodeit.com/login";
		baseURL2 = "https://www.expedia.com.br/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void teste() throws InterruptedException{
		//aqui vai dar errado teste pois é um exemplo de envio de sendkeys em elementos que não aceita input de informação
		driver.get(baseURL);
		driver.findElement(By.xpath("//form[@name='loginform']")).click();
		driver.findElement(By.xpath("//form[@name='loginform']")).sendKeys("abc");
	}
	

	@Test
	public void teste2() throws InterruptedException{
		driver.get(baseURL2);
		driver.findElement(By.xpath("//a[@aria-controls=\'wizard-flight-pwa']")).click();
		// não cosnegue clicar pois nesse caso o elemento é oculto e não pode interagir
		// necessário clicar no campo para habilitar o elemento que pode ser interagir
		driver.findElement(By.id("//div[@id='location-field-leg1-origin-menu']//div[@class='uitk-menu-trigger']//div//div[@class='uitk-field has-floatedLabel-label has-icon']//input[@type='text']"))
			.sendKeys("SF0");
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
