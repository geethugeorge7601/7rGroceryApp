package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.DataProviderClass;
import ElementRepository.LoginPage;
import ElementRepository.ManageContentPage;
import Utilities.ExcelRead;
import Utilities.RandomUtility;
import Utilities.RetryUtils;
import constant.Constant;

public class ManageContentTestCases extends BaseClass {
	LoginPage lp;
	ManageContentPage mc;
	ExcelRead er = new ExcelRead();
	RandomUtility ru = new RandomUtility();

	 //@Test(dataProvider = "create_page",dataProviderClass = DataProviderClass.class, priority = 1)
	public void verifyNewPageCanBeAdded(String pagetitle, String description, String pagename, String image) {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mc = new ManageContentPage(driver);
		mc.selectManagePages();
		String name = pagename + ru.randomnumbers();
		mc.addPageDetails(pagetitle, description, name, image);
		driver.navigate().back();
		boolean actual = mc.verifyNewPageIsAdded(name);
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_PAGE_NOTADDED);
	}

	//@Test(priority = 1,groups = { "regression","sanity" })
	public void verifyPageDetailsCanBeEdited() {

		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mc = new ManageContentPage(driver);
		mc.selectManagePages();
		boolean actual = mc.editPageDetails(prop.getProperty("PageName_To_Update"), prop.getProperty("NewPageTitle"),
				prop.getProperty("NewPageName"));
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_PAGE_NOTUPDATED);
	}

}
