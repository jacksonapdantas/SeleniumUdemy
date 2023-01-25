package tutorialselenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static WebElement element = null, element2 = null;
	public static List<WebElement> listElements = null;

	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return element
	 */
	public static WebElement originTextBox(WebDriver driver) {
		driver.findElement(By.xpath("//button[@aria-label='Saindo de']")).click();
		element = driver.findElement(By.id("location-field-leg1-origin"));
		return element;
	}

	/**
	 * SendKeys the flight origin text box element
	 * @param driver, origin
	 */
	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
		element.sendKeys(origin);
	}


	/**
	 * Returns the flight destination text box element
	 * @param driver
	 * @return element
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		driver.findElement(By.xpath("//button[@aria-label='Indo para']")).click();
		element = driver.findElement(By.id("location-field-leg1-destination"));
		return element;
	}

	/**
	 * Sendkeys the flight destination text box element
	 * @param driver, destination
	 */
	public static void fillDestinationTextBox(WebDriver driver, String destination) {
		element = destinationTextBox(driver);
		element.sendKeys(destination);
	}

	/**
	 * Returns departure date text box element
	 * @param driver
	 * @return element
	 */
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("d1-btn"));
		return element;
	}
	
	public static void chooseDepartureDate(WebDriver driver, String day, String month) {
		
		WebElement departingField = departureDateTextBox(driver);
		departingField.click();
	
		WebElement monthCurrent = null;
		WebElement nextMonth = driver.findElement(By.xpath("//div[1]/button[@class=\"uitk-button uitk-button-small uitk-flex-item uitk-button-paging\"][2]"));

		for(int i = 1 ; i < 3 ; i++) {
			monthCurrent = driver.findElement(By.xpath("//div["+ i + "]/h2[@class='uitk-new-date-picker-month-name uitk-type-medium']"));
			if(monthCurrent.getText().contains(month)) {
				WebElement calMonth = driver.findElement(By.xpath("//div[" + i + "]/table[@class=\"uitk-new-date-picker-weeks\"]/tbody"));
				
				List<WebElement> allValidDates = calMonth.findElements(By.tagName("button"));
			
					for(WebElement date : allValidDates) {
						if(date.getAttribute("data-day").equals(day)) {
							date.click();
							break;
						}
					}
				
				break;
			}else if(i == 2) {
				nextMonth.click();
				i = 1;
			}
		}
				
	}


	/**
	 * Returns return date text box element
	 * @param driver
	 * @return element
	 */
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning"));
		return element;
	}
	
	public static void chooseReturnDate(WebDriver driver, String day, String month) {
		WebElement monthCurrent = null;
		WebElement nextMonth = driver.findElement(By.xpath("//div[1]/button[@class=\"uitk-button uitk-button-small uitk-flex-item uitk-button-paging\"][2]"));

		for(int i = 1 ; i < 3 ; i++) {
			monthCurrent = driver.findElement(By.xpath("//div["+ i + "]/h2[@class='uitk-new-date-picker-month-name uitk-type-medium']"));
			if(monthCurrent.getText().contains(month)) {
				WebElement calMonth = driver.findElement(By.xpath("//div[" + i + "]/table[@class=\"uitk-new-date-picker-weeks\"]/tbody"));
				
				List<WebElement> allValidDates = calMonth.findElements(By.tagName("button"));
			
					for(WebElement date : allValidDates) {
						if(date.getAttribute("data-day").equals(day)) {
							date.click();
							break;
						}
					}
				
				break;
			}else if(i == 2) {
				nextMonth.click();
				i = 1;
			}
		}
		element = driver.findElement(By.xpath("//div[@class='uitk-flex uitk-new-date-picker-menu-footer']//button[@type='button']/span"));
		element.click();
	}

	/**
	 * Returns the search button box element
	 * @param driver
	 * @return element
	 */
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()='Buscar']"));
		return element;
	}

	/**
	 * Click on search button
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}

	/**
	 * Navigate to flight lab
	 * @param driver
	 */
	public static void navigateToFlightsTab(WebDriver driver){
		element = driver.findElement(By.xpath("//span[contains(text(),'Voos')]"));
		element.click();
	}

	/**
	 *  list of the aeroports origin
	 * @param driver
	 * @return listElements 
	 */
	public static List<WebElement> listAeroportOrigin(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='location-field-leg1-origin-menu']//ul"));
		listElements = element.findElements(By.tagName("li"));
		return listElements;
	}

	/**
	 * Choose the aeoroport origin
	 * @param driver, aeroport
	 */

	public static void chooseAeroportOrigin(WebDriver driver, String aeroport) {
		for(WebElement elementLi : listAeroportOrigin(driver)) {
			if(elementLi.getText().contains(aeroport)) {
				elementLi.click();
				break;
			}
		}
	}


	/**
	 *  list of the aeroports destination
	 * @param driver
	 * @return listElements 
	 */
	public static List<WebElement> listAeroportDestination(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='location-field-leg1-destination-menu']//ul"));
		listElements = element.findElements(By.tagName("li"));
		return listElements;
	}

	/**
	 * Choose the aeoroport destination
	 * @param driver, aeroport
	 */

	public static void chooseAeroportDestination(WebDriver driver, String aeroport) {
		for(WebElement elementLi : listAeroportDestination(driver)) {
			if(elementLi.getText().contains(aeroport)) {
				elementLi.click();
				break;
			}
		}
	}
}
