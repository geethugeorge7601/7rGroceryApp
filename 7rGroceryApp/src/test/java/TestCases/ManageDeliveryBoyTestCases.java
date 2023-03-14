package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import DataProvider.DataProviderClass;
import ElementRepository.LoginPage;
import ElementRepository.ManageDeliveryBoy;
import Utilities.RandomUtility;
import constant.Constant;

public class ManageDeliveryBoyTestCases extends BaseClass {
	LoginPage lp;
	ManageDeliveryBoy md;
	RandomUtility ru = new RandomUtility();

	@Test(dataProvider="add_deliveryboy",dataProviderClass = DataProviderClass.class, priority = 1,groups = { "regression"})
	public void verifyNewDeliveryBoyIsAdded(String name,String address) {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		md = new ManageDeliveryBoy(driver);
		md.selectManageDeliveryBoyPage();
		String emailid=name+ru.randomnumbers()+"@gmail.com";
		String username = name+ru.randomnumbers();
		md.addNewDeliveryBoy(name,emailid,ru.randomPhoneNumber(),address,username,ru.randomPassword());
		boolean actual = md.verifyDeliveryBoyAdded(username);
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_DELIVRYBOYNOTADDED);
	}
	
	@Test(priority = 2,groups = { "regression"})
	public void verifyFunctionalityOfRestButton() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		md = new ManageDeliveryBoy(driver);
		md.selectManageDeliveryBoyPage();
		boolean actual = md.verifyFunctionalityOfResetButton();
		Assert.assertFalse(actual,Constant.ERRORMESSAGE_RESETFUNCTIONALITY);
	}
	
}
