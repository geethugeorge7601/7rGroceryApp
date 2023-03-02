package ElementRepository;

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
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user'])[1]")
	WebElement manageUsers;
	
	@FindBy(xpath ="//h1[@class='m-0 text-dark']")
	WebElement PageTitle;
	
	public void selectManageUsersPage() {
		manageUsers.click();
	}
	public String getFontSizeOfPageTitle() {
		return gu.getPropertyValueOfElements(PageTitle,"font-weight");
	}
}
