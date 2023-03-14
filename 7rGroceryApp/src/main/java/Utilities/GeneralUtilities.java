package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public String getTextOfElements(WebElement element) { // to get text of any element, pass element as arguments
		String text = element.getText();
		return text;
	}

	public void selectDropDownValueByVisibleText(WebElement element, String visibleText) {
		Select obj = new Select(element);
		obj.selectByVisibleText(visibleText);

	}

	public String getSelectedValueFromDropDown(WebElement element, String value) {
		Select obj = new Select(element);
		obj.selectByValue(value);
		WebElement selectedElement = obj.getFirstSelectedOption();
		String text = selectedElement.getText();
		return text;
	}

	public String getPropertyValueOfElements(WebElement element, String propertyType) {
		String propertyValue = element.getCssValue(propertyType);
		return propertyValue;

	}

	public boolean verifyWhetherTheCheckBoxOrRadioButtonIsSelected(WebElement element) {
		boolean elementIsSelected = element.isSelected();
		return elementIsSelected;

	}

	public String getAttributeValueOfElement(WebElement element, String attributeType) {
		String attributeValue = element.getAttribute(attributeType);
		return attributeValue;
	}

	public boolean checkItemsListedWhenSearch(List<WebElement> columnElements, String searchText) {
		boolean value = true;
		for (int i = 0; i < columnElements.size(); i++) {
			String ListedElementText = columnElements.get(i).getText();
			if (!ListedElementText.toLowerCase().contains(searchText.toLowerCase())) {

				value = false;
			}
		}
		return value;
	}

	public boolean verifyWhetherAnItemIsInList(List<WebElement> columnElements, String searchText) {
		boolean value = false;
		for (int i = 0; i < columnElements.size(); i++) {
			String ListedElementText = columnElements.get(i).getText();
			if (ListedElementText.toLowerCase().equals(searchText.toLowerCase())) {
				value = true;
			}
		}
		return value;
	}

	public boolean verifyWhetherOptionIsSelected(WebElement element, String attributeType, String text) {
		boolean value = element.getAttribute(attributeType).contains(text);
		return value;
	}

	public void enterValueToAnElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public boolean verifyWhetherAnElementIsDisplayed(WebElement element) {
		boolean value = element.isDisplayed();
		return value;
	}

	public void fileUpload(WebDriver driver, WebElement element, String imageName) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();
			Robot obj = new Robot();
			// Java Code for copy file path to system clipboard
			// "C:\Users\Geethu\git\7rGroceryApp\7rGroceryApp\src\main\resources\Image Files\IMG_20221019_103510.jpg"
			StringSelection ss = new StringSelection(
					System.getProperty("user.dir") + "\\src\\main\\resources\\Image Files\\"+imageName);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			obj.delay(250);
			obj.keyPress(KeyEvent.VK_CONTROL);
			obj.keyPress(KeyEvent.VK_V);
			obj.delay(250);
			obj.keyRelease(KeyEvent.VK_CONTROL);
			obj.keyRelease(KeyEvent.VK_V);
			obj.delay(250);
			obj.keyPress(KeyEvent.VK_ENTER);
			obj.keyRelease(KeyEvent.VK_ENTER);
			obj.delay(250);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
