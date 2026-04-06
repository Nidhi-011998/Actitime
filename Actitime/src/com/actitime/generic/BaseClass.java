package com.actitime.generic;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	@BeforeTest
	public void OpenBrowser() {
		Reporter.log("OpenBrowser", true);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("OpenBrowser", true);
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		Reporter.log("closeBrowser", true);
	}
	@BeforeMethod
	public void login() throws IOException {
		FileLib f = new FileLib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(url);		
		LoginPage l= new LoginPage(driver);
		l.setLogin(un, pw);
//		driver.findElement(By.id("username")).sendKeys("admin");
//		driver.findElement(By.name("pwd")).sendKeys("manager");
//		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Reporter.log("login", true);
	}
	
	@AfterMethod
	public void logOut() {	
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.setLogout();
		//driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		Reporter.log("LogOut", true);
	}
}
