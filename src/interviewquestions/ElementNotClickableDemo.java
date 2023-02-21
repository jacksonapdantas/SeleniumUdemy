package interviewquestions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementNotClickableDemo {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://courses.letskodeit.com/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		
		//1. Time Issues
		//Falha porque não acha o elemento que não foi reenderizado
		//solução: inserir comando de espera implicito(até 3 segundos) ou e explicito (acima de 3 segundos)
		
		 driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//WebElement emailField = driver.findElement(By.id("user_email"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement emailField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		emailField.sendKeys("teste@teste.com");
		
		//2. Incorrect locator or type locator
		//Falha ao inserir um elemento que não existe
		//solução: inserir o localizador com elemento correto
		
		//driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

		
		
		//3. Element in IFrame
		//Falha porque o elemento está em outro frame
		//solução: Mudar para o frame que está o elemento
		
		driver.get("https://courses.letskodeit.com/practice");
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Java");
		driver.switchTo().defaultContent();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
