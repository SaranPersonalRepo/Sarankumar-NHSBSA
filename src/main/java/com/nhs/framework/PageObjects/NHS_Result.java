package com.nhs.framework.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhs.framework.helper.BaseClass;
import com.nhs.framework.helper.LoggerHelper;
import com.nhs.framework.reusableComponents.CommonActions;
/***
 * 
 * @author Sarankumar
 * Description - Below NHS_Result class is responsible to verify result in application
 *
 */
public class NHS_Result {
	private final Logger log = LoggerHelper.getLogger(NHS_Result.class);
	private WebDriver driver;
	private CommonActions helperMethod;
	

	@FindBy(xpath="//*[contains(text(),\"Based on what you've told us\")]")
	public WebElement resultPageSuccessMsgText;
	
	public NHS_Result(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helperMethod=new CommonActions(driver);
	}
	
	public void verifyResultPage()
	{
		helperMethod.waitForElementVisibility(driver, resultPageSuccessMsgText, BaseClass.propertyFileReader.getExplicitWait());
		log.info("Result page verified successfully");
	}

}
