package tutorialselenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutocompleteDemo {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://www.goibibo.com/";

		//Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void testAutocomplete() throws Exception {
		String partialText = "del";
		String textToSelect = "New Delhi, India";
		
		WebElement txtClickField = driver.findElement(By.xpath("//div[@class='sc-gWXbKe gnEOYq']//div[contains(@class,'sc-ieecCq koynXZ fswFld')]"));
		txtClickField.click();

		WebElement textField = driver.findElement(By.xpath("//input[@type='text']"));
		textField.sendKeys(partialText);

		WebElement ulElement = driver.findElement(By.id("autoSuggest-list"));

		String innerHTML = ulElement.getAttribute("innerHTML");
		System.out.println(innerHTML);

		List<WebElement> ilElements = ulElement.findElements(By.tagName("li"));
		Thread.sleep(3000);

		for(WebElement element : ilElements){
			if(element.getText().contains(textToSelect)) {
				System.out.println("Selected: " + element.getText());
				element.click();
				break;
			}
		}

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
