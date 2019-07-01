package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.crm.qa.base.TestBase;



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

	public class RegisterdBrokerPage extends TestBase{
		
		
		@FindBy(xpath="//input[contains(@type,'text')]")
		WebElement brokersearch;
		
		
		@FindBy(xpath = "//select[contains(@name,'country_code')]") 
				WebElement brokercountry;
		
		@FindBy(xpath="//button[contains(@type,'submit')]")
		WebElement bsbutton;
		
		
		

		public RegisterdBrokerPage() throws IOException {
			
			super();
			PageFactory.initElements(driver,this);
			
		}
		
		public void brokersearchfield(String brokername) throws InterruptedException {
			
			
			WebDriverWait waitu = new WebDriverWait(driver, Testutil.explixittime);

			 waitu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@type,'text')]")));
			
			 Thread.sleep(5000);
			 
			brokersearch.sendKeys(brokername);
			
			WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

			 waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
			 
			bsbutton.click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public void countrydropdown(String brokercountryname)
		{
			WebDriverWait waitu = new WebDriverWait(driver, Testutil.explixittime);

			 waitu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='country_code']")));
			
			Select s1 = new Select(brokercountry);

			s1.selectByVisibleText(brokercountryname); 
		}
		
		
		public void brokersearchbutton() {
			
			 WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);

			 waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));
			 
			bsbutton.click();
			
			
		}
		
		
		
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

