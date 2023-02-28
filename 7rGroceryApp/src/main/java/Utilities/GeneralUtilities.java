package Utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public String getTextOfElements(WebElement element) { // to get text of any element, pass element as arguments
		String text = element.getText();
		return text;
	}
	public void selectDropDownValueByVisibleText(WebElement element,String visibleText) {
		Select obj=new Select(element);
		obj.selectByVisibleText(visibleText);
		
	}
	
	public String getSelectedValueFromDropDown(WebElement element,String value) {
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
	
	public boolean checkItemsListedWhenSearch(List<WebElement> columnElements,String searchText) {
		boolean value = true;
		for (int i = 0; i < columnElements.size(); i++) {
			String ListedElementText=columnElements.get(i).getText();
			if (!ListedElementText.toLowerCase().contains(searchText.toLowerCase())) {

				value = false;
			}
		}
		return value;
	}
	public boolean verifyWhetherAnItemIsInList(List<WebElement> columnElements,String searchText) {
		boolean value = false;
		for (int i = 0; i < columnElements.size(); i++) {
			String ListedElementText=columnElements.get(i).getText();
			if (ListedElementText.toLowerCase().equals(searchText.toLowerCase())) {
				value = true;
			}
		}
		return value;
	}
	public boolean verifyWhetherTabIsSelected(WebElement element,String attributeType,String text) {
		boolean value =element.getAttribute(attributeType).contains(text);
		return value;
	}
	public void enterValueToAnElement(WebElement element,String value) {
		element.sendKeys(value);
	}
	public boolean verifyWhetherAnElementIsDisplayed(WebElement element) {
		boolean value = element.isDisplayed();
		return value;
	}
}
