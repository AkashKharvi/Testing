package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContractCreationpage;
import com.crm.qa.pages.ContractFieldPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Testutil;

public class Addcontracttest extends TestBase{
	HomePage Hp;
	Loginpage lp;
	
	ContractCreationpage ccp = new ContractCreationpage();
	
	ContractFieldPage cp  = new ContractFieldPage();
	String sheetname ="Sheet3";

	public Addcontracttest() throws IOException {
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
			Hp.ContractPage();
			Hp.clickoncontractfield();
			System.out.println(Hp);
			
			System.out.println(ccp);
			
			ccp=cp.Addnewcontractbutton();
			
	
	}
	@DataProvider
	public Object[][] getPosttestdata() throws IOException, Exception {
		
		Object data[][]=Testutil.getExcelData(sheetname);
		
		return data;
	}
	
	@Test(priority=1,dataProvider="getPosttestdata")
	
	public void fieldnametest(String FieldName,String FnArabic,String DataType,String DisplayOrder,String Status) {
		
	ccp.contractFieldname(FieldName,FnArabic, DataType,DisplayOrder,Status);
	
	/*String abc = ccp.checkcontractcreation(FieldName);
	
	Assert.assertEquals(abc,FieldName,"Contract not created");*/
	
String str=	ccp.conterrormessage();

String accpectederror="This field name is already used";

AssertJUnit.assertEquals(str, accpectederror);

AssertJUnit.assertTrue(str.contains("This field name is already used"));

}
	
	
@AfterMethod

public void teardown() {
	
	driver.quit();
	
   }
}
