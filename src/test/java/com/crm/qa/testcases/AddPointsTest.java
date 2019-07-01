package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Addpointspage;
import com.crm.qa.pages.BrokerCampaignLink;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

public class AddPointsTest extends TestBase {

	

	Loginpage lp;
	HomePage Hp;
	BrokerCampaignLink bcp;
	String sheetnamae ="Sheet4";
	 Addpointspage Ap;
	 public AddPointsTest() throws IOException {
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

        Ap = new Addpointspage();	
 	
        Hp.Addpointsclick();
   }

 
@Test(priority=1)

public void addpointspagecreatetest() throws Exception {
	
	Ap.checkaddpointtext();
}

@Test(priority=2)
public void addpointsuserselecttest() throws InterruptedException {
	Ap.addpointsuserselect();
	Ap.countrycode();
	
}

@DataProvider

public Object[][] getPosttestdata() throws IOException, Exception {
	
	
	Object data[][]=Testutil.getExcelData(sheetnamae);
	
	return data;
}




@Test(priority=3,dataProvider="getPosttestdata")

	public void addingpointstest(String Addpointsfor,String CountryCode, String MobileNo, String Noofpoints,String Remarks)
	{
	
	Ap.addingpointsfunc(Addpointsfor, CountryCode, MobileNo, Noofpoints, Remarks);
	
	
	
	}
	




@AfterMethod

public void teardown() {
	
	System.out.print("after method");
	
	
	
	
	driver.quit();
  }	
	
	
}
