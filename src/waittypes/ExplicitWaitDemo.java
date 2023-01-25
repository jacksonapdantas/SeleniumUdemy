package waittypes;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://courses.letskodeit.com/practice";
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws Exception{
		driver.get(baseURL);
		WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
		loginLink.click();
		
		/**O Wait Explicit é setado no próprio elemento
		 * Usasse o until que possui várias condições de espera
		 */
		WebDriverWait wait = new  WebDriverWait(driver, 3);
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		emailField.sendKeys("Teste");

		//driver.findElement(By.id("user_email")).sendKeys("teste");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
