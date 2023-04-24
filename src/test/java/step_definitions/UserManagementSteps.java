package step_definitions;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class UserManagementSteps { 
	
	LoginPage loginPage = new LoginPage();
	BrowserUtils utils = new BrowserUtils();
	
	String emailAddress;
	String passwordInput;

	// Valid Log In Scenario
	
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
		Driver.getDriver().get(DataReader.getProperty("appurl"));
	}
	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		utils.actionsSendKeys(loginPage.emailField, DataReader.getProperty("username"));
		utils.actionsSendKeys(loginPage.passField, DataReader.getProperty("password"));
//	//	loginPage.emailField.sendKeys(DataReader.getProperty("username"));
//	//	loginPage.passField.sendKeys(DataReader.getProperty("password"));
	}
	@When("I click on login button")
	public void i_click_on_login_button() {
		loginPage.loginBtn.click();
	}
	@Then("I should be on the user profile page")
	public void i_should_be_on_the_user_profile_page() {
		Assert.assertTrue(loginPage.accountSettingsHeader.isDisplayed());
	}

	
	// Invalid Log In Scenario
	
	@When("I enter invalid username and valid password")
	public void i_enter_invalid_username_and_valid_password() {
		utils.actionsSendKeys(loginPage.emailField, "invalid@primetechschool.com");
		utils.actionsSendKeys(loginPage.passField, DataReader.getProperty("password"));
	}
	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		if(emailAddress.equals("") || passwordInput.equals("")) {
			utils.waitUntilElementVisible(loginPage.nullInputErrorMessage);
			Assert.assertTrue(loginPage.nullInputErrorMessage.isDisplayed());
		}
		else {
			utils.waitUntilElementVisible(loginPage.invalidLoginErrorMess);
			Assert.assertTrue(loginPage.invalidLoginErrorMess.isDisplayed());
		}
		
		
		utils.waitUntilElementVisible(loginPage.invalidLoginErrorMess);
		Assert.assertTrue(loginPage.invalidLoginErrorMess.isDisplayed());
	
	}
	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
		Assert.assertTrue(loginPage.loginBtn.isDisplayed());
	}
	
	
	// invalid password login steps
	
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
		utils.actionsSendKeys(loginPage.emailField, DataReader.getProperty("username"));
		utils.actionsSendKeys(loginPage.passField, "helloWorld123");
	}
	
	//scenario outline steps
	
	@When("I enter {string} and {string}")
	public void i_enter_and(String email, String password) {
		emailAddress = email;
		passwordInput = password;
		utils.actionsSendKeys(loginPage.emailField, email);
		utils.actionsSendKeys(loginPage.passField, password);
	}
	
	
	
	
}
