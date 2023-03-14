package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public void presenceOfElementLocated(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	public void elementToBeClickable(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void elementToBeSelected(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(locator)));
	}
	public void textToBePresentInElement(WebDriver driver,WebElement element,String text) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.textToBePresentInElement(element,text));
	}
	public void visibilityOfElementLocated(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
}
