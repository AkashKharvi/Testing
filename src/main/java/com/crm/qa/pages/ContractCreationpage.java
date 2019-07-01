package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContractCreationpage extends TestBase {
	
	@FindBy(xpath = "//input[@name='field_name']")
	WebElement FieldName;
	
	@FindBy(xpath = "//input[@name='field_name_arabic']")
	WebElement arabicfieldname;
	
	@FindBy(xpath = "//select[@name='type']")
	WebElement DataType;
	
	@FindBy(xpath = "//input[contains(@name,'display_order')]")
	WebElement Displayorder;
	
	@FindBy(xpath = "//select[@name='status']")
	WebElement Status;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Save')]")
	WebElement Saveb;
	
	

	public ContractCreationpage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void contractFieldname(String Fn,String FnA,String DataT,String DO,String St) {
  	  
  	  FieldName.sendKeys(Fn);
  	  
   
  	  
  	  arabicfieldname.sendKeys(FnA);
  	  
 
  	  
  	  Select s1= new Select(DataType);
  	  
  	  s1.selectByVisibleText(DataT);
  	  
   
  	  
  	  Displayorder.sendKeys(DO);
   
  	  Select s2 = new Select(Status);
  	  s2.selectByVisibleText(St);
  	  
   
  	   Saveb.click();
	}  
  	   public String checkcontractcreation(String Fn) {
  		  driver.getPageSource().contains(Fn);
  		   
  		   return Fn;
  	   }
  	 public String conterrormessage() {
   	  
     	
   	String str=  driver.findElement(By.xpath("//div[@class='red'][contains(.,'This field name is already used')]")).getText();
   	  
   	  return str;
     }
  	 
  	


	
     
	

}
