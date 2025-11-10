package com.crm.Expressvisa.GenericLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtility {
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void navigateToApplication(WebDriver driver,String url) {
		driver.get(url);
	}
	
	public void mouseover(WebDriver driver,WebElement address) {
		
		Actions a=new Actions(driver);
		a.moveToElement(address).perform();
	}
	
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	public void selectOptionFromSingleDropdown(WebElement element,String dropname) {
		Select s=new Select(element);
		s.selectByContainsVisibleText(dropname);
		
	}

}
