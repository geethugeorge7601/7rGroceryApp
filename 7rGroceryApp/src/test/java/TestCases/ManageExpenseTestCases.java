package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;
import ElementRepository.ManageExpense;
import ElementRepository.ManageProduct;
import Utilities.ExcelRead;
import constant.Constant;

public class ManageExpenseTestCases extends BaseClass {

	LoginPage lp;
	ManageExpense me;
	ExcelRead er = new ExcelRead();

	@Test(priority = 1,groups = { "regression","sanity"})
	public void verifyWhetherExpenseCategoryTabIsSelected() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		me = new ManageExpense(driver);
		me.selectExpenseCategoryPage();
		boolean actual = me.checkWhetherExpenseCategoryTabIsSelected();
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_EXPENSECATEGORY);
	}

	@Test(priority = 2,groups = { "regression"})
	public void verifyWhetherNewExpenseCategorIsAddedToList() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		me = new ManageExpense(driver);
		me.selectExpenseCategoryPage();
		boolean actualResult = me
				.verifyWhetherNewExpenseCategoryIsAddedToList(prop.getProperty("ExpenseCategoryToAdd"));
		Assert.assertTrue(actualResult, Constant.ERRORMESSAGE_ADDING_NEWEXPENSECATEGORY);
	}

	@Test(priority = 3,groups = { "regression"})
	public void verifyWhetherAnExpenseCategoryIsDeleted() {
		lp = new LoginPage(driver);
		lp.loginToApp(prop.getProperty("Username"), prop.getProperty("Password"));
		me = new ManageExpense(driver);
		me.selectExpenseCategoryPage();
		boolean actualResult = me.verifyWhetherExpensecategoryIsDeleted(prop.getProperty("ExpenseCategoryToDelete"));
		Assert.assertFalse(actualResult, Constant.ERRORMESSAGE_DELETING_EXPENSECATEGORY);
	}
}
