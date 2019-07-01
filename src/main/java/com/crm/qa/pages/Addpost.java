package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class Addpost  extends TestBase{

	
	@FindBy(name ="user_id")
	WebElement userbroker;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Title')]")
	
	WebElement posttitle;
	
	@FindBy(xpath = "(//select[contains(@name,'type')])[1]")
	
	WebElement posttypedropdown;
	
	@FindBy(xpath = "//input[contains(@name,'lat')]")
	WebElement LatValue;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Longitude')]")
	
	WebElement LongValue;
	
	@FindBy(xpath = "//select[contains(@name,'country_code')]")
	WebElement CountryName;
	
	@FindBy(xpath = "//select[contains(@name,'location_id')]")
	WebElement LocationName;

	@FindBy(xpath = "//select[contains(@name,'deal_type')]")
	WebElement Dealtypename;
	
	@FindBy(xpath = "//select[contains(@name,'sector')]")
	WebElement Industrytypename;
	
	@FindBy(xpath = "//select[@name='protype']")
	WebElement protypename;

	@FindBy(xpath = "//input[@placeholder='Price']")
	WebElement price1;
	@FindBy(xpath = "//input[contains(@name,'price_to')]")
	
	WebElement price2;
	
	@FindBy(xpath = "//textarea[contains(@id,'description')]")
	WebElement desc;
	
	@FindBy(xpath = "//button[@id='saveUploadImage']")
	
	WebElement savebutton;
	
	public Addpost() throws IOException {
		super();
		
PageFactory.initElements(driver, this);

	}
	
public void adduserbroker(String uname,String postname,String posttypename,String postlatvalue,String postlongvalue,
		String postcountryname,String postlocname,String postDealtypename,
		String postIndustrytypename,String postprotypename,String price1value ,String price2value,String postdesc) {
		
		driver.manage().timeouts().implicitlyWait(Testutil.implicittime, TimeUnit.SECONDS);
		
		System.out.println(uname);

		Select s1 = new Select(userbroker);
		
		
		s1.selectByValue("66");
	
		
		posttitle.sendKeys(postname);
		
		Select s2 = new Select(posttypedropdown);
		
s2.selectByVisibleText(posttypename);

LatValue.sendKeys(postlatvalue);

LongValue.sendKeys(postlongvalue);



Select s4 = new Select(CountryName);
s4.selectByValue(postcountryname);


Select s5 = new Select(LocationName);
s5.selectByVisibleText(postlocname);

Select s6 = new Select(Dealtypename);
s6.selectByVisibleText(postDealtypename);

Select s7 = new Select(Industrytypename);
s7.selectByVisibleText(postIndustrytypename);  

Select s8 = new Select(protypename);
s8.selectByVisibleText(postprotypename);
		
price1.sendKeys(price1value);

if(driver.findElement(By.xpath("//input[contains(@name,'price_to')]")).isDisplayed())
		{
	price2.sendKeys(price2value);
		}
else
{
System.out.println(price2value);	
}

desc.sendKeys(postdesc);
savebutton.click();
	 

 }

public String postitleverify(String Title) {
	driver.getPageSource().contains(Title);
	return Title;
}
}
	
	
	


