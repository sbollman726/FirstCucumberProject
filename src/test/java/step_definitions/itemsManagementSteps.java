package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.CraterItemsPage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class itemsManagementSteps {

	LoginPage login = new LoginPage();
	CraterItemsPage itemsPage = new CraterItemsPage();
	CraterCommonPage commonPage = new CraterCommonPage();
	BrowserUtils utils = new BrowserUtils();
	static String itemValue;
	static String shortItemValue;
	
//	static int randomNum = utils.randonNumber();
	static String itemName;
	
	@Given("As an entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
		Driver.getDriver().get(DataReader.getProperty("appurl"));
		login.login();
	}
	
	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() {
		commonPage.itemsLink.click();
		Assert.assertTrue(itemsPage.itemsPageHeaderText.isDisplayed());		
	}
	
	@When("I click on the Add Item button")
	public void i_click_on_the_add_item_button() {
		utils.waitUntilElementVisible(itemsPage.addItemButton);
		itemsPage.addItemButton.click();
	}
	
	@Then("I should be on item input page")
	public void i_should_be_on_item_input_page() {
		utils.waitUntilElementVisible(itemsPage.addItemPageHeaderText);
		Assert.assertTrue(itemsPage.addItemPageHeaderText.isDisplayed());
	}
	
	@When("I provide item information name {string}, price {int}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, Integer price, String unit, String description) {
		itemName = name;
		itemsPage.addItemName.sendKeys(name);
		itemsPage.addItemPrice.sendKeys(price.toString());
		itemsPage.addItemUnit.click();
		utils.waitUntilElementVisible(itemsPage.addItem_pc_unit);
		Driver.getDriver().findElement(By.xpath("//span[text()='"+unit+"']")).click();
		itemsPage.addItemDescription.sendKeys(description);
	}
	
	@When("I click Save Item button")
	public void i_click_save_item_button() {
		itemsPage.saveItemButton.click();

	}
	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed());
		itemValue = Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).getAttribute("href");
		shortItemValue = itemValue.substring(45,49);
	}
	
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Test Case 2 Update**
					//			(//a[text()='iphone 14 pro']//parent::td//following-sibling::td)[2]//span
	
	@When("I select the item {string}")
	public void i_select_the_item(String name) {
		itemName = name;
		Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).click();
		//itemsPage.bookItem.click();
		}
	
	@Then("I should be on item details page")
	public void i_should_be_on_item_details_page() {
		Assert.assertTrue(itemsPage.editItemHeaderText.isDisplayed());
	}
	
	@When("I update the item price to {int} dollars")
	public void i_update_the_item_price_to_dollars(Integer price) {
		utils.waitUntilElementVisible(itemsPage.addItemPrice);
		itemsPage.addItemPrice.clear();
		itemsPage.addItemPrice.sendKeys(price.toString());
//		itemsPage.addItemUnit.click(); //
//		itemsPage.addItem_dollars_unit.click();
//		itemsPage.addItemUnit.click();
	}
	
	@When("I click Update Item button")
	public void i_click_update_item_button() {
		utils.scrollTo(itemsPage.updateItemButton);
		itemsPage.updateItemButton.click();
	}
	
	@Then("the Item price is updated to {int} dollars")
	public void the_item_price_is_updated_to_dollars(Integer updatedPrice) {

		String itemXpath = "(//a[text()='"+itemName+"']//parent::td//following-sibling::td)[2]//span";
		String itemPrice = Driver.getDriver().findElement(By.xpath(itemXpath)).getText();
		System.out.println(itemPrice);
		String trimmedPrice = itemPrice.substring(2);
		Assert.assertEquals(trimmedPrice, updatedPrice + ".00");
		
//		String num1 = Driver.getDriver().findElement(By.xpath("//tr[1]/td[3]")).getText();
//		Assert.assertTrue(num1.equals(num));
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	// data table item create steps
	
	@When("I provide item information to the fields")
	public void i_provide_item_information_to_the_fields(DataTable dataTable) {
		List<String> itemInfo = dataTable.asList();
		for ( String info : itemInfo) {
			System.out.println(info);
		}
		itemName = itemInfo.get(0);
		itemsPage.addItemName.sendKeys(itemInfo.get(0));
		itemsPage.addItemPrice.sendKeys(itemInfo.get(1));
		itemsPage.addItemUnit.click();
		utils.waitUntilElementVisible(itemsPage.addItem_pc_unit);
		Driver.getDriver().findElement(By.xpath("//span[text()='"+itemInfo.get(2)+"']")).click();
		itemsPage.addItemDescription.sendKeys(itemInfo.get(3));
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Test case 3 Delete steps
	
	@When("I select the checkbox next to specified item")
	public void i_select_the_checkbox_next_to_specified_item() {
		utils = new BrowserUtils();
		itemsPage = new CraterItemsPage();
		utils.waitUntilElementVisible(itemsPage.itemsPageHeaderText);
		Driver.getDriver().findElement(By.xpath("//input[@value='"+shortItemValue+"']")).click();

	}
	@When("I click on actions dropdown")
	public void i_click_on_actions_dropdown() {
		itemsPage = new CraterItemsPage();
		utils = new BrowserUtils();
		utils.waitUntilElementVisible(itemsPage.actionsDropdown);
		utils.actionsClick(itemsPage.actionsDropdown);
	}
	
	@When("I click delete")
	public void i_click_delete() {
		itemsPage = new CraterItemsPage();
		utils = new BrowserUtils();
		utils.waitUntilElementVisible(itemsPage.itemDeleteDropdown);
		itemsPage.itemDeleteDropdown.click();
	}
	
	@Then("I should not see the item listed")
	public void i_should_not_see_the_item_listed() {
		//	Assert.assertFalse(!Driver.getDriver().findElement(By.xpath("//input[@value='"+shortItemValue+"']")).isDisplayed());
		}
	
	@When("I confrim delete")
	public void i_confrim_delete() {
		itemsPage.itemConfirmDeleteBTN.click();
	}
	
	@When("I provide item information to the specified fields {string}, price {int}, unit {string}, and description {string}")
	public void i_provide_item_information_to_the_specified_fields_price_unit_and_description(String itemname, Integer itemPrice, String itemUnit, String itemDescription) {
		itemsPage.AddItemInfo(itemname, itemPrice, itemUnit, itemDescription);
		itemName = itemname;
	}
	
	@When("I delete the item above")
	public void i_delete_the_item_above() throws InterruptedException {
		itemsPage = new CraterItemsPage();
		System.out.println(itemName);
		itemsPage.deleteItem(itemName, shortItemValue);
	}
	
	
	
	
}
