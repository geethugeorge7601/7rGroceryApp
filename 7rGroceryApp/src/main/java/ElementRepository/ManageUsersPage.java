package ElementRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManageUsersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialize elements find by @findBy - with pagefactory
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user'])[1]")
	WebElement manageUsers;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement pageTitle;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> usersList;

	public void selectManageUsersPage() {
		manageUsers.click();
	}

	public String getFontSizeOfPageTitle() {
		return gu.getPropertyValueOfElements(pageTitle, "font-weight");
	}

	public boolean verifyPasswordOfUserIsVisible(String name) {
		String locator = null, passwordLocator = null;
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).getText().equals(name)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[3]//a";
				passwordLocator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 2)
						+ "]";
				break;
			}
		}
		WebElement showDetails = driver.findElement(By.xpath(locator));
		showDetails.click();
		WebElement userPassword = driver.findElement(By.xpath(passwordLocator));
		return gu.verifyWhetherOptionIsSelected(userPassword, "class", "open");
	}
	
	public boolean verifyStatusOfUserIsChanged(String name) {
		String locator = null, statusLocator = null;
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).getText().equals(name)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[5]//a";
				statusLocator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[5]//a//span";
				break;
			}
		}
		WebElement userStatus = driver.findElement(By.xpath(locator));
		userStatus.click();
		WebElement statusButton = driver.findElement(By.xpath(statusLocator));
		if(statusButton.getText().equals("Inactive")) {
		return gu.verifyWhetherOptionIsSelected(statusButton, "class","badge bg-warning");
		}
		else {
			return gu.verifyWhetherOptionIsSelected(statusButton, "class","badge bg-success");
		}
	}
}
