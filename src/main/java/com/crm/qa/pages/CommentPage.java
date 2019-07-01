package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class CommentPage extends TestBase{

	
	@FindBy(xpath = "//input[contains(@type,'text')]")
	
	WebElement commentsearch;
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Search')]")
	
	WebElement  commentsearchbutton;
	
	@FindBy(xpath = "//select[contains(@name,'status')]")
	
	WebElement commentstatus;
	
	@FindBy(xpath = "//div[@class='not-found'][contains(.,'No record found.')]")
	
	WebElement norftext;
	
	public CommentPage() throws IOException {
		PageFactory.initElements(driver, this);
	
		
	}
	
	
	public void commentsearchfield(String csfieldtext) {
		WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		
		commentsearch.sendKeys(csfieldtext);
	}
	
	public void commentsearchbuttonclick() {
		commentsearchbutton.click();		
	}
	
	
	public void commentstatusclick() {

		WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		Select s1 = new Select(commentstatus);
				
		s1.selectByVisibleText("Not Approved");
		
	}
	
public void norecordfoundtext() {
	boolean text =driver.getPageSource().contains("No record found.");
	if(text==true)
	{
		System.out.println("no record found");
	}
}
	
	

}
