package com.crm.Expressvisa.Testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ExpressVisa.ObjectRepository.Homepage;
import com.ExpressVisa.ObjectRepository.OrganizationPage;
import com.crm.Expressvisa.GenericLibrary.Baseclass;
import com.crm.Expressvisa.GenericLibrary.ListenerImplementation;
@Listeners(ListenerImplementation.class)
public class Check extends Baseclass{
	
	@Test
	public void test1() {
	Homepage hp=new Homepage(driver);
	hp.getOrglink().click();
	OrganizationPage op=new OrganizationPage(driver);
	op.getPlusicon().click();
	op.createorg(driver, "Qspider", "1234567890", "bengaluru", "Mumbai");
	}

}
