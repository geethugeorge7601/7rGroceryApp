package ElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManageContentPage{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath ="//p[contains(text(),'Manage Content')]")
	WebElement manageContentTab;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'])[1]")
	WebElement managePagesTab;
	
	@FindBy(id="title")
	WebElement pageTitle;
	
	@FindBy(xpath="//div[@class='note-editable card-block']//p")
	WebElement pageDescription;
	
	@FindBy(id="page")
	WebElement pageName;
	
	@FindBy(id="main_img")
	WebElement chooseFileButton;
	
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	
	public void selectManagePages() {
		manageContentTab.click();
		managePagesTab.click();
	}
	
	public void addPageDetails(String title,String desc,String name,String image) throws InterruptedException {
		pageTitle.sendKeys(title);
		pageDescription.sendKeys(desc);
		pageName.sendKeys(name);
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		action.moveToElement(chooseFileButton).click().perform();
		Thread.sleep(3000);
		gu.fileUpload(image);
		
	}
	
	public void editPageDetails(String pageTitle,String newTitle,String desc,String name,String image) throws InterruptedException {
		String locator ="//td[text()='"+pageTitle+"']//following-sibling::td/a[@class='btn btn-sm btn btn-primary btncss']";
		WebElement editIcon = driver.findElement(By.xpath(locator));
		editIcon.click();
		addPageDetails(newTitle,desc,name,image);
		updateButton.click();
			
	}

}
