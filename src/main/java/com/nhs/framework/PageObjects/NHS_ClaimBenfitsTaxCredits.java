package com.nhs.framework.PageObjects;

import org.apache.log4j.Logger;
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
 * Description - Below NHS_ClaimBenfitsTaxCredits class is responsible to handle elements and actions ClaimBenfitsTaxCredits page
 *
 */
public class NHS_ClaimBenfitsTaxCredits {
	private final Logger log = LoggerHelper.getLogger(NHS_ClaimBenfitsTaxCredits.class);
	private WebDriver driver;
	private CommonActions helperMethod;

	@FindBy(xpath="//span[contains(text(),'claim any benefits or tax credits')]")
	public WebElement claimBenfitTaxPageQuestionText;
	@FindBy(id="next-button")
	public WebElement nextBtn;
	@FindBy(id="radio-yes")
	public WebElement yesBtn;
	@FindBy(id="radio-no")
	public WebElement noBtn;
	
	public NHS_ClaimBenfitsTaxCredits(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helperMethod=new CommonActions(driver);
	}
	public void verifyClaimBenfitsTaxCreditsPage()
	{
		helperMethod.waitForElementVisibility(driver, claimBenfitTaxPageQuestionText, BaseClass.propertyFileReader.getExplicitWait());
		helperMethod.waitForElementTillClickable(driver,nextBtn, BaseClass.propertyFileReader.getExplicitWait());
		log.info("ClaimBenfitsTaxCredits page verified successfully");
	}
	public void selectResponse(String response)
	{
		if (response.equalsIgnoreCase(NHSConstants.Yes)) {
			yesBtn.click();
			log.info("Successfully clicked on Yes button");
		} else {
			noBtn.click();
			log.info("Successfully clicked on No button");
		}
	}
	public void clicknextButton()
	{
		nextBtn.click();
		log.info("Successfully clicked on next button");
	}

}
