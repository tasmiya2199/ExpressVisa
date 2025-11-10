package com.ExpressVisa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logouticon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	
	
	@FindBy(linkText = "Calendar")
	private WebElement calenderlink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadlink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitieslink;
	
	 
	
	public WebElement getCalenderlink() {
		return calenderlink;
	}

	public WebElement getLeadlink() {
		return leadlink;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}

	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getLogouticon() {
		return logouticon;
	}

}
