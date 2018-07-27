package au.com.beutii.testframework.cucumber;

/**
 * Hardcoded configuration file. Can be modified to read configuration from file/environment vars in the future.
 * Should be created once for each feature file (defined historically).
 * @author JTR
 *
 */
public class Configuration {
	public String getBaseURL(){
		//SIT 
		//return "https://sit-hcf.adobecqms.net";
		
		//UAT
		//return "http://dispatcher1.uat.aem.hcf.com.au";
			 
	//	return "https://dev-hcf.adobecqms.net";
//		return "https://www.uat2.hcf.com.au";
	//	return "https://www.test2.hcf.com.au";
	//	return "https://www.hcf.com.au";
	//	 return "http://dispatcher2.prod.aem.hcf.com.au";
	//	return "http://dispatcher1.uat63.aem.hcf.com.au";
	//	return "http://dispatcher2.prod63.aem.hcf.com.au";
	//	return "https://hcf-prod63-01.adobecqms.net";
		return "https://www.amazon.com";
	}
	
	public String getMicrositeURL(){
		//SIT 	
	//	return "http://www.bunnings.test2.hcf.com.au";
	//	return "http://finder.test2.hcf.com.au/";	
		
		//UAT
		return "http://www.bunnings.uat2.hcf.com.au";		
		
	//	return "http://www.bunnings.hcf.com.au";
		
	
	}
	
	public String getBrowserName(){
		
		return "chrome";
	//	return "firefox";
	}

	/**
	 * 
	 * @return
	 */
	public String getWDS() {
		return "http://localhost:4444/wd/hub";
	}
}
