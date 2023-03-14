package ElementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtility;

public class ManageExpense {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public ManageExpense(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="(//p[contains(text(),'Manage Expense')])[1]")
	WebElement manageExpenseTab;

	
	@FindBy(linkText="Expense Category")
	WebElement expenseCategoryTab;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addNewButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement newExpenseCategoryTitle;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	List<WebElement> expenses;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]//a[2]")
	List<WebElement> deleteIcon;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> expenseCategory;

	public void selectExpenseCategoryPage() {
		manageExpenseTab.click();
		expenseCategoryTab.click();
	}

	public boolean checkWhetherExpenseCategoryTabIsSelected() {
		return gu.verifyWhetherOptionIsSelected(expenseCategoryTab, "class", "active");

	}

	public void selectNewExpenseCategory() {
		addNewButton.click();
	}

	public void addNewExpenseCategory(String Title) {
		gu.enterValueToAnElement(newExpenseCategoryTitle, Title);
		saveButton.click();
	}

	public boolean verifyWhetherNewExpenseCategoryIsAddedToList(String title) {
		selectNewExpenseCategory();
		addNewExpenseCategory(title);
		return gu.verifyWhetherAnItemIsInList(expenses, title);

	}

	public void deleteExpenseCategory(String expenseCategoryName) {
		String locator = null;
		for (int i = 0; i < expenseCategory.size(); i++) {
			if (expenseCategory.get(i).getText().equals(expenseCategoryName)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)+ "]//td[2]//a[2]";
				break;
			}
		}
		WebElement deleteItem = driver.findElement(By.xpath(locator));
		deleteItem.click();
	}
	public boolean verifyWhetherExpensecategoryIsDeleted(String expenseCategoryName) {
		deleteExpenseCategory(expenseCategoryName);
		wu.alertIsPresent(driver);
		driver.switchTo().alert().accept();
		return gu.verifyWhetherAnItemIsInList(expenseCategory, expenseCategoryName);
		
	}
}
