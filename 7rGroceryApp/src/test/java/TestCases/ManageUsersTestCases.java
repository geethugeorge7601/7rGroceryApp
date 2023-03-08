package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;
import ElementRepository.ManageUsersPage;
import Utilities.ExcelRead;
import constant.Constant;

public class ManageUsersTestCases extends BaseClass {
	LoginPage lp;
	ManageUsersPage mu;
	ExcelRead er = new ExcelRead();
	@Test(priority =1)

	public void verifyTheFontSizeOfPageTitle() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		mu= new ManageUsersPage(driver);
		mu.selectManageUsersPage();
		String actualResult = mu.getFontSizeOfPageTitle();
		String expectedResult = prop.getProperty("ManageUsersPageTitleFontsize");
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE_PAGETITLE_FONTSIZE);
	}
	@Test(priority =2)
	public void verifyWhetherPasswordOfParticularUserIsVisible() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mu= new ManageUsersPage(driver);
		mu.selectManageUsersPage();
		boolean actual =mu.verifyPasswordOfUserIsVisible(prop.getProperty("User_To_showpassword"));
		Assert.assertTrue(actual);
		
	}
}
