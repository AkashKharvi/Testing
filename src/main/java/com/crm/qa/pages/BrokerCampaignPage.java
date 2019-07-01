package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class BrokerCampaignPage  extends TestBase{
	/*@FindBy(xpath = "//button[@type='button'][contains(.,'Add Campaign')]")
	WebElement addcmp;*/

	public BrokerCampaignPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
		
	}





public AddCampaginpopup AddCampbutton() throws IOException
{
	
	WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

	 waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));	
	
	//addcmp.click();	
	 WebElement ele=driver.findElement(By.xpath("//button[@type='button'][contains(.,'Add Campaign')]"));
	 
	 System.out.println(ele.toString());
	 ele.click();
	 
	return new AddCampaginpopup();
}
}

