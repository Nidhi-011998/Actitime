package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EnterTimeTrackPage  {

	@FindBy(id="logoutLink")
	private WebElement lgOut; //declaration
	
	@FindBy(xpath="//div[text()='TASKS']")
	private WebElement tasksTab;
	
	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory. initElements(driver, this); //initialization
	}

	public void setLogout() {
		lgOut.click();
	}
	
	public void setTaks() {
		tasksTab.click();
	}
   
}
