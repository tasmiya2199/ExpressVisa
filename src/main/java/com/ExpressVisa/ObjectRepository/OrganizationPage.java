package com.ExpressVisa.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Expressvisa.GenericLibrary.SeleniumUtility;

public class OrganizationPage {
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement plusicon;
	
	@FindBy(name = "accountname")
	private WebElement orgname;
	
	@FindBy(name = "phone")
	private WebElement phonetxt;
	
	@FindBy(id = "email1")
	private WebElement emailtest;
	
	@FindBy(name = "industry")
	private WebElement industrydrop;
	
	@FindBy(name = "bill_street")
	private WebElement billingaddress;
	
	@FindBy(name = "ship_street")
	private WebElement shippingaddress;
	
	@FindBy(name = "button")
	private WebElement savebtn;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cacelbtn;
	
	
	
	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getPhonetxt() {
		return phonetxt;
	}

	public WebElement getEmailtest() {
		return emailtest;
	}

	public WebElement getIndustrydrop() {
		return industrydrop;
	}

	public WebElement getBillingaddress() {
		return billingaddress;
	}

	public WebElement getShippingaddress() {
		return shippingaddress;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getCacelbtn() {
		return cacelbtn;
	}

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getPlusicon() {
		return plusicon;
	}
	
	
	public void createorg(WebDriver driver,String name,String phone,String billing,String shipping) {
		OrganizationPage op=new OrganizationPage(driver);
		op.getOrgname().sendKeys(name);
		op.getPhonetxt().sendKeys(phone);
		WebElement address = op.getIndustrydrop();
		SeleniumUtility sutil=new SeleniumUtility();
		sutil.selectOptionFromSingleDropdown(address, "Engineering");
		op.getBillingaddress().sendKeys(billing);
		op.getShippingaddress().sendKeys(shipping);
		op.getSavebtn().click();
	}

	
}
