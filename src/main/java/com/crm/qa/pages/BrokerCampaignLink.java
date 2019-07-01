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

public class BrokerCampaignLink extends TestBase {
	
	
	
	
	
	public BrokerCampaignLink() throws IOException {
		
	PageFactory.initElements(driver, this);
	
	}


	@FindBy(xpath = "//span[@class='title'][contains(.,'Broker Campaign')]")
	WebElement BrkCmpn;
	
	
	@FindBy(xpath="//input[@ng-model='searchCampaign']")
	WebElement  brkcmpsrch;
	
	
	
	
	
	public BrokerCampaignPage BrkCamplink() throws IOException {
		
		WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

		 waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		BrkCmpn.click();
		
		return new BrokerCampaignPage();
		
	}
	
	public void brokercampsearch(String brokercampsearchtext) {
		
	
	brkcmpsrch.sendKeys(brokercampsearchtext);
	}
	
	
	
	
	
}
