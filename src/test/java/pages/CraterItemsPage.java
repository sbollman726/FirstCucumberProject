package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.Driver;

public class CraterItemsPage {

	CraterItemsPage itemsPage;
	BrowserUtils utils;
	public CraterItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	public void AddItemInfo(String itemname, int itemPrice, String itemUnit, String itemDescription) {
		utils = new BrowserUtils();
		addItemName.sendKeys(itemname);
		addItemPrice.sendKeys(itemUnit.toString());
		
		addItemUnit.click();
		utils.waitUntilElementVisible(addItem_pc_unit);
		Driver.getDriver().findElement(By.xpath("//span[text()='"+itemUnit+"']")).click();
		
		addItemDescription.sendKeys(itemDescription);
	}
	
	
	public void deleteItem(String name, String shortValue) throws InterruptedException {
		utils = new BrowserUtils();
		utils.waitUntilElementVisible(Driver.getDriver().findElement(By.xpath("//a[text()='"+name+"']")));
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='"+name+"']")).isDisplayed());
		Driver.getDriver().findElement(By.xpath("//input[@value='"+shortValue+"']")).click();
//		utils.scrollUp(400);
		
		utils.waitUntilElementVisible(actionsDropdown);
//		utils.scrollTo(itemsPageHeaderText);
		Thread.sleep(5000);
		actionsDropdown.click();
		
		utils.waitUntilElementVisible(itemDeleteDropdown);
		Thread.sleep(1000);
		itemDeleteDropdown.click();
		
		utils.waitUntilElementVisible(itemConfirmDeleteBTN);
		Thread.sleep(1000);
		itemConfirmDeleteBTN.click();
	}
	
	
	@FindBy ( xpath = "//h3[text()='Items']")			//h3[text()='Items']
	public WebElement itemsPageHeaderText;
	
	@FindBy ( xpath = "//button[text()=' Add Item']")
	public WebElement addItemButton;
	
	@FindBy ( xpath = "//h3[text()='New Item']")
	public WebElement addItemPageHeaderText;
	
						//label[text()='Price ']
	@FindBy ( xpath = "(//input[@type='text'])[2]")
	public WebElement addItemName;
	
	@FindBy ( xpath = "//div[text()='Price ']//parent::label//following-sibling::div/input")
	public WebElement addItemPrice;
	
	@FindBy ( xpath = "//input[@class='w-full absolute inset-0 outline-none appearance-none box-border border-0 text-sm font-sans bg-white rounded-md pl-3.5']") 	//div[text()='select unit']//preceding::input[1]
	public WebElement addItemUnit;
	
	@FindBy ( xpath = "//span[text()='pc']")
	public WebElement addItem_pc_unit;
	
	@FindBy ( name = "description")
	public WebElement addItemDescription;
	
	@FindBy ( xpath = "//button[text()=' Save Item']")
	public WebElement saveItemButton;
	
	@FindBy ( xpath = "//a[@href='/admin/items/47/edit']")
	public WebElement bookItem;
	
	@FindBy ( xpath = "//h3[text()='Edit Item']")
	public WebElement editItemHeaderText;
	
	@FindBy ( xpath = "//span[text()='Dollars']")
	public WebElement addItem_dollars_unit;
	
	@FindBy ( xpath = "//button[@type='submit']")
	public WebElement updateItemButton;
	
	@FindBy( xpath= "//button[text()='Filter ']")
	public WebElement filterBTN;
	
	@FindBy (xpath = "//div[@name='name']")
	public WebElement filterNameTextField;
	
	@FindBy ( xpath = "//span[text()='Actions ']")
	public WebElement actionsDropdown;
	
	@FindBy ( xpath = "//a[text()=' Delete']")
	public WebElement itemDeleteDropdown;
	
	@FindBy ( xpath = "//button[text()='Ok']")
	public WebElement itemConfirmDeleteBTN;
	
	@FindBy ( xpath = "//svg[@class='w-6 h-6']")
	public WebElement itemPopUpMess;
	
	
	
	
	
	
}
