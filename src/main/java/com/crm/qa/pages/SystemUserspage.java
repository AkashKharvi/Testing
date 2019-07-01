package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class SystemUserspage extends TestBase{
	
	/*@FindBy(xpath="//input[contains(@type,'text')]")
	
	WebElement searchfield;*/
	
	@FindBy(xpath="//button[@type='submit'][contains(.,'Search')]")
	
	WebElement searchbutton;
	
	
public SystemUserspage() throws Exception{
		
PageFactory.initElements(driver, this);
		
		
	}


//Actions



public void systemusersearch(String name) {
	
	
	WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);
	
	driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(name);
	
}

public void searchbuttonclick() {
	
	WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);
	
	waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));

	
	searchbutton.click();
	
}
}
