package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContractCreationpage;
import com.crm.qa.pages.ContractFieldPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class ContractFiledPagetest extends TestBase{
	
	HomePage Hp;
	Loginpage lp;
	ContractFieldPage cp = new ContractFieldPage();


	public ContractFiledPagetest() throws IOException {
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
		
		Hp.ContractPage();
		

}

@Test(priority=1)

public void contractaddbuttontest() throws IOException {
	
	Hp.clickoncontractfield();
	
}
	
	
	
@AfterMethod
	
public void teardown() {

	System.out.print("after method");
driver.quit();
		
	
 }
}
