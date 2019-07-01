package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase{
	
	//pagefactory //OR
	
	
	@FindBy(name="username")
	WebElement usrname;
	
	
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//button[contains(@type,'submit')]")
	WebElement loginbutton;
	
	@FindBy(xpath="//img[@src='http://lmeter.loc/theme/img/lmeter-logo.png']")

	WebElement logo;
	
	public Loginpage() throws Exception{
		

		PageFactory.initElements(driver, this); //this is to intitialze elements  init means initialize elements
		
	}
	
	//Actions
	public String validatetitle()  {
		
		
		System.out.println("validate title");
		
return driver.getTitle();

	}
	
	public boolean validatelogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pd ) throws Exception {
		usrname.sendKeys(un);
		pwd.sendKeys(pd);
		loginbutton.click();
		
		return new HomePage();
		
	}
	

}
