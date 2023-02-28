package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
	

	@BeforeMethod
	public void beforeMethod() throws IOException {
		testBasic();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000)); // implicit wait
		driver.get(prop.getProperty("BaseURL"));
		
	}

	@AfterMethod
	public void afterMethod(ITestResult itestResult) throws IOException {
		
		if(itestResult.getStatus()==ITestResult.FAILURE) {
			scr= new ScreenshotUtility();
			scr.captureFailureScreenShot(driver, itestResult.getName());
		}
		
		driver.close();
	}
}
