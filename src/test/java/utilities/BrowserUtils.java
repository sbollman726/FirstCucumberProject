package utilities;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

	
	Actions action;
	WebDriverWait wait;
	Select letsSelect;
	JavascriptExecutor js;
	
	// waits for an element to be visable 
	public void waitUntilElementVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	// waits for an element to be gone
	public void waitUntilElementNotVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}

	// waits for an element to be clickable
	public void waitUntilElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// send keys via actions class to the field that is not interactable 
	public void actionsSendKeys(WebElement element, String txt) {
		action = new Actions(Driver.getDriver());
		action.sendKeys(element, txt).build().perform();
	}
	
	// click via actions class to the field that is not clickable
	public void actionsClick(WebElement element) {
		action = new Actions(Driver.getDriver());
		action.click().build().perform();
	}
	
	// select by visible text
	public void selectByVisibleText(WebElement element, String tobeSelectedOptionText) {
		letsSelect = new Select(element);
		letsSelect.selectByVisibleText(tobeSelectedOptionText);
	}
	
	// select by value
	public void selectByValue(WebElement selectElement, String value) {
		letsSelect = new Select(selectElement);
		letsSelect.selectByValue(value);
	}
	
	// select by index
	public void selectByIndex(WebElement selectElement, int index) {
		letsSelect = new Select(selectElement);
		letsSelect.selectByIndex(index);
	}
	
	// return the selected option from dropdown
	public String getSelectedOption (WebElement selectElement) {
		letsSelect = new Select(selectElement);
		return letsSelect.getFirstSelectedOption().getText();	
	}
	
	// scroll to given element
	public void scrollTo(WebElement element) {
		js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);	
	}
	
	public void scrollUp(int x) {
		js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scrollBy(0,"+x+")", "");	
	}
	
	public int randonNumber() {
		Random randy = new Random();
		int randomNum = randy.nextInt((999 - 100) + 1) + 100;
		return randomNum;
	}
	
	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		return true;
	}
	
	
	
}
