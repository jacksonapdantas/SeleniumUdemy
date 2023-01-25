package browserprofiles;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeExtension {

	public static void main(String[] args) {
//			System.getProperty("webdriver.ie.driver", "C:\\Users\\jacks\\Documents\\Selenium\\Drivers\\chromedriver");
		
//		Abrir extensões do google
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\jacks\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ljngjbnaijcbncmcnjfhigebomdlkcjo\\6.1.12_0.crx"));
		
			WebDriver driver = new ChromeDriver(options);
			String baseURL = "https://www.google.com/";
			driver.get(baseURL);
	}

}
