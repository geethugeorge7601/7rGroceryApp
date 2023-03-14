package ElementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManageDeliveryBoy {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialize elements find by @findBy - with pagefactory
	}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	WebElement manageDeliveryBoyLink;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="address")
	WebElement address;
	
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]")
	List<WebElement> deliverboyUsernames;
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	@FindBy(id="un")
	WebElement searchName;
	
	public void selectManageDeliveryBoyPage() {
		manageDeliveryBoyLink.click();
	}
	public void addNewDeliveryBoy(String deliveryBoyName,String emailiD,String phoneno,String addressText, String username,String password) {
		newButton.click();
		name.sendKeys(deliveryBoyName);
		email.sendKeys(emailiD);
		phone.sendKeys(phoneno);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");
		address.sendKeys(addressText);
		usernameField.sendKeys(username);
		//js.executeScript("window.scrollBy(0,1000)");
		passwordField.sendKeys(password);
		js.executeScript("window.scrollBy(0,1000)");
		saveButton.click();
	
	}
	public boolean verifyDeliveryBoyAdded(String name) {
		return gu.verifyWhetherAnItemIsInList(deliverboyUsernames, name);
	}
	
	public boolean verifyFunctionalityOfResetButton() {
		searchButton.click();
		resetButton.click();
		return searchName.isDisplayed();
		
		
	}
}
