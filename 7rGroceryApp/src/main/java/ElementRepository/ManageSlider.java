package ElementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtility;

public class ManageSlider {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public ManageSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider'])[1]")
	WebElement manageSliderTab;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(id = "main_img")
	WebElement chooseFileButton;
	
	@FindBy(xpath ="//input[@class='form-control']")
	WebElement link;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBox;
	
	@FindBy(xpath ="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[4]//a[1]")
	List<WebElement> editIcons;
	
	public void selectSlidersPage() {
		manageSliderTab.click();
	}
	public boolean checkNewSliderAdded(String image,String linkUrl) {
		manageSliderTab.click();
		newButton.click();
		gu.fileUpload(driver, chooseFileButton, image);
		link.sendKeys(linkUrl);
		saveButton.click();
		return alertBox.isDisplayed();
				
	}
	public int getRowCount() {
		int count =editIcons.size();
		return count;
	}
	public String[] getColorOfEditIcon() {
		String locator = null;
		int size=editIcons.size();
		String bcolor[]= new String[size];
		for (int i = 0; i < editIcons.size(); i++) {
			locator ="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(i+1)+"]//td[4]//a[1]";
			WebElement editIconItem =driver.findElement(By.xpath(locator));
			bcolor[i] = gu.getPropertyValueOfElements(editIconItem, "background-color");
			
		}
		return bcolor;
	}
	
}
