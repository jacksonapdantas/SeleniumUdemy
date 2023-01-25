package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

	WebDriver driver;

	public WaitTypes(WebDriver driver) {
		this.driver = driver;
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
