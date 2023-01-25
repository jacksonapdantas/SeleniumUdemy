package waittypes;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.WaitTypes;

public class ExplicitWaitUtilitiesDemo {
	private WebDriver driver;
	private String baseURL;
	WaitTypes wt;


	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://courses.letskodeit.com/practice";
		wt = new WaitTypes(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws Exception{
		driver.get(baseURL);
		WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
		loginLink.click();

		WebElement emailField = wt.waitForElement(By.id("email"), 3);

		emailField.sendKeys("Teste");

		wt.clickWhenReady(By.xpath("//input[@type='submit']"), 3);
		//driver.findElement(By.id("user_email")).sendKeys("teste");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
