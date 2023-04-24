package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;

public class AmazonDepartmentsSteps {

	AmazonHomePage AHomePage = new AmazonHomePage();
	BrowserUtils utils = new BrowserUtils();

	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
		Driver.getDriver().get("https://amazon.com");
		String homePageTitle = Driver.getDriver().getTitle();
		Assert.assertEquals(homePageTitle, "Amazon.com. Spend less. Smile more.");
	}

	@Given("The department dropdown is {string}")
	public void the_department_dropdown_is(String defaultOption) {
//		Select letsSelect = new Select(AHomePage.departmentsDropdown);
//		Assert.assertEquals(letsSelect.getFirstSelectedOption(), defaultOption);
		Assert.assertEquals(utils.getSelectedOption(AHomePage.departmentsDropdown), defaultOption);
		utils.getSelectedOption(AHomePage.departmentsDropdown);
	}

	@When("I selecet the department {string}")
	public void i_selecet_the_department(String optionToSelected) {
		utils.selectByVisibleText(AHomePage.departmentsDropdown, optionToSelected);
	}

	@When("I search {string}")
	public void i_search(String searchItem) {
		AHomePage.searchFeild.sendKeys(searchItem, Keys.ENTER);
	}

	@Then("I should be on {string} search result page")
	public void i_should_be_on_search_result_page(String searchedItem) {
		String searchPageTitle = Driver.getDriver().getTitle();
		Assert.assertTrue(searchPageTitle.contains(searchedItem));
	}

}

























