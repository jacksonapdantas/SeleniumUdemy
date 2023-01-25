package JunitBasicWeb;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateBetweenPages {
	
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		String tittle = driver.getTitle();
		System.out.println("Tittle of the page is: " + tittle);
		
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		//String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		//driver.navigate().to(urlToNavigate);
		
		Thread.sleep(1000);
		currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		System.out.println("Navigate back");
		currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		
		Thread.sleep(2000);
		
		driver.navigate().forward();
		System.out.println("Navigate forward");
		currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		
		Thread.sleep(2000);

		driver.navigate().back();
		System.out.println("Navigate back");
		currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentURL);
		
		driver.navigate().refresh();
		System.out.println("Navigate Refresh");
		driver.get(currentURL);
		
		//String pageSource = driver.getPageSource();
		//System.out.println(pageSource);

	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}



}
