package basicweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdxXPATHDemo {

	public static void main(String[] args) {
		
		String baseUrl ="https://learn.letskodeit.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jacks\\Documents\\Selenium\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		driver.findElement(By.id("user_email")).sendKeys("letskodeit@gmail.com");
	}

}
