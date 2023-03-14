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

	@Test(groups = { "regression" },priority = 1)
	public void verifyWhetherManagePagesIsLoadedWhenMoreInfoClicked() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		hp = new HomePage(driver);
		hp.selectManagePagesMoreInfo();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("ManagePagesURL");
		Assert.assertEquals(actualUrl, expectedUrl, Constant.ERRORMESSAGE_MANAGEPAGES);

	}

	@Test(groups = { "regression" },priority = 2)
	public void verifyWhetherAdminUsersIsLoadedWhenMoreInfoClicked() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		hp = new HomePage(driver);
		hp.selectAdminUsersMoreInfo();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("AdminUsersPageURL");
		Assert.assertEquals(actualUrl, expectedUrl, Constant.ERRORMESSAGE_ADMINUSERSPAGE);
	}

	@Test(groups = { "regression"},priority = 3)
	public void verifyTheBackgroundColorOfManagePagesIcon() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		hp = new HomePage(driver);
		String actualResult = hp.getBackgrounColorOfManagePagesIcon();
		String expectedResult = prop.getProperty("ManagePagesIconBgColor");
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE_BGCOLOR_MANAGEPAGESBOX);
	}

}
