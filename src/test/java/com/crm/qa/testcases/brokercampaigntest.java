package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BrokerCampaignLink;
import com.crm.qa.pages.BrokerCampaignPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.RegisterdBrokerPage;

public class brokercampaigntest extends TestBase {
	
	Loginpage lp;
	HomePage Hp;
	BrokerCampaignLink bcp;
	BrokerCampaignPage bcamp= new BrokerCampaignPage();

	public brokercampaigntest() throws IOException {
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
		
		bcp= new BrokerCampaignLink();
		
		bcp.BrkCamplink();
		
}

/*@Test(priority=1)
public void BrokerCamplinktest() throws IOException {
	
	bcp.BrkCamplink();
	
	System.out.println("opened broker camp page");
	
}*/
@Test(priority=2)
public void Brokercampaignsearchtest() {
	bcp.brokercampsearch(prop.getProperty("brokercampaignsearchtext"));
	
	
}




@AfterMethod

public void teardown() {
	
	System.out.print("after method");
	
	
	
	
	driver.quit();
}

}
