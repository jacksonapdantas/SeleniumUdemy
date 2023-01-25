package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class IEDriverWindows {

	public static void main(String[] args) {
		//System.getProperty("webdriver.ie.driver", "C:\\Users\\jacks\\Documents\\Selenium\\Drivers\\IEDriverServer");
		WebDriver driver = new InternetExplorerDriver();
		String baseURL = "https://pt-br.facebook.com/";
		driver.get(baseURL);

	}

}
