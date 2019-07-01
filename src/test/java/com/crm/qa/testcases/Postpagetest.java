package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Addpost;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.PostPage;
import com.crm.qa.pages.RegisterdBrokerPage;
import com.crm.qa.pages.SystemUserspage;
import com.crm.qa.pages.totalpublishedlistingspage;
import com.crm.qa.util.Testutil;

public class Postpagetest extends TestBase{

	Loginpage lp;
	HomePage Hp;
	
	SystemUserspage su;
	
	totalpublishedlistingspage tpl;
	RegisterdBrokerPage rb;
	PostPage pp;
	Addpost addp = new Addpost();
	String sheetnamae="Sheet1";
	

	
	
	
	public Postpagetest() throws IOException {
		super();
		}
	
@BeforeMethod
	
	public void setup() throws Exception 
	{
		initialization();
		System.out.println("end of before method"); 
		
		
		
		
			try {
				lp = new Loginpage();
			} catch (Exception e) {
								e.printStackTrace();
			}	
			Hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
			pp=Hp.Postpageclick();
			
			addp=pp.addpost();
			
	}

/*
@Test(priority=1)

public void clickonposttest() throws IOException {
	System.out.println("pp");
	pp=Hp.Postpageclick();
	System.out.println(pp);
	
}*/





@DataProvider

public Object[][] getPosttestdata() throws IOException, Exception {
	
	Object data[][]=Testutil.getExcelData(sheetnamae);
	
	return data;
}




@Test(priority=1,dataProvider="getPosttestdata")

public void creatingposttest(String Userb,String Title,String Posttype,String Lat,String Long,String Country,String Location,String DealType,String IndustryType,String PropertyType,String Price1,String Price2,String Description
 ) throws IOException {

	addp.adduserbroker(Userb, Title, Posttype, Lat, Long, Country, Location, DealType, IndustryType, PropertyType, Price1,Price2, Description);

	Hp.Postpageclick();
	
	driver.manage().timeouts().implicitlyWait(Testutil.implicittime,TimeUnit.SECONDS);
	
	String verifytitle=addp.postitleverify(Title);
	
	Assert.assertEquals(verifytitle,Title,"Post is created");
	
	
	
}




@AfterMethod

public void teardown() throws InterruptedException {
	
	System.out.println("after method");
	
	
	    driver.quit();
	   
	   
	    
	
	
}
}
