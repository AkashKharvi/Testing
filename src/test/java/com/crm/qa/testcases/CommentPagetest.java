package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CommentPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class CommentPagetest extends TestBase{
	
	
	Loginpage lp;
	HomePage Hp;
	CommentPage cmt;
	public CommentPagetest() throws IOException {
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
			 cmt = new CommentPage();
			cmt =Hp.CommentPageClick();
			
		
			
		}
	
	
@Test(priority=1)

	public void cmtsearchfieldtest()
	{
		 cmt.commentsearchfield(prop.getProperty("commentsearchtext"));
		 cmt.commentsearchbuttonclick();
		
	}

@Test(priority=2)
public void cmtstatustest()
{
cmt.commentstatusclick();
cmt.commentsearchbuttonclick();
cmt.norecordfoundtext();


}




@AfterMethod

public void teardown() {
	
	System.out.println("after method");
	driver.quit();
}

}
