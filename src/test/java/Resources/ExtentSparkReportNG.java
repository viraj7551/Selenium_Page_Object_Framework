package Resources;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentSparkReportNG {
	public WebDriver driver;
	public static ExtentSparkReporter reporter;
	public static ExtentReports getReportObject() {
		String file = System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		reporter.config().setDocumentTitle("Test Automation Report");
		reporter.config().setReportName("Demo Blaze UI Automation Report");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Software Test Engineer","Viraj D. Utekar");
		return extent;
	}
}
