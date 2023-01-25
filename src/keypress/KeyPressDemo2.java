package keypress;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyPressDemo2 {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testKeyPress() throws InterruptedException {
		driver.get(baseURL);
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a");
		Thread.sleep(2000);

		//Forma mais limpa e fácil de entender que estamos apertando um grupo de teclas ao mesmo tempo
		//driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL, "a"));

		//Utilizando string para guardar o comando de apertar varias taclas
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		driver.findElement(By.id("openwindow")).sendKeys(selectAll);
	}


	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
