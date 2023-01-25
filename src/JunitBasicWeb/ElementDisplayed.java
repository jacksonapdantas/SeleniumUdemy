
package JunitBasicWeb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementDisplayed {
	WebDriver driver;
	String baseURL, baseURL2;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://courses.letskodeit.com/practice";
		baseURL2 = "https://www.expedia.com.br";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testLetsKodeIt() throws InterruptedException {
		driver.get(baseURL);
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());
		
		Thread.sleep(2000);
		
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Clicked in hide button");
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());
		
		Thread.sleep(2000);
		
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Clicked in show button");
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());
	}
	
//	@Test
//	public void testExpedia() {
//		driver.get(baseURL2);
//		WebElement viajantesButton = driver.findElement(By.xpath("//button[@aria-label='1 quarto, 2 viajantes']"));
//		viajantesButton.click();
//		
//		//Aqui temos um erro de elemento não encontrado, porque o elemento oculto está em outra div
//		WebElement childDropdown = driver.findElement(By.xpath("child-age-input-0-0"));
//		System.out.println("Child Dropdown Displayed: " + childDropdown.isDisplayed());
//	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}


}
