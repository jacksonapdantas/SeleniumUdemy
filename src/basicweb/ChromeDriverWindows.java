package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverWindows {

	public static void main(String[] args) {
		//System.getProperty("webdriver.ie.driver", "C:\\Users\\jacks\\Documents\\Selenium\\Drivers\\chromedriver");
		WebDriver driver = new ChromeDriver();
		String baseURL = "https://pt-br.facebook.com/";
		driver.get(baseURL);

	}

}
