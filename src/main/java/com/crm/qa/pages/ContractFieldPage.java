package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class ContractFieldPage extends TestBase {
	
	@FindBy(xpath = "//a[@href='javascript:;;'][contains(.,'Add New')]")
	WebElement addnewcon;
	
	
	
	
	
	
	    public ContractFieldPage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
		
		
	}

      public ContractCreationpage Addnewcontractbutton() throws IOException {
	
    	  WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

			 waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
			 
    	  addnewcon.click();
    	  
      return new ContractCreationpage();
      
    }
      
     
      
      
	
}
