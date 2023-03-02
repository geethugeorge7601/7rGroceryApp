package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;
import ElementRepository.ManageProduct;
import Utilities.ExcelRead;
import constant.Constant;

public class ManageProductTestCasesNew extends BaseClass{
	ManageProduct mp;
	LoginPage lp;
	ExcelRead er = new ExcelRead();
	
	@Test
	public void verifyWhetherManageProductTabIsSelected() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		boolean actual=mp.checkWhetherManageProductTabIsSelected();
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_MANAGEPRODUCTTAB);
	}
	

	@Test
	public void verifyTheBackgroundColorOfNewButton() {

		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		String actualResult = mp.getBackGroundColorOfNewButton();
		String expectedResult = prop.getProperty("NewButtonBgColor");
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE_BACKGROUNDCOLOR);

	}

	@Test
	public void verifyTheNonVegRadioButtonIsSelected() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		mp.selectNewButton();
		mp.selectRadiobButtonForNonVegInNewProduct();
		boolean actualResult = mp.verifyRadioButtonNonVegIsSelected();
		Assert.assertTrue(actualResult,Constant.ERRORMESSAGE_RADIOBUTTON_NONVEG);
	}

	@Test
	public void verifyThePlaceHolderTextOfProductTitle() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		mp.selectSearchButton();
		String actualResult = mp.getPlaceholderTextOfTitleField();
		String expectedResult = prop.getProperty("PlaceHolderTextOfTitle");
		Assert.assertEquals(actualResult, expectedResult, "Placeholder text of Title field is not as expected");
	}
	
	@Test
	public void verifyTheSearchItemsListedByProductTitle() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		mp.selectSearchButton();
		boolean actualResult=mp.getProductsListedCorrespondingToTitleSearched(prop.getProperty("ProductTitleToSearch"));
		Assert.assertTrue(actualResult,Constant.ERRORMESSAGE_PRODUCTLISTED_TITLE);
		
	}
	@Test
	public void verifyTheSearchItemsListedByProductCategory() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2,1),er.readdata(3, 1));
		mp = new ManageProduct(driver);
		mp.selectManageProdutPage();
		mp.selectSearchButton();
		boolean actualResult=mp.getProductsListedCorrespondingToCategory(prop.getProperty("ProductCategoryToSearch"));
		Assert.assertTrue(actualResult,Constant.ERRORMESSAGE_PRODUCTLISTED_CATEGORY);
	}
}
