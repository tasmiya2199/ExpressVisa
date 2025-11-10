package com.ExpressVisa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//decleration
	@FindBy(name = "user_name")
	private WebElement untbx;
	
	@FindBy(name = "user_password")
	private WebElement pwtbx;
	
	@FindBy(id = "submitButton")
	private WebElement lgbtn;
	
	//initilization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	
	//bussiness logic 
	public void login(WebDriver driver,String username,String password) {
		LoginPage lp=new LoginPage(driver);
		lp.getUntbx().sendKeys(username);
		
		lp.getPwtbx().sendKeys(password);
		lp.getLgbtn().click();
	}

}
