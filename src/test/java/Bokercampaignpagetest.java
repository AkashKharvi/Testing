import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BrokerCampaignLink;
import com.crm.qa.pages.BrokerCampaignPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class Bokercampaignpagetest extends TestBase {
	
	Loginpage lp;
	HomePage Hp;
	BrokerCampaignLink bcp;
	BrokerCampaignPage bcamp= new BrokerCampaignPage();


	public Bokercampaignpagetest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



@BeforeMethod
public void setup() throws Exception {
	initialization();
	
	try {
			lp = new Loginpage();
		} catch (Exception e) {
							e.printStackTrace();
		}
	
	 

	Hp =lp.login(prop.getProperty("username"),prop.getProperty("password"));
	
	Hp.clickonregisteredbroker();
	
	bcp= new BrokerCampaignLink();
	
	bcp.BrkCamplink();
	
}
@Test

public void Brkaddcmpbuttontest() throws IOException {
	
	
	
	bcamp.AddCampbutton();
	
}











@AfterMethod

public void teardown() {
	
	driver.quit();
}






}