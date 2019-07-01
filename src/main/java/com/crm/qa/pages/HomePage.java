package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath = "//a[contains(.,'Contracts')]")
	
	WebElement cntrct;
	
	@FindBy(xpath = "//span[@class='title'][contains(.,'Contract Fields')]")
	WebElement cntrctfield;
	
	
	@FindBy(xpath="//span[@class='color-black'][contains(.,'LMeter')]")
	WebElement pagename;
	
	@FindBy(xpath="(//a[contains(.,'System Users')])[1]")
	
	WebElement Systemusers;
	
	@FindBy(xpath="//span[@class='title'][contains(.,'List System Users')]")

	WebElement listsystemuser;
	
	@FindBy(xpath="//div[@class='desc'][contains(.,'Registered Brokers')]")
    WebElement Registeredbrokers;
	
	
	@FindBy(xpath="//div[@class='desc'][contains(.,'Total Published Listings')]")
	WebElement totalpublishedlistings;
	WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);
	
	
@FindBy(xpath = "(//a[@href='http://lmeter.loc/admin/post/lists'][contains(.,'Posts')])[1]")
	
	WebElement postlink;


@FindBy(xpath = "//span[@class='title'][contains(.,'Comments')]")

WebElement cmntclick;

@FindBy(xpath = "//span[@class='title'][contains(.,'Add Points')]")
WebElement Addpt;

	
	
	public HomePage() throws Exception{
		
		PageFactory.initElements(driver, this);
		
	}
//Actions
	
	public String verifyhomepagetitle() {
	
		return driver.getTitle();
	}
	
	public SystemUserspage clickonsystemusers() throws Exception {
		
		
		
		driver.manage().timeouts().implicitlyWait(Testutil.implicittime, TimeUnit.SECONDS);
		
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		 
		
		Systemusers.click();
		
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		
		listsystemuser.click();
		
		return new SystemUserspage();
		
	}
	
	public RegisterdBrokerPage clickonregisteredbroker() throws IOException {
		
		//WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);
		 waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		 
		Registeredbrokers.click();
		
		return new RegisterdBrokerPage();
	}
	
	public totalpublishedlistingspage clickontotalpublishedlistings() {
		
		
		 waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		
		totalpublishedlistings.click();
		
		return new totalpublishedlistingspage();
	}
	
	public PostPage Postpageclick() throws IOException
	{
		
		driver.manage().timeouts().implicitlyWait(Testutil.implicittime, TimeUnit.SECONDS);
		
		waitj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(.,'Posts')])[1]")));
		
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		postlink.click();
		
		return new PostPage();
		
	}	
	
	public void ContractPage() throws IOException {
		
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		cntrct.click();
		
		
			}

	
	public ContractFieldPage clickoncontractfield() throws IOException {
		
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
	cntrctfield.click();
	
	return new ContractFieldPage();
	
}

	public CommentPage CommentPageClick() throws IOException
	{
		
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		cmntclick.click();
		return new CommentPage();
	}
	
	
	public Addpointspage  Addpointsclick() throws IOException {
		
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
		Addpt.click();
		
		return new Addpointspage();
		
	}
 	
	
}