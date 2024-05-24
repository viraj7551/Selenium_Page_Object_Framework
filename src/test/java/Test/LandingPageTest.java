package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;

public class LandingPageTest extends Base{
	public static Logger log = LogManager.getLogger(Base.class.getName());
			
	public WebDriver driver;
	@BeforeTest
	public void navigateToUrl() throws IOException {
		driver = initializeDriver();
		log.info("driver is been initialized");
		driver.get(prop.getProperty("url"));
		log.info("site url is been navigated");
		driver.manage().deleteAllCookies();
		log.info("browser all cookies is been deleted");
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
	}
	
	@Test
	public void validateCurrentUrl() {
		String current_url = driver.getCurrentUrl();
		Assert.assertEquals(current_url,"https://www.demoblaze.com/");
		log.info("current url is"+current_url);
	}
	
	@AfterTest
	public void terminate() {
		driver.close();
		log.info("current browser window is been closed");
	}
}
