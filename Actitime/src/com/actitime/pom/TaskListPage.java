package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewButton;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustomerBtn;
	
	@FindBy(xpath="//input[@id='customerLightBox_nameField']")
	private WebElement enterCustomerNameTbx;
	
	@FindBy(id="customerLightBox_descriptionField")
	private WebElement CustomerDescriptionTbx;
	
	@FindBy(xpath="//button[contains(text(),'active customer')]")
	private WebElement SelectCustomerbutton;
	
	@FindBy(xpath="//a[contains(text(),'Our Company')]")
	private WebElement OurCompanybutton;
	
	@FindBy(xpath="//span[text()='Create Customer']")
	private WebElement CreateCustomerbutton;
	
	@FindBy(xpath="//div[@id=\"customerLightBox_cancelBtn\"]")
	private WebElement Cancelbutton;
	
	@FindBy(xpath="//div[@class='navigationLinks']/../div[@class='title ellipsis']")
	private WebElement ActualCustomerCreate;
	
	public WebElement getActualCustomerCreate() {
		return ActualCustomerCreate;
	}

	public TaskListPage(WebDriver driver) {
		PageFactory. initElements(driver, this);
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}

	public WebElement getNewCustomerBtn() {
		return newCustomerBtn;
	}

	public WebElement getEnterCustomerNameTbx() {
		return enterCustomerNameTbx;
	}

	public WebElement getCustomerDescriptionTbx() {
		return CustomerDescriptionTbx;
	}

	public WebElement getSelectCustomerbutton() {
		return SelectCustomerbutton;
	}

	public WebElement getOurCompanybutton() {
		return OurCompanybutton;
	}

	public WebElement getCreateCustomerbutton() {
		return CreateCustomerbutton;
	}

	public WebElement getCancelbutton() {
		return Cancelbutton;
	}
		
}
