package com.actitime.testscript;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generic.ListnersImplementation.class)
public class CustomerModule extends BaseClass{
	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.setTaks();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNewButton().click();
		t.getNewCustomerBtn().click();
		FileLib f = new FileLib();
		String Customername = f.getExcelData("CreateCustomer", 1, 4);
		String Customerdesc = f.getExcelData("CreateCustomer", 1, 5);
		Reporter.log(Customername,true);
		Reporter.log(Customerdesc,true);
		t.getEnterCustomerNameTbx().sendKeys(Customername);
		t.getCustomerDescriptionTbx().sendKeys(Customerdesc);
		t.getSelectCustomerbutton().click();
		t.getOurCompanybutton().click();
		t.getCreateCustomerbutton().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomerCreate(), Customername));
		String actualCustomer = t.getActualCustomerCreate().getText();
		Assert.assertEquals(actualCustomer, Customername);
	}
}
