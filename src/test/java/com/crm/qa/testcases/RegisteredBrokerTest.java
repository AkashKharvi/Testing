package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.RegisterdBrokerPage;

public class RegisteredBrokerTest extends TestBase{
	
	Loginpage lp;
	HomePage Hp;
	RegisterdBrokerPage Rb;
	
	public RegisteredBrokerTest() throws IOException {
	
		super();
	}

	
	@BeforeMethod
	
	public void setup() throws Exception {
		initialization();
		
		try {
				lp = new Loginpage();
			} catch (Exception e) {
								e.printStackTrace();
			}
		
		 
	
		Hp =lp.login(prop.getProperty("username"),prop.getProperty("password"));
		
		Hp.clickonregisteredbroker();
		
		Rb =new RegisterdBrokerPage();
		
	}
	


	
	
	@Test(priority=1)
	public void brokersearchfieldtest() throws InterruptedException {
	
	
	Rb.brokersearchfield(prop.getProperty("brokername"));
	
	System.out.println("test1");
	
	}
	
	@Test(priority=2)
	
	public void brokercountrynametest() {
	
	Rb.countrydropdown(prop.getProperty("brokercountryname"));
	
	}
	
	
	@Test(priority=3)
	
	public void brokersearchbuttontest() {
		
		Rb.brokersearchbutton();
	}
	
	@AfterMethod
	
	public void teardown() {
		
		System.out.println("after method");
		driver.quit();
	}
	
	
}
