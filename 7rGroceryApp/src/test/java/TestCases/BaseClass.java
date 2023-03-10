package TestCases;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ScreenshotUtility;


public class BaseClass {
	WebDriver driver;
	public static Properties prop;
	ScreenshotUtility scr;
	
	public static void testBasic() throws IOException {
		prop=new Properties();
		FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Properties\\Config.properties");
		prop.load(ip);
	}
	

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browserValue) throws IOException {
		testBasic();
		if(browserValue.equals(prop.getProperty("Browser1"))) {
			driver = new ChromeDriver();	
		}
		else if(browserValue.equals(prop.getProperty("Browser2"))) {
			driver = new EdgeDriver();
		}
		else if(browserValue.equals(prop.getProperty("Browser3"))) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000)); // implicit wait
		driver.manage().window().maximize();
		driver.get(prop.getProperty("BaseURL"));
	}
	 
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {
		
		if(itestResult.getStatus()==ITestResult.FAILURE) {
			scr= new ScreenshotUtility();
			scr.captureFailureScreenShot(driver, itestResult.getName());
		}
		driver.close();
	}
}
