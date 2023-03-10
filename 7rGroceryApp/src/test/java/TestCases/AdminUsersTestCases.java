package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProvider.DataProviderClass;
import ElementRepository.AdminUsersPage;
import ElementRepository.LoginPage;
import Utilities.RandomUtility;
import Utilities.RetryUtils;
import constant.Constant;

public class AdminUsersTestCases extends BaseClass {
	LoginPage lp;
	AdminUsersPage au;
	RandomUtility ru = new RandomUtility();

	@Test(dataProvider = "create_data", dataProviderClass = DataProviderClass.class, groups = { "sanity", "regression" }, priority = 1, retryAnalyzer = RetryUtils.class)
	public void verifyUsersAreAdded(String username, String type) {

		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		au = new AdminUsersPage(driver);
		au.selectAdminUsersPage();
		au.addNewUsers(username, ru.randomPassword(), type);
		boolean actual = au.verifyUserIsPresent(username);
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_USERSNOTADDED);

	}

	@Test(dataProvider = "create_data", dataProviderClass = DataProviderClass.class, groups = { "regression" },priority = 2, retryAnalyzer = RetryUtils.class)
	public void verifyUserAreDeleted(String username, String type) {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		au = new AdminUsersPage(driver);
		au.selectAdminUsersPage();
		au.deleteUser(username);
		boolean actual = au.verifyUserIsPresent(username);
		Assert.assertFalse(actual, Constant.ERRORMESSAGE_USERSNOTDELETED);

	}

	@Test(priority = 3,groups = {"regression" })
	public void verifySearchButtonIsClickable() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		au = new AdminUsersPage(driver);
		au.selectAdminUsersPage();
		boolean actual = au.verifySearchButtonIsClickable();
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_ADMINUSERS_SEARCHBUTTON);
	}
}
