package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class AddCampaginpopup extends TestBase{

	public AddCampaginpopup() throws IOException {
		super();
		
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath = "//input[@ng-model='campaigndata.title']")
   WebElement cmpname;
	
	@FindBy(xpath = "//select[contains(@ng-model,'campaigndata.country_id')]")
	WebElement brkcmpcountry;
	
	@FindBy(xpath = "//select[contains(@ng-model,'campaigndata.location_id')]")
	WebElement brklocation;
	
	@FindBy(xpath = "//select[contains(@ng-model,'campaigndata.deal_type')]")
	WebElement brkcmpdealtype;
	
	@FindBy(xpath = "//select[contains(@name,'sector')]")
	WebElement brkindtype;
	
	@FindBy(xpath = "//select[contains(@name,'pro_type')]")
	WebElement brkproptype;
	
	@FindBy(xpath = "//input[@id='enddate']")
	WebElement brkenddate;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Submit')]")
	WebElement brkcampsubmit;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Cancel')]")
	WebElement brkcancel;
	
	
	
	
	
	
	public void campaignname(String brkcmpname) {
		
		WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

		 waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		
		cmpname.sendKeys(brkcmpname);
	}
	
	public void brokercampcountry(String brkcampcountryname) {
		
		WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

		 waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		
		Select s1 = new Select(brkcmpcountry);
		s1.selectByVisibleText(brkcampcountryname);
	}
	
	public void brokercamplocation(String brklocationname) {
		WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

		 waitj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@ng-model,'campaigndata.location_id')]")));
		
		Select s1= new Select(brklocation);
		s1.selectByVisibleText(brklocationname);
		
	}
	
	
	public void brokercampdealtype(String dealtypename)
	{
		
		WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

		 waitj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@ng-model,'campaigndata.deal_type')]")));
		Select s1= new Select(brkcmpdealtype);
		s1.selectByVisibleText(dealtypename);
		
	}
	public void brokercamppropertytype(String propertytypename) {
		
		WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

		 waitj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@name,'pro_type')]")));
		
		Select s1= new Select(brkproptype);
		s1.selectByVisibleText(propertytypename);
		
		
		
	}
	
public void brokercampindustrytype(String industrytypename) {
	WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

	 waitj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@name,'sector')]")));
		
		Select s1= new Select(brkindtype);
		s1.selectByVisibleText(industrytypename);
	
}
	
	
	public void campaignenddate() {
		driver.manage().timeouts().implicitlyWait(Testutil.implicittime, TimeUnit.SECONDS);
		brkenddate.sendKeys("30 Oct 2019");
	}
	
	
	public void brkcampclose() {
		
		brkcampsubmit.click();
	}
	public void brkcampcancel()
	{
		brkcancel.click();
	}
	
	

}
