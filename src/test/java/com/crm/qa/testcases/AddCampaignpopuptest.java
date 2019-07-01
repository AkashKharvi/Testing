package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddCampaginpopup;
import com.crm.qa.pages.BrokerCampaignLink;
import com.crm.qa.pages.BrokerCampaignPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;


public class AddCampaignpopuptest  extends TestBase{
	
	
	Loginpage lp;
	HomePage Hp;
	BrokerCampaignLink bcp;
	BrokerCampaignPage bcamp= new BrokerCampaignPage();
	AddCampaginpopup acp = new AddCampaginpopup();

	public AddCampaignpopuptest() throws IOException {
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
		
		acp=bcamp.AddCampbutton();
	
}


@Test(priority=4)

public void campaignnametexttest() {
	acp.campaignname(prop.getProperty("brokercampaignname"));
	acp.brkcampclose();
	
	
}

@Test(priority=5)
public void brokercampcountrytest() {
	acp.brokercampcountry(prop.getProperty("brokercampaigncountry"));
	acp.brkcampclose();
	
}	
	
@Test(priority=6)
public void brokercamplocationtest() {
	acp.brokercampcountry(prop.getProperty("brokercampaigncountry"));
	
	acp.brokercamplocation(prop.getProperty("brokercampaignlocation"));	
	acp.brkcampclose();
}

@Test(priority=7)
public void brokercampldealtypetest() {
	acp.brokercampcountry(prop.getProperty("brokercampaigncountry"));
	acp.brokercamplocation(prop.getProperty("brokercampaignlocation"));	
	acp.brokercampdealtype(prop.getProperty("brokercampaigndealtype"));
	acp.brkcampclose();
	
}

@Test(priority=8)
public void brokercampindustrytypetest() {
	acp.brokercampcountry(prop.getProperty("brokercampaigncountry"));
	acp.brokercamplocation(prop.getProperty("brokercampaignlocation"));	
	acp.brokercampdealtype(prop.getProperty("brokercampaigndealtype"));
acp.brokercampindustrytype(prop.getProperty("brokercampindustrytype"));
acp.brkcampclose();


}


@Test(priority=9)
public void brokercamppropertytypetest() {
	acp.brokercampcountry(prop.getProperty("brokercampaigncountry"));
	acp.brokercamplocation(prop.getProperty("brokercampaignlocation"));	
	acp.brokercampdealtype(prop.getProperty("brokercampaigndealtype"));
acp.brokercampindustrytype(prop.getProperty("brokercampindustrytype"));
	acp.brokercamppropertytype(prop.getProperty("brokercamppropertytype"));
	
	acp.brkcampclose();	
	
}


@Test(priority=10)	
public void brokerenddate() {
	acp.campaignname(prop.getProperty("brokercampaignname"));
	acp.brokercampcountry(prop.getProperty("brokercampaigncountry"));
	acp.brokercamplocation(prop.getProperty("brokercampaignlocation"));	
	acp.brokercampdealtype(prop.getProperty("brokercampaigndealtype"));
acp.brokercampindustrytype(prop.getProperty("brokercampindustrytype"));
	acp.brokercamppropertytype(prop.getProperty("brokercamppropertytype"));
	acp.campaignenddate();
	
	acp.brkcampclose();
}


@Test(priority=11)

public void brokercancelbuttontest() {
	acp.brkcampcancel();
}


@AfterMethod

public void teardown() {
	
	driver.quit();
}




}
