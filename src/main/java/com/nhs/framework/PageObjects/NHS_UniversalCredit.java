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
 * Description - Below NHS_UniversalCredit class is responsible to handle elements and actions in UniversalCredit page
 *
 */
public class NHS_UniversalCredit {
	private final Logger log = LoggerHelper.getLogger(NHS_UniversalCredit.class);
	private WebDriver driver;
	private CommonActions helperMethod;
	
	@FindBy(xpath="//h1[contains(text(),'paid Universal Credit')]")
	public WebElement universalCreditPageQuestionText;
	@FindBy(id="yes-universal")
	public WebElement yesUniversalBtn;
	@FindBy(id="not-yet")
	public WebElement notYetBtn;
	@FindBy(id="next-button")
	public WebElement nextBtn;
	@FindBy(id="different-benefit")
	public WebElement differentBenefitBtn;

	
	public NHS_UniversalCredit(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helperMethod=new CommonActions(driver);
	}
	public void verifyUniversalCreditPage()
	{
		helperMethod.waitForElementVisibility(driver, universalCreditPageQuestionText, BaseClass.propertyFileReader.getExplicitWait());
		helperMethod.waitForElementTillClickable(driver,nextBtn, BaseClass.propertyFileReader.getExplicitWait());
		log.info("Universal Credit page verified successfully");
	}
	public void selectResponse(String response)
	{
		if (response.contains(NHSConstants.YesUniversalCredit)) {
			yesUniversalBtn.click();
		} else if (response.contains(NHSConstants.NotYetApplied)) {
			notYetBtn.click();
		} else if (response.contains(NHSConstants.NoDifferentBenefit)) {
			differentBenefitBtn.click();
		}else {
			Assert.fail(response+" is not valid to proceed with");
		}
	}
	public void clicknextButton()
	{
		nextBtn.click();
		log.info("Successfully clicked on next button");
	}
}
