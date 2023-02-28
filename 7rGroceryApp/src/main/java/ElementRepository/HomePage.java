package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class HomePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialize elements find by @findBy - with pagefactory
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'])[2]")
	WebElement managePagesMoreInfo;
	
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")
	WebElement adminUsersMoreInfo;
	
	@FindBy(xpath="(//div[@class='small-box bg-info'])[1]")
	WebElement managePagesBox;

	public void selectManagePagesMoreInfo() {
		managePagesMoreInfo.click();
	}
	public void selectAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
	}
	public String getBackgrounColorOfManagePagesIcon() {
		return gu.getPropertyValueOfElements(managePagesBox, "background-color");
		
	}
}
