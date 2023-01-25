package switchto;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchFrame {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://courses.letskodeit.com/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		
		//Muda para o iframe 
		//Mudar iframe através do ID
		//driver.switchTo().frame("courses-iframe");
		
		//Mudar iframe através do Name
		//driver.switchTo().frame("iframe-name");
		
		//Mudar iframe através do número
		driver.switchTo().frame(0);
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
		searchBox.sendKeys("python");
		
		//Retorna para o frame principal
		driver.switchTo().defaultContent();
		Thread.sleep(6000);
		driver.findElement(By.id("name")).sendKeys("Test Successful");
	
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
