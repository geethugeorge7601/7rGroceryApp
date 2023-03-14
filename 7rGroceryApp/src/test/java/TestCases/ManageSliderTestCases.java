package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;
import ElementRepository.ManageContentPage;
import ElementRepository.ManageSlider;
import Utilities.RetryUtils;
import constant.Constant;

public class ManageSliderTestCases extends BaseClass {
	LoginPage lp;
	ManageSlider ms;

	 @Test(groups = { "regression" },priority = 1)
	public void verifynewSliderIsAdded() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		ms = new ManageSlider(driver);
		boolean actual = ms.checkNewSliderAdded(prop.getProperty("sliderImage"), prop.getProperty("sliderLink"));
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_SLIDER_NOTADDED);
	}

	@Test(retryAnalyzer = RetryUtils.class,groups = { "regression" },priority = 2)
	public void verifyBackGroundColorOfEditIconsListed() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		ms = new ManageSlider(driver);
		ms.selectSlidersPage();
		int rowCount = ms.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			String actualResult[] = ms.getColorOfEditIcon();
			String expectedResult = prop.getProperty("sliderEditIcon_BgColor");
			Assert.assertEquals(actualResult[i], expectedResult, Constant.ERRORMESSAGE_SLIDER_EDITiCON_BGCOLOR);
		}
	}
}
