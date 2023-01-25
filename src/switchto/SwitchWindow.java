package switchto;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchWindow {
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
//		WebElement openWindow = driver.findElement(By.id("openwindow"));
//		openWindow.click();
//		
//		WebElement searchBox = driver.findElement(By.id("search-courses"));
//		searchBox.sendKeys("python");
		
		//Get the handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle: " + parentHandle);
		
		//Find the Window button
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		
		//Find all handles
		Set<String> handles = driver.getWindowHandles();
		
		//Switching between handles
		for(String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();

				Thread.sleep(2000);
				WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
				searchBox.sendKeys("python");
				Thread.sleep(2000);
				driver.close();
				break;
			}
		}
		
		//Switch back to the parent window
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("Teste Sucessful");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
