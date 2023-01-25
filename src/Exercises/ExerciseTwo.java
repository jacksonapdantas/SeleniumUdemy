package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerciseTwo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		String baseURL = "http://dhtmlx.com/docs/product/dhtmlxGrid/";
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		//driver.findElement(By.xpath("//div[@class=\"dhx_cell-content\" and contains(text(),'CRM')]")).click();
		//driver.findElement(By.xpath("//div[@class='dhx_grid-header-cell dhx_grid-custom-content-cell dhx_string-cell  dhx_cell-empty ']")).click();
		WebElement selectElement = driver.findElement(By.xpath("//select[@class='dxi dxi-menu-down dhx_input dhx_grid-filter dhx_grid-filter--select']//option[contains(@value,'Booking')]//.."));
		final Select combobox = new Select(selectElement);
		combobox.selectByVisibleText("Booking");
		
		selectElement = driver.findElement(By.xpath("//select[@class='dxi dxi-menu-down dhx_input dhx_grid-filter dhx_grid-filter--select']//option[contains(@value,'Not Started')]//.."));
		final Select combobox2 = new Select(selectElement);
		combobox2.selectByVisibleText("Not Started");
		
		
		
	}

}
