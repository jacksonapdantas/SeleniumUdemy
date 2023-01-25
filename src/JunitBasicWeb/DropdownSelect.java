package JunitBasicWeb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {
	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://courses.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}


	@Test
	public void test() throws InterruptedException {
		//guarda o elemento e coloca em um select
		WebElement element = driver.findElement(By.id("carselect"));
		Select sel = new Select(element);
		
		//seleciona a opção pelo value
		Thread.sleep(2000);
		System.out.println("Select Benz by value");
		sel.selectByValue("benz");
		
		//seleciona a opção pelo index
		Thread.sleep(2000);
		System.out.println("Select Honda by index");
		sel.selectByIndex(2);
		
		//Seleciona a opção pelo texto
		Thread.sleep(2000);
		System.out.println("Select BMW by visible text");
		sel.selectByVisibleText("BMW");
		
		//Printa todas a opções
		Thread.sleep(2000);
		System.out.println("Print List of all option");
		List<WebElement> options = sel.getOptions();
		int size = options.size();
		
		for(int i = 0 ; i < size ; i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
