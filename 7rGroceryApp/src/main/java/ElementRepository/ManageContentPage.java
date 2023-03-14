package ElementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtility;

public class ManageContentPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public ManageContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Manage Content')]")
	WebElement manageContentTab;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'])[1]")
	WebElement managePagesTab;

	@FindBy(id = "title")
	WebElement pageTitle;

	@FindBy(xpath = "//div[@class='note-editable card-block']//p")
	WebElement pageDescription;

	@FindBy(id = "page")
	WebElement pageName;

	@FindBy(id = "main_img")
	WebElement chooseFileButton;

	@FindBy(xpath = "//button[@name='update']")
	WebElement updateButton;
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[4]")
	List<WebElement> pageNameList;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;

	public void selectManagePages() {
		manageContentTab.click();
		managePagesTab.click();
	}

	public void addPageDetails(String title, String desc, String name, String image) {
		newButton.click(); 
		pageTitle.sendKeys(title);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		pageDescription.sendKeys(desc);
		js.executeScript("window.scrollBy(0,2000)");
		pageName.sendKeys(name);
		gu.fileUpload(driver, chooseFileButton, image);
		js.executeScript("window.scrollBy(0,2000)");
		submit.click();	
	}

	public boolean verifyNewPageIsAdded(String pagename) {
		return gu.verifyWhetherAnItemIsInList(pageNameList, pagename);

	}

	public boolean editPageDetails(String oldpageName, String newTitle, String name) {
		String locator = "//td[text()='" + oldpageName
				+ "']//following-sibling::td/a[@class='btn btn-sm btn btn-primary btncss']";
		WebElement editIcon = driver.findElement(By.xpath(locator));
		editIcon.click();
		pageName.clear();
		pageTitle.clear();
		pageTitle.sendKeys(newTitle);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		pageName.sendKeys(name);
		updateButton.click();
		String locator1 = "//td[text()='" + newTitle
				+ "']//following-sibling::td/a[@class='btn btn-sm btn btn-primary btncss']";
		wu.presenceOfElementLocated(driver, locator1);
		return gu.verifyWhetherAnItemIsInList(pageNameList, name);

	}

}
