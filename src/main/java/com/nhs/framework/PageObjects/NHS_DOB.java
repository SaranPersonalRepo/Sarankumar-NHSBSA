package com.nhs.framework.PageObjects;

import org.apache.log4j.Logger;
import org.junit.Assert;
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
 * Description - Below NHS_DOB class is responsible to handle elements and actions DOB page
 *
 */
public class NHS_DOB {
	private final Logger log = LoggerHelper.getLogger(NHS_DOB.class);
	private WebDriver driver;
	private CommonActions helperMethod;
	
	
	@FindBy(xpath="//h1[contains(text(),'What is your date of birth')]")
	public WebElement dobPageQuestionText;
	@FindBy(id="dob-day")
	public WebElement dayTextBox;
	@FindBy(id="dob-month")
	public WebElement monthTextBox;
	@FindBy(id="dob-year")
	public WebElement yearTextBox;
	@FindBy(id="next-button")
	public WebElement nextBtn;
	
	public NHS_DOB(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helperMethod=new CommonActions(driver);
	}
	public void verifyDOBPage()
	{
		helperMethod.waitForElementVisibility(driver, dobPageQuestionText, BaseClass.propertyFileReader.getExplicitWait());
		helperMethod.waitForElementTillClickable(driver,nextBtn, BaseClass.propertyFileReader.getExplicitWait());
		log.info("Date Of Birth page verified successfully");
	}
	public void enterDOB(String value)
	{
		String dob[]=value.split("-");
		if(dob.length==3)
		{	helperMethod.waitForElementTillClickable(driver, dayTextBox, BaseClass.propertyFileReader.getExplicitWait());
			dayTextBox.sendKeys(dob[0]);
			helperMethod.waitForElementTillClickable(driver, monthTextBox, BaseClass.propertyFileReader.getExplicitWait());
			monthTextBox.sendKeys(dob[1]);
			helperMethod.waitForElementTillClickable(driver, yearTextBox, BaseClass.propertyFileReader.getExplicitWait());
			yearTextBox.sendKeys(dob[2]);
			log.info("Date Of Birth value entered successfully");
		}else {
			Assert.fail(value + "given is incorrect");
		}
	}
	public void clicknextButton()
	{
		nextBtn.click();
		log.info("Successfully clicked on next button");
	}

}
