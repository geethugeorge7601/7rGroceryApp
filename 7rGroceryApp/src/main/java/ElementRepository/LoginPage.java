package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu= new WaitUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialize elements find by @findBy - with pagefactory
	}

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButton;

	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement label1;

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameElement;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordElement;

	@FindBy(xpath = "//label[@for='remember']")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath="//input[@id='remember']")
	WebElement rememberMe;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMessage;
	


	public void loginToApp(String username, String password) {

		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		signInButton.click();

	}

	public String getTextOfSignInButton() {
		wu.presenceOfElementLocated(driver,"//button[@class='btn btn-dark btn-block']" );
		return gu.getTextOfElements(signInButton);
	}

	public void selectRememberMeCheckBox() {
		rememberMeCheckBox.click();
	}

	public boolean checkRememberMeCheckBoxIsSelected() {
		return gu.verifyWhetherTheCheckBoxOrRadioButtonIsSelected(rememberMe);
	}
	public String getBackroundColorOfSignInButton() {
		return gu.getPropertyValueOfElements(signInButton, "background-color");
	}
	
	public String getTextofAlertMessageWhileLogin() {
		return gu.getTextOfElements(alertMessage);
	}
	public String getAttributeValueTypeForPassword() {
		return gu.getAttributeValueOfElement(passwordElement,"type");
	}
	
	}

