package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.HomePage;
import ElementRepository.LoginPage;
import Utilities.ExcelRead;
import constant.Constant;

public class HomePageTestCases extends BaseClass {
	LoginPage lp;
	HomePage hp;
	ExcelRead er = new ExcelRead();

	@Test
	public void verifyWhetherManagePagesIsLoadedWhenMoreInfoClicked() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		hp =new HomePage(driver);
		hp.selectManagePagesMoreInfo();
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl=prop.getProperty("ManagePagesURL");
		Assert.assertEquals(actualUrl, expectedUrl,Constant.ERRORMESSAGE_MANAGEPAGES);

	}
	@Test
	public void verifyWhetherAdminUsersIsLoadedWhenMoreInfoClicked() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		hp =new HomePage(driver);
		hp.selectAdminUsersMoreInfo();
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl=prop.getProperty("AdminUsersPageURL");
		Assert.assertEquals(actualUrl, expectedUrl,Constant.ERRORMESSAGE_ADMINUSERSPAGE);
	}
	@Test
	public void verifyTheBackgroundColorOfManagePagesIcon() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		hp =new HomePage(driver);
		String actualResult=hp.getBackgrounColorOfManagePagesIcon();
		String expectedResult = prop.getProperty("ManagePagesIconBgColor");
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE_BGCOLOR_MANAGEPAGESBOX);
	}
	
}
