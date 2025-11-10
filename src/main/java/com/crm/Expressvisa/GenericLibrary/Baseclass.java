package com.crm.Expressvisa.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ExpressVisa.ObjectRepository.Homepage;
import com.ExpressVisa.ObjectRepository.LoginPage;
import com.beust.jcommander.Parameter;

public class Baseclass {
	public static WebDriver driver;
	FileUtility f=new FileUtility();
	SeleniumUtility sutil=new SeleniumUtility();
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	//@Parameters("browser")
	@BeforeTest()
	public void launchbrowser(@Optional("chrome") String BROWSER ) throws IOException {
		if (BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		} 
		else if (BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		} 
		
		else {
			driver=new ChromeDriver();
		} 

		
		
		
		sutil.maximize(driver);
		sutil.implicitwait(driver);
		
		String URL = f.readDataFromProperty("url");
		sutil.navigateToApplication(driver,URL );
		Reporter.log("browser launched successfully",true);
	}
	
	@BeforeMethod
	public void loginToExpessVisa() throws IOException {
		String un = f.readDataFromProperty("username");
		String pw = f.readDataFromProperty("password");
		LoginPage lp=new LoginPage(driver)	;
		lp.login(driver, un, pw);
		Reporter.log("logged in successfully",true);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Homepage hp=new Homepage(driver);
		WebElement element = hp.getLogouticon();
		Thread.sleep(3000);
		sutil.mouseover(driver, element);
		hp.getSignout().click();
		Reporter.log("logout successful",true);
		
	}
	
	@AfterTest
	public void closeBrowser() {
		sutil.closeBrowser(driver);
		Reporter.log("browser closed ",true);
	}
	
	@AfterSuite
	public void databasedisconnect() {
		Reporter.log("database disconnected",true);
	}

}
