package javascriptexecution;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptClick {
	private WebDriver driver;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
//	public void testJSClick() throws InterruptedException {
//		driver.get("https://letskodeit.teachable.com/p/practice");
//		Thread.sleep(3000);
//		
//		WebElement checkBoxElement = driver.findElement(By.id("bmwcheck"));
//		js.executeScript("arguments[0].click();", checkBoxElement);
//	}
	
	public void testJSClick2() throws InterruptedException {
		driver.get("https://www.retailmenot.com/");
		driver.findElement(By.xpath("//div[text() = 'Log in / Sign up'")).click();
		Thread.sleep(3000);
		
		WebElement checkBoxElement = driver.findElement(By.id("subscribe"));
		System.out.println("Displayed: " + checkBoxElement.isDisplayed());
		System.out.println("Selected: " + checkBoxElement.isSelected());
		
		//Como o elemento está sobreposto, o selenium não consegue interagir com o mesmo
		// Por isso é necessário utilizar o javascript para clicar no elemento
		//checkBoxElement.click();
		
		js.executeScript("arguments[0].click();", checkBoxElement);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
