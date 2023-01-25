package browserprofiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class ProfilesDemo {

	public static void main(String[] args) throws InterruptedException {
		String baseURL = "https://letskodeit.com";
		WebDriver driver;
		
		//Acessando profile
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("automationprofile");
		FirefoxOptions fxOptions = new FirefoxOptions();
		fxOptions.setProfile(fxProfile);
		
		driver = new FirefoxDriver(fxOptions);
		driver.manage().window().maximize();
		driver.get(baseURL);
		
	}

}
