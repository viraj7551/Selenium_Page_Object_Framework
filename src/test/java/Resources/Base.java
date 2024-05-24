package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		String file = System.getProperty("user.dir")+"/src/test/java/Resources/data.properties";
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
	    prop.load(fis);
	    String browserName = prop.getProperty("browser");
	    if(browserName.equals("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    }else if(browserName.equals("firefox")) {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    }else if(browserName.equals("edge")) {
	    	WebDriverManager.edgedriver().setup();
	    	driver = new EdgeDriver();
	    }
	    else {
	    	System.out.println("no driver found");
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
}
