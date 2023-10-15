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
import com.nhs.framework.reusableComponents.NHSConstants;
/***
 * 
 * @author Sarankumar
 * Description - Below NHS_Benefits class is responsible to handle elements and actions Benifits page
 *
 */
public class NHS_Benefits {
	private final Logger log = LoggerHelper.getLogger(NHS_Benefits.class);
	private WebDriver driver;
	private CommonActions helperMethod;
	
	@FindBy(xpath="//span[contains(text(),'any of these benefits')]")
	public WebElement benfitsPageQuestionText;
	@FindBy(id="taxCredit")
	public WebElement taxCreditCheckBox;
	@FindBy(id="incSupport")
	public WebElement incSupportCheckBox;
	@FindBy(id="esa")
	public WebElement esaCheckBox;
	@FindBy(id="jsa")
	public WebElement jsaCheckBox;
	@FindBy(id="penCredit")
	public WebElement penCreditCheckBox;
	@FindBy(id="noneOption")
	public WebElement noneOptionCheckBox;
	@FindBy(id="next-button")
	public WebElement nextBtn;
	
	public NHS_Benefits(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helperMethod=new CommonActions(driver);
	}
	public void verifyBenefitsPage()
	{
		helperMethod.waitForElementVisibility(driver, benfitsPageQuestionText, BaseClass.propertyFileReader.getExplicitWait());
		helperMethod.waitForElementTillClickable(driver,nextBtn, BaseClass.propertyFileReader.getExplicitWait());
		log.info("Benefits page verified successfully");
	}
	public void selectResponse(String response) {
		String resData[]=response.split(";");
		for(int i=0;i<resData.length;i++)
		{
			if (resData[i].equalsIgnoreCase(NHSConstants.TaxCredits)) {
				taxCreditCheckBox.click();
			} else if (resData[i].equalsIgnoreCase(NHSConstants.Income_Support)) {
				incSupportCheckBox.click();
			} else if (resData[i].equalsIgnoreCase(NHSConstants.ESA)) {
				esaCheckBox.click();
			} else if (resData[i].equalsIgnoreCase(NHSConstants.JSA)) {
				jsaCheckBox.click();
			} else if (resData[i].equalsIgnoreCase(NHSConstants.Pension_Credit)) {
				penCreditCheckBox.click();
			} else if (resData[i].equalsIgnoreCase(NHSConstants.NoneOption)) {
				noneOptionCheckBox.click();
			} else {
				Assert.fail(response + " is not valid option to select");
			}
		}
		
	}
	public void clicknextButton()
	{
		nextBtn.click();
		log.info("Successfully clicked on next button");
	}

}
