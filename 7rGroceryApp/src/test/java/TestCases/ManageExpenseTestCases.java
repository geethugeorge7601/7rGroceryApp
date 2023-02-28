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
	ExcelRead er;

	public ManageExpenseTestCases() throws IOException {
		er = new ExcelRead();
	}

	@Test(priority = 1)
	public void verifyWhetherExpenseCategoryTabIsSelected() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2, 1), er.readdata(3, 1));
		me = new ManageExpense(driver);
		me.selectExpenseCategoryPage();
		boolean actual = me.checkWhetherExpenseCategoryTabIsSelected();
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_EXPENSECATEGORY);
	}

	@Test(priority = 2)
	public void verifyWhetherNewExpenseCategorIsAddedToList() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2, 1), er.readdata(3, 1));
		me = new ManageExpense(driver);
		me.selectExpenseCategoryPage();
		boolean actualResult = me
				.verifyWhetherNewExpenseCategoryIsAddedToList(prop.getProperty("ExpenseCategoryToAdd"));
		Assert.assertTrue(actualResult, Constant.ERRORMESSAGE_ADDING_NEWEXPENSECATEGORY);
	}

	@Test(priority = 3)
	public void verifyWhetherAnExpenseCategoryIsDeleted() {
		lp = new LoginPage(driver);
		lp.loginToApp(er.readdata(2, 1), er.readdata(3, 1));
		me = new ManageExpense(driver);
		me.selectExpenseCategoryPage();
		boolean actualResult = me.verifyWhetherExpensecategoryIsDeleted(prop.getProperty("ExpenseCategoryToDelete"));
		Assert.assertFalse(actualResult, Constant.ERRORMESSAGE_DELETING_EXPENSECATEGORY);
	}
}
