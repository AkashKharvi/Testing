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

public class PostPage extends TestBase{
	
	
	@FindBy(xpath = "//a[@href='http://lmeter.loc/admin/post/add'][contains(.,'Add New')]")
	WebElement addnew;

	WebDriverWait waitj = new WebDriverWait(driver, Testutil.explixittime);
	
	public PostPage() throws IOException {
		super();
		
	PageFactory.initElements(driver, this);
	
	}
	
	
	public Addpost addpost() throws IOException {
		
		waitj.until(ExpectedConditions.invisibilityOfElementLocated(By.className("pre-loader")));	
		
     WebElement el=driver.findElement(By.xpath("//a[@href='http://lmeter.loc/admin/post/add'][contains(.,'Add New')]"));
     el.click();
     
     return new Addpost();
	}
	
	


}
