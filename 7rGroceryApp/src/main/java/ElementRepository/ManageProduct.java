package ElementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.GeneralUtilities;
import Utilities.WaitUtility;

public class ManageProduct {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialize elements find by @findBy - with pagefactory
	}
	
	
	@FindBy(linkText = "Manage Product")
	WebElement manageProductPage;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> productTitleColumnElements;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]")
	List<WebElement> productCategoryColumnElements;

	@FindBy(xpath = "//input[@value='Nonveg']")
	WebElement radioNonveg;

	@FindBy(xpath = "//input[@name='un']")
	WebElement productTitle;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchActionButton;
	
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement categoryDropDown;
	
	@FindBy(xpath="//input[@placeholder='Product Code']")
	WebElement productCode;
	
	public void selectManageProdutPage() {
		manageProductPage.click();
	}

	public String getBackGroundColorOfNewButton() {
		return gu.getPropertyValueOfElements(newButton, "background-color");
	}

	public void selectSearchButton() {
		searchButton.click();
	}

	public void selectNewButton() {
		newButton.click();
	}

	public void selectRadiobButtonForNonVegInNewProduct() {
		radioNonveg.click();

	}

	public boolean verifyRadioButtonNonVegIsSelected() {
		return gu.verifyWhetherTheCheckBoxOrRadioButtonIsSelected(radioNonveg);
	}

	public String getPlaceholderTextOfTitleField() {
		return gu.getAttributeValueOfElement(productTitle, "placeholder");

	}
	public void enterTitleOfProduct(String productName) {
		productTitle.sendKeys(productName);
	}
	public void clickSearchActionButton() {
		searchActionButton.click();
	}
	
	public boolean getProductsListedCorrespondingToTitleSearched(String title) {
		enterTitleOfProduct(title);
		clickSearchActionButton();
		return gu.checkItemsListedWhenSearch(productTitleColumnElements,title );
	}
	
	public boolean getProductsListedCorrespondingToCategory(String category) {
		gu.selectDropDownValueByVisibleText(categoryDropDown,category);
		clickSearchActionButton();
		return gu.checkItemsListedWhenSearch(productCategoryColumnElements,category);
	}
	public boolean getProductWithSpecificCode(String code) {
		productCode.sendKeys(code);
		clickSearchActionButton();
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//td[1]//button[text()='P"+code+"']";
		wu.presenceOfElementLocated(driver,locator);
		WebElement productWithCode =driver.findElement(By.xpath(locator));
		return productWithCode.isDisplayed();
	}
	public boolean checkWhetherManageProductTabIsSelected() {
		return gu.verifyWhetherOptionIsSelected(manageProductPage,"class","active");	
	}
}
