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
 * Description - Below NHS_Start class is responsible to handle elements and actions Start page
 *
 */
public class NHS_Start {
	private final Logger log = LoggerHelper.getLogger(NHS_Start.class);
	private WebDriver driver;
	private CommonActions helperMethod;
	
	@FindBy(id="next-button")
	public WebElement startNowButton;
	@FindBy(xpath="//h2[text()='Check what help you could get to pay for NHS costs']")
	public WebElement startPageHeaderText;
	
	
	public NHS_Start(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helperMethod=new CommonActions(driver);
	}
	public void verifyStartPage()
	{
		helperMethod.waitForElementVisibility(driver, startPageHeaderText, BaseClass.propertyFileReader.getExplicitWait());
		helperMethod.waitForElementTillClickable(driver,startNowButton, BaseClass.propertyFileReader.getExplicitWait());
		log.info("NHS Start page verified successfully");
	}
	public void clickStartNowButton()
	{
		startNowButton.click();
		log.info("Successfully clicked on startNowButton");
	}
}
