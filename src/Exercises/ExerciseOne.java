package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExerciseOne {

	public static void main(String[] args) {
		
		//não precisou setar o caminho do driver porque foi criado uma variavel de ambiente que faz isso
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://learn.letskodeit.com";
		driver.get(baseURL);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.xpath("//div[@class='collapse navbar-collapse navbar-header-collapse']//a[contains(text(),'Practice')]")).click();
		String preco;
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='product']")));
		preco = driver.findElement(By.xpath("//table[@id='product']//td[starts-with(text(),'Python')]//following-sibling::td")).getText();
		System.out.println(preco);
		
	}

}
