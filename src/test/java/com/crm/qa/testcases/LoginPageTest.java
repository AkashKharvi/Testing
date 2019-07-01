package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
//import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.LpstrDocument;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

public class LoginPageTest extends TestBase {
	
	
	 Loginpage lp;
	 
	 HomePage Hp;
	 String sheetnamae="Sheet2";
	
	public LoginPageTest() throws IOException {
		super(); //calling testbase class construtor // super class constructor so that properties also gets loaded
		
	}

	@BeforeMethod
	
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		System.out.println("end of before method"); 
		
		
		
		
			try {
				lp = new Loginpage();
			} catch (Exception e) {
								e.printStackTrace();
			}
		
			// TODO Auto-generated catch block
		
		
			System.out.println("edde");
		
		
		
			}
	
	
	@DataProvider

	public Object[][] getPosttestdata() throws IOException, Exception {
		
		Object data[][]=Testutil.getExcelData(sheetnamae);
		
		return data;
	}
	@Test(priority=1,dataProvider="getPosttestdata")
	
	public void logintesting(String username,String password ) throws Exception {
		
		lp.login(username, password);
		
		
	}
	
	
	/*@Test(priority=1)
	
	public void logintestcase() throws Exception{
		
		String title = lp.validatetitle();
		
		System.out.println(title);
		Assert.assertEquals(title, "LMeter Login");  //Assert is very imp

		System.out.println("priority 1");
	
	}
	
	
	@Test(priority=2)
	
	public void logotest() throws Exception
	{
		boolean flag=lp.validatelogo();
		Assert.assertTrue(flag);
		System.out.println("priority 2");
		
	}

	@Test(priority=3)
	
	public void logintest() throws Exception {
		
		Hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));  // ???
		
		System.out.println("priority 3");
		
	}*/
	
	@AfterMethod
	
	public void teardown() {
	System.out.print("after method");
		driver.quit();
	}
	
}
