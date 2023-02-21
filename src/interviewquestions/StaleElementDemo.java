package interviewquestions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaleElementDemo {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://courses.letskodeit.com/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseURL);
		
		//erro elemento obsoleto... abaixo acontece porque a página é recarregada antes da ação e o toda página foi reconstruida
		WebElement checkBoxElement = driver.findElement(By.id("bmwcheck"));
		driver.get(driver.getCurrentUrl());
		checkBoxElement.click();
		

	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
