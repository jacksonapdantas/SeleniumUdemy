package calendars;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarSelection {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://www.expedia.com.br/";

		//Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}

	@Test
	public void test1	() {
		driver.get(baseURL);

		//Click flights tab
		driver.findElement(By.xpath("//a[@class='uitk-tab-anchor']//span[text()='Voos']")).click();

		//Find departing field
		WebElement departingField = driver.findElement(By.id("d1-btn"));
		//click departing field
		departingField.click();

		//Find the date to be selected
		WebElement dateToSelect = driver.findElement(By.xpath("//div[1]/table[@class='uitk-date-picker-weeks']/tbody//button[@data-day = '1']"));
		//click to date
		dateToSelect.click();

		dateToSelect = driver.findElement(By.xpath("//div[1]/table[@class='uitk-date-picker-weeks']/tbody//button[@data-day = '8']"));
		dateToSelect.click();

		WebElement buttonApply = driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']"));
		buttonApply.click();		
	}

//	@Test
	public void test2() throws InterruptedException {
		driver.get(baseURL);

		driver.findElement(By.xpath("//span[text()='Voos']")).click();
		WebElement departingField = driver.findElement(By.id("d1-btn"));
		departingField.click();

		Thread.sleep(2000);
		//clicando duas vezes no botão do próximo mês, apenas para testar mudança de mês
		WebElement nextMonth = driver.findElement(By.xpath("//div[@class='uitk-calendar']//button[2]"));

		nextMonth.click();
		Thread.sleep(2000);
		nextMonth.click();

		Thread.sleep(2000);

		WebElement calMonthOne = driver.findElement(By.xpath("//div[1]/table[@class='uitk-date-picker-weeks']/tbody"));
		WebElement calMonthTwo = driver.findElement(By.xpath("//div[2]/table[@class='uitk-date-picker-weeks']/tbody"));


		List<WebElement> allValidDatesOne = calMonthOne.findElements(By.tagName("button"));
		List<WebElement> allValidDatesTwo = calMonthTwo.findElements(By.tagName("button"));


		//clicando em duas datas do mesmo mês
		//		for(WebElement date : allValidDatesOne) {
		//			if(date.getAttribute("data-day").equals("21") || date.getAttribute("data-day").equals("30")) {
		//				date.click();
		//			}
		//		}

		//clicando em uma data em cada mês

		//esse for clica na data do primeiro mês
		for(WebElement date : allValidDatesOne) {
			if(date.getAttribute("data-day").equals("28")) {
				date.click();
				break;
			}
		}

		//esse for clica na data do segundo mês
		for(WebElement date : allValidDatesTwo) {
			if(date.getAttribute("data-day").equals("5")) {
				date.click();
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
