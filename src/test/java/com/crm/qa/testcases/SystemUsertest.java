package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.SystemUserspage;

public class SystemUsertest extends TestBase {
	
	
	SystemUserspage su;
	Loginpage lp;
	HomePage Hp;
	
	public SystemUsertest() throws IOException {
		super();
	}
	
	@BeforeMethod
	
	public void setup() throws Exception {
		
		initialization();
		
		lp= new Loginpage();
		
		Hp =lp.login(prop.getProperty("username"),prop.getProperty("password"));
		
		Hp.clickonsystemusers();
		su=new SystemUserspage();
		
	}
	
	
	@Test(priority=1)
	
	public void searchfieldtest() {
		
		
		
		su.systemusersearch(prop.getProperty("name"));
		
		System.out.println("namefield");
		
	}
	
	@Test(priority=2)
	
	public void searchbuttontest() {
		
		su.searchbuttonclick();
		
		System.out.println("searchbuttontext");
		
	}
	
	
	
	
	
	
	
@AfterMethod
	
	public void teardown() {
		
		System.out.print("after method");
		driver.quit();
	}	

}
