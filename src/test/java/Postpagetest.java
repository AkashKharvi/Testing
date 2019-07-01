import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddCampaginpopup;
import com.crm.qa.pages.BrokerCampaignLink;
import com.crm.qa.pages.BrokerCampaignPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class Postpagetest extends TestBase {
	Loginpage lp;
	HomePage Hp;
	BrokerCampaignLink bcp;
	BrokerCampaignPage bcamp= new BrokerCampaignPage();
	AddCampaginpopup acp = new AddCampaginpopup();

	public Postpagetest() throws IOException {
		super();
		
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
		
		
		
		
		
	
}
	
@Test
public void postlinktest() throws IOException {
	Hp.Postpageclick();
	
	
}
	
	
@AfterMethod

public void teardown() {
	
	driver.quit();
}	

}
