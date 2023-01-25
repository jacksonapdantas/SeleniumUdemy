package usefulmethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	WebDriver driver;
	
	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(String locator, String type) {
		type = type.toLowerCase();
		
		if(type.equals("id")) {
			System.out.println("Element found with ID: " + locator);
			return this.driver.findElement(By.id(locator));
		}else if(type.equals("xpath")) {
			System.out.println("Element found with Xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));
		}else {
			System.out.println("Locator not supported");
			return null;
		}
	}
	
	public List<WebElement> getElementList(String locator, String type) {
		type = type.toLowerCase();
		
		if(type.equals("id")) {
			System.out.println("Element found with ID: " + locator);
			return this.driver.findElements(By.id(locator));
		}else if(type.equals("xpath")) {
			System.out.println("Element found with Xpath: " + locator);
			return this.driver.findElements(By.xpath(locator));
		}else if(type.equals("css")) {
			System.out.println("Element found with Css: " + locator);
			return this.driver.findElements(By.cssSelector(locator));
		}else if(type.equals("linktext")) {
			System.out.println("Element found with Linktext: " + locator);
			return this.driver.findElements(By.linkText(locator));
		}else if(type.equals("partiallinktext")) {
			System.out.println("Element found with Partial Linktext: " + locator);
			return this.driver.findElements(By.partialLinkText(locator));
		}else {
			System.out.println("Locator not supported");
			return null;
		}
	}

	public boolean isElementPresent(String locator, String type) {
		List<WebElement> elementList = getElementList(locator, type);
		
		int size = elementList.size();
		
		if(size > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public WebElement waitForElement(By locator, int timout) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max: " + timout + " seconds for element to be available");

			WebDriverWait wait = new  WebDriverWait(driver, timout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeared on the web page");


		} catch (Exception e) {
			System.out.println("Element not appeared onn the web page");
		}

		return element;
	}

	public void clickWhenReady(By locator, int timout) {
		try {
			WebElement element = null;
			System.out.println("Waiting for max: " + timout + " seconds for element to be clickable");

			WebDriverWait wait = new  WebDriverWait(driver, timout);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the web page");
		} catch (Exception e) {
			System.out.println("Element not clicked onn the web page");
		}
	}
}
