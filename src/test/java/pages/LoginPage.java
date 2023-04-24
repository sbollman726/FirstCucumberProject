package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	BrowserUtils utils = new BrowserUtils();
	
	@FindBy (name = "email")
	public WebElement emailField;
	
	@FindBy (name = "password")
	public WebElement passField;
	
	@FindBy (xpath = "//button[text()='Login']")
	public WebElement loginBtn;
	
	@FindBy (xpath = "//h6[text()='Account Settings']")
	public WebElement accountSettingsHeader;
						
	@FindBy ( xpath = "//p[text()='These credentials do not match our records.']")
	public WebElement invalidLoginErrorMess;
	
	public void login() {
		utils.actionsSendKeys(emailField, DataReader.getProperty("username"));
		utils.actionsSendKeys(passField, DataReader.getProperty("password"));
		loginBtn.click();
	}
	
	@FindBy ( xpath = "//span[text()='Field is required']")
	public WebElement nullInputErrorMessage;
	
	
	
}
