package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.Testutil;
import com.crm.qa.util.WebEventListener;

public class TestBase {


//page for locator
	public static WebDriver driver;
	public static Properties prop;
//public static void main(String[] args) throws IOException {
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public  TestBase() throws IOException {
	
		System.out.println("properties");
	 prop = new Properties();
	
	FileInputStream fp = new FileInputStream("/home/anupama/javaeclipse/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");

	prop.load(fp);
	
	}
	
	
	
	public static void initialization() throws IOException {
	
	System.out.println(prop.getProperty("browser"));
	String browsername = prop.getProperty("browser");
		
	if(browsername.equals("FF")) {
		System.setProperty("webdriver.gecko.driver","/home/anupama/Documents/geckodriver");
		driver = new FirefoxDriver();
	}
		else if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/home/anupama/Documents/chromedriver");
			driver = new ChromeDriver();
			
			
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
			
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(Testutil.pt,TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(Testutil.implicittime,TimeUnit.SECONDS);
			
			
			driver.get(prop.getProperty("url"));
			
		}
		
  }
}
