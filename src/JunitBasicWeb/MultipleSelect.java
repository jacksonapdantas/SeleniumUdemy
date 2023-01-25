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

public class MultipleSelect {
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
		//coloca o elemento com a oppão dentro do Select
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(element);
		
		//Seleciona opção pelo valor
		Thread.sleep(2000);
		System.out.println("Select orange by value");
		sel.selectByValue("orange");
		
		//Tira seleção pelo valor
		Thread.sleep(2000);
		System.out.println("De-selected orange by value");
		sel.deselectByValue("orange");
		
		//seleciona opção pelo index
		Thread.sleep(2000);
		System.out.println("Selecte peach by index");
		sel.selectByIndex(2);	
		
		//Tira a seleção pelo texto
		Thread.sleep(2000);
		System.out.println("Selecte apple by visible text");
		sel.deselectByVisibleText("Apple");
		
		//Printa todas as opções selecio
		Thread.sleep(2000);
		System.out.println("Print all selected options");
		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
		
		for(WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}
		
		//Tira todas seleções
		Thread.sleep(2000);
		System.out.println("De-Selected all selected option");
		sel.deselectAll();
		
	}


	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}


}
