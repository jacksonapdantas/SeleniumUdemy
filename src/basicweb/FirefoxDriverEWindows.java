package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverEWindows {

	public static void main(String[] args) {
		//System.getProperty("webdriver.ie.driver", "C:\\Users\\jacks\\Documents\\Selenium\\Drivers\\geckodriver");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://pt-br.facebook.com/";
		driver.get(baseURL);

	}

}
