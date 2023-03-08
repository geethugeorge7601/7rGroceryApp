package TestCases;


import org.testng.annotations.Test;

import DataProvider.DataProviderClass;
import ElementRepository.LoginPage;
import ElementRepository.ManageContentPage;
import Utilities.ExcelRead;


public class ManageContentTestCases extends BaseClass {
	LoginPage lp;
	ManageContentPage mc;
	ExcelRead er = new ExcelRead();
	
	@Test
	public void verifyPageDetailsCanBeEdited() throws InterruptedException {
		
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mc = new ManageContentPage(driver);
		mc.selectManagePages();
		mc.editPageDetails(prop.getProperty("PageTitle_To_Update"), "newwww","ddsdasdas", "dasdasdasd","IMG_20221026_173939.jpg");

	}
	
}
