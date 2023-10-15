package com.nhs.framework.configReader;

import java.io.FileInputStream;
import java.util.Properties;

import com.nhs.framework.reusableComponents.NHSConstants;


/***
 * 
 * @author Sarankumar
 * Description - Below class is responsible to read data from Property File configuration.properties
 *
 */
public class PropertyFileReader {

	private Properties prop = null;
	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(NHSConstants.configPropertyFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return prop.getProperty(NHSConstants.NHS_URL);
	}
	public String getBrowserType() {
		return prop.getProperty(NHSConstants.Browser);
	}
	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty(NHSConstants.PageLoadTimeOut));
	}
	public int getImplcitWait() {
		return Integer.parseInt(prop.getProperty(NHSConstants.ImplcitWait));
	}
	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty(NHSConstants.ExplicitWait));
	}
}
