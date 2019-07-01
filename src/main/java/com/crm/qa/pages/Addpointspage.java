package com.crm.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;


public class Addpointspage extends TestBase {

	@FindBy(xpath = "(//span[contains(.,'Add Points')])[2]")
	WebElement Addpointstext;
	
	
	@FindBy(xpath = "//select[contains(@name,'utype')]")
	WebElement Addpointsuser;
	
	@FindBy(name ="isd_code")
	WebElement countcode;
	
	@FindBy(xpath = "//input[@valid='int']")
	WebElement mobilenmbr;
	
	@FindBy(xpath = "//input[contains(@name,'points')]")
	WebElement points;
	
	
	@FindBy(xpath = "//input[contains(@placeholder,'Remarks')]")
	WebElement Remark;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement Addptsbtn;
	
	public Addpointspage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
	
	}
	

	public void checkaddpointtext() throws Exception {
		
	
		
		if(driver.getPageSource().contains("Add Points"))
		{
		System.out.println("Add Points text is present");
		}
	    
		
		
		else
			{
			System.out.println("Add points text is not prsesent,refer screenshot");
		   Thread.sleep(5000);
		    Testutil.screenshot("Addpoints");
			}
	}

	public void addpointsuserselect() {
		
		Select s1 = new Select(Addpointsuser);
	s1.selectByVisibleText("User");
	
	}
	
	public void countrycode() throws InterruptedException {
		
		Select s2 = new Select(countcode);
		s2.selectByValue("+91");
		
		Thread.sleep(5000);
		System.out.println("ksjd");
		
		List<WebElement> elist = s2.getOptions();
		
		List<String> ccode=new  ArrayList<String>();
		for(int i=0;i<elist.size();i++)
		{
			String code=elist.get(i).getText();
			if(!ccode.contains(code))
			ccode.add(code);
			else {
				throw new InterruptedException();
			}
		}
	}
		public void mobilenumber()
		{
			
			mobilenmbr.sendKeys("7690711988");
		
		}
		
		
    public void addingpointsfunc(String userbroker,String ccvalue,String mobn,String pts,String remarkdesc)
    {
    	Select s1 = new Select(Addpointsuser);
    	s1.selectByVisibleText(userbroker);
    	
    	Select s2 = new Select(countcode);
		s2.selectByValue(ccvalue);
		
		mobilenmbr.sendKeys(mobn);
    	
		points.sendKeys(pts);
    	
		Remark.sendKeys(remarkdesc);
		
		Addptsbtn.click();
		
    }
		
    
		
		
		
    }


	

