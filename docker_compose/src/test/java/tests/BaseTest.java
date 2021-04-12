package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeTest
	public void setupDriver() throws MalformedURLException{
		//NEED BROWSER==>chrome/firefox
		//HUB_HOST(grid) IP,NAME
		
		String host="localhost"; //bydefault grid is on localhost we assume, else add ip
		DesiredCapabilities dc;
		
		if (System.getProperty("BROWSER")!=null &&
				System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc=DesiredCapabilities.firefox();
			
		}else{
			dc=DesiredCapabilities.chrome();
		}
		if (System.getProperty("HUB_HOST")!=null) {
			host=System.getProperty("HUB_HOST");
			
		}
		String completeUrl="http://"+host+":4444/wd/hub";
		this.driver=new RemoteWebDriver(new URL(completeUrl),dc);
		System.out.println("URL is " +completeUrl);
		System.out.println("Driver value " +driver);
		
		
		/*WebDriverManager.chromedriver().setup();
		this.driver=new ChromeDriver();*/
	}
	

	@AfterTest
	public void quitDriver(){
		this.driver.quit();
	}
	
	
	
	

}
