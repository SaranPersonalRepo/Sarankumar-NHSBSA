package com.nhs.framework.PageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nhs.framework.helper.LoggerHelper;
import com.nhs.framework.reusableComponents.CommonActions;

/***
 * 
 * @author Sarankumar
 * Description - Below NHS_PageLevelError class is responsible to handle page level error message in applicable
 */
public class NHS_PageLevelError {
	
	private final Logger log = LoggerHelper.getLogger(NHS_PageLevelError.class);
	private WebDriver driver;
	private CommonActions helperMethod;

	
	@FindBy(xpath="//*[@id='error-summary-heading']/following::ul[1]/li/a/span")
	public WebElement errorMsgText;
	@FindBy(id="error-summary-heading")
	public WebElement errorSummaryLabel;
	
	public NHS_PageLevelError(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helperMethod=new CommonActions(driver);
	}
	public void verifyErrorsInPage(String pageName)
	{
		if(helperMethod.isDisplayed(driver, errorSummaryLabel, 1)) {
			helperMethod.waitForElementVisibility(driver, errorMsgText, 1);
			log.info(pageName+" page has following error message "+errorMsgText.getText());
			Assert.fail(pageName+" page has following error message "+errorMsgText.getText());
			
		}
	}
}
