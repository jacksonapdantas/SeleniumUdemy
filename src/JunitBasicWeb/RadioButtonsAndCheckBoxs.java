package JunitBasicWeb;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonsAndCheckBoxs {
	
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
		
		
		
		//RadioButton
		WebElement bmwRadioBtn = driver.findElement(By.id("bmwradio"));
		System.out.println("BMW radio is selected? " + bmwRadioBtn.isSelected());
		bmwRadioBtn.click();
		
		Thread.sleep(2000);
		
		WebElement benzRadioBtn = driver.findElement(By.id("benzradio"));
		System.out.println("Benz radio is selected? " + benzRadioBtn.isSelected());
		benzRadioBtn.click();
		
		Thread.sleep(2000);
		
		WebElement hondaRadioBtn = driver.findElement(By.id("hondaradio"));
		System.out.println("Honda radio is selected? " + hondaRadioBtn.isSelected());
		hondaRadioBtn.click();
		
		Thread.sleep(2000);

		//CheckBox
		WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
		System.out.println("BMW Chekbox is selected? " + bmwCheckBox.isSelected());
		bmwCheckBox.click();
		
		Thread.sleep(2000);
		
		WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
		System.out.println("Benz Chekbox is selected? " + benzCheckBox.isSelected());
		benzCheckBox.click();
		
		Thread.sleep(2000);
		
		WebElement hondaCheckBox = driver.findElement(By.id("hondacheck"));
		System.out.println("Honda Chekbox is selected? " + hondaCheckBox.isSelected());
		hondaCheckBox.click();
		
		System.out.println("Depois de clickados");
		
		System.out.println("BMW radio is selected? " + bmwRadioBtn.isSelected());
		System.out.println("Benz radio is selected? " + benzRadioBtn.isSelected());
		System.out.println("Honda radio is selected? " + hondaRadioBtn.isSelected());
		
		System.out.println("BMW Chekbox is selected? " + bmwCheckBox.isSelected());
		System.out.println("Benz Chekbox is selected? " + benzCheckBox.isSelected());
		System.out.println("Honda Chekbox is selected? " + hondaCheckBox.isSelected());


				
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}



}
