package TestCases;

import org.testng.annotations.Test;


import ElementRepository.LoginPage;
import Utilities.ExcelRead;
import constant.Constant;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTestCases  extends BaseClass   {
	LoginPage lp;
	ExcelRead er;
	public LoginPageTestCases() throws IOException {
	 er= new ExcelRead();
	}
	@Test
	public void verifyTheTextOfSignInButton() throws IOException {
		lp = new LoginPage(driver);
		String actualResult = lp.getTextOfSignInButton();
		er=new ExcelRead();
		String expectedResult = er.readdata(7,1);
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGELOGINBUTON);
	}
	
	@Test

	public void verifyWhetherTheCheckBoxElementIsSelected() {
		lp = new LoginPage(driver);
		lp.selectRememberMeCheckBox();
		boolean actualResult = lp.checkRememberMeCheckBoxIsSelected();
		Assert.assertTrue(actualResult, Constant.ERRORMESSAGE_REMEMBERME_CHECKBOX );
	}
	@Test
	public void verifyTheBackGroundColorOfSignInButton() {
		lp = new LoginPage(driver);
		String actualResult=lp.getBackroundColorOfSignInButton();
		String expectedResult =er.readdata(8,1);
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE_BACKGROUNDCOLOR);
	
	}
	@Test
	public void verifyLoginWithValidCredentials() throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl=prop.getProperty("HomePageURL");
		Assert.assertEquals(actualUrl, expectedUrl,Constant.ERRORMESSAGE_LOGIN);
	}
	
	@Test
	public void verifyLoginwithInvalidCredentails() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(4,1),er.readdata(5,1));
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl=prop.getProperty("LoginPageURL");
		Assert.assertEquals(actualUrl, expectedUrl,Constant.ERRORMESSAGE_INVALIDLOGIN);
	}
	
	@Test
	public void verifyTheAlertMessageForLoginError() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(4,1),er.readdata(5,1));
		String actualResult=lp.getTextofAlertMessageWhileLogin();
		actualResult = actualResult.replaceAll("[^a-zA-Z0-9]", " ");
		String expectedResult=Constant.ALERTMESSAGE_TEXT;
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE_ALERT);

	}
	
	
	@Test
	public void verifyWhetherPasswordFieldIsMasked() {
		lp = new LoginPage(driver);
		String actualResult =lp.getAttributeValueTypeForPassword();
		String expectedResult =prop.getProperty("PasswordFieldType");
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE_PASSWORDMASKED);
	}
	
	
}
