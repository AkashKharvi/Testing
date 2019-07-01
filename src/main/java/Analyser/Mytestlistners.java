package Analyser;

import org.testng.ITestResult;

public class Mytestlistners {
	
	int count=0;
	int verify=3;
	
	
	public boolean retry(ITestResult result) {
		
		if(count<verify)
		{
			count++;
			
			return true;
			
		}
		else 
			return false;
		
 }
}
