package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class AmazonSearchSteps {
	
	AmazonHomePage aPage = new AmazonHomePage();
	BrowserUtils utils = new BrowserUtils();

	
	@Given("I am on the Amazon Homepage")
	public void i_am_on_the_amazon_homepage() {
	   Driver.getDriver().get(DataReader.getProperty("amazonurl"));
	   Assert.assertTrue(Driver.getDriver().getTitle().equals("Amazon.com. Spend less. Smile more."));
	}
	
	@When("I click search")
	public void i_click_search() {
		aPage.searchButton.click();
	}
	
	@Then("I see results of {string}")
	public void i_see_results_of(String result) {
		utils.waitUntilElementVisible(Driver.getDriver().findElement(By.xpath("//span[text()='\""+result+"\"']")));
		String resultText = Driver.getDriver().findElement(By.xpath("//span[text()='\""+result+"\"']")).getText();
		String expectedResult = "\""+result+"\"";
		Assert.assertEquals(expectedResult, resultText);	
	}
	


	
	
	
}
