package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Addpointspage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.RegisterdBrokerPage;
import com.crm.qa.pages.SystemUserspage;
import com.crm.qa.pages.totalpublishedlistingspage;

public class HomePagetest extends TestBase{
	
	Loginpage lp;
	HomePage Hp;
	
	SystemUserspage su;
	
	totalpublishedlistingspage tpl;
	RegisterdBrokerPage rb;

   Addpointspage Ap;
   
	public HomePagetest() throws IOException {
		
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
		    
	}
	
	
	@Test(priority=1)
	
	public void verifyhomepagetitletest() {
		
		
		String Homepagetitle= Hp.verifyhomepagetitle();
		
		AssertJUnit.assertEquals(Homepagetitle,"Dashboard","home page tilte not matched");
		System.out.println("priority 1");	
	}
	
	@Test(priority=2)
	
	public void SystemUserstest() throws Exception {
		
		 Hp.clickonsystemusers();
		System.out.println("priority 2");
		
	} 
		
	
	
	@Test(priority=3)
	
	public void RegisterdBrokerPagetest() throws IOException {
		
		rb =Hp.clickonregisteredbroker();
		
		System.out.println("priority 3");
		
	}
	
	@Test(priority=4)
	
	public void publishedlistingtest() {
		
		tpl=Hp.clickontotalpublishedlistings();
		
		System.out.println("priority 4");
		
	}
	
	
@Test(priority=5)
	
	public void Addpointsclicktest() throws IOException {
		
		Ap=Hp.Addpointsclick();
		
		System.out.println("priority 5");
		
	}
	
@AfterMethod
			
			public void teardown() {
				
				System.out.print("after method");
				driver.quit();
			}
			
			
			
	}

 

