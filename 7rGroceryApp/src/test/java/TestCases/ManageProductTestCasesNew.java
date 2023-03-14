package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;
import ElementRepository.ManageProduct;
import Utilities.ExcelRead;
import Utilities.RetryUtils;
import constant.Constant;

public class ManageProductTestCasesNew extends BaseClass{
	ManageProduct mp;
	LoginPage lp;
	ExcelRead er = new ExcelRead();
	
	@Test(groups = { "regression" },priority = 1)
	public void verifyWhetherManageProductTabIsSelected() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		boolean actual=mp.checkWhetherManageProductTabIsSelected();
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_MANAGEPRODUCTTAB);
	}
	

	@Test(groups = { "regression" },priority = 2)
	public void verifyTheBackgroundColorOfNewButton() {

		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		String actualResult = mp.getBackGroundColorOfNewButton();
		String expectedResult = prop.getProperty("NewButtonBgColor");
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE_BACKGROUNDCOLOR);

	}

	@Test(groups = { "regression" },priority = 3)
	public void verifyTheNonVegRadioButtonIsSelected() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		mp.selectNewButton();
		mp.selectRadiobButtonForNonVegInNewProduct();
		boolean actualResult = mp.verifyRadioButtonNonVegIsSelected();
		Assert.assertTrue(actualResult,Constant.ERRORMESSAGE_RADIOBUTTON_NONVEG);
	}

	@Test(groups = { "regression" },priority = 4)
	public void verifyThePlaceHolderTextOfProductTitle() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		mp.selectSearchButton();
		String actualResult = mp.getPlaceholderTextOfTitleField();
		String expectedResult = prop.getProperty("PlaceHolderTextOfTitle");
		Assert.assertEquals(actualResult, expectedResult, "Placeholder text of Title field is not as expected");
	}
	
	@Test(retryAnalyzer = RetryUtils.class,groups = { "regression" },priority = 5)
	public void verifyTheSearchItemsListedByProductTitle() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		mp.selectSearchButton();
		boolean actualResult=mp.getProductsListedCorrespondingToTitleSearched(prop.getProperty("ProductTitleToSearch"));
		Assert.assertTrue(actualResult,Constant.ERRORMESSAGE_PRODUCTLISTED_TITLE);
		
	}
	@Test(retryAnalyzer = RetryUtils.class,groups = { "regression" },priority = 6)
	public void verifyTheSearchItemsListedByProductCode() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		mp.selectSearchButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)); 
		boolean actualResult=mp.getProductWithSpecificCode(prop.getProperty("ProductCode_ToSearch"));
		Assert.assertTrue(actualResult,Constant.ERRORMESSAGE_PRODUCTLISTED_CATEGORY);
	}
}
