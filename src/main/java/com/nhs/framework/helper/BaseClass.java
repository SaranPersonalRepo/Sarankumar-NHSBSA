package com.nhs.framework.helper;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.nhs.framework.configReader.PropertyFileReader;
import com.nhs.framework.reusableComponents.CommonActions;
import com.nhs.framework.reusableComponents.NHSConstants;

import io.github.bonigarcia.wdm.WebDriverManager;
/***
 * 
 * @author Sarankumar
 * Description - Below Baseclass is responsible to initiate browser
 *
 */
public class BaseClass {
	public static WebDriver driver;
	public static PropertyFileReader propertyFileReader;
	private final Logger log = LoggerHelper.getLogger(BaseClass.class);

	public BaseClass(){
		propertyFileReader=new PropertyFileReader();
	}
	public WebDriver getBrowserObject(String browserType) throws Exception {
		switch (browserType) {
		case NHSConstants.Chrome: {
			ChromeOptions chromeOpt = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			return driver = new ChromeDriver(chromeOpt);
		}
		case NHSConstants.Edge: {
			EdgeOptions edgeOpt = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			return driver = new EdgeDriver(edgeOpt);
		}
		default:
			throw new Exception("Driver not found for browser "+browserType);
		}
	}
	
	public void setUpDriver(String browserType) throws Exception
	{
		this.getBrowserObject(browserType);
		driver.manage().timeouts().pageLoadTimeout(new PropertyFileReader().getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("Browser Launched Successfully");
	}
	public void initializeDriver() throws Exception
	{
		this.setUpDriver(propertyFileReader.getBrowserType());
	}
	/*
	 * @Before() public void before() throws Exception { propertyFileReader=new
	 * PropertyFileReader(); this.setUpDriver(propertyFileReader.getBrowserType());
	 * }
	 */
}
