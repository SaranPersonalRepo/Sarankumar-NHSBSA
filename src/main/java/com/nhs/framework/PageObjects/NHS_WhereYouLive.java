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
 * Description - Below NHS_WhereYouLive class is responsible to handle elements and actions in WhereYouLive page
 *
 */
public class NHS_WhereYouLive {
	
	private final Logger log = LoggerHelper.getLogger(NHS_WhereYouLive.class);
	private WebDriver driver;
	private CommonActions helperMethod;
	
	@FindBy(id="radio-england")
	public WebElement radioBtnEngland;
	@FindBy(id="radio-scotland")
	public WebElement radioBtnScotland;
	@FindBy(id="radio-wales")
	public WebElement radioBtnWales;
	@FindBy(id="radio-nire")
	public WebElement radioBtnIreland;
	@FindBy(xpath="//h1[contains(text(),'Which country do you live in?')]")
	public WebElement WhereDoLivePageQuestionText;
	@FindBy(id="next-button")
	public WebElement nextBtn;
	
	public NHS_WhereYouLive(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		helperMethod=new CommonActions(driver);
	}
	public void verifyWhereYouLivePage()
	{
		helperMethod.waitForElementVisibility(driver, WhereDoLivePageQuestionText, BaseClass.propertyFileReader.getExplicitWait());
		helperMethod.waitForElementTillClickable(driver,nextBtn, BaseClass.propertyFileReader.getExplicitWait());
		log.info("Where do you live page verified successfully");
	}
	
	public void selectCountry(String country)
	{
		log.info("Given country is "+country);
		if (country.equalsIgnoreCase(NHSConstants.England)) {
			radioBtnEngland.click();
			log.info(country + " selected successfully.");
		} else if (country.equalsIgnoreCase(NHSConstants.Scotland)) {
			radioBtnScotland.click();
			log.info(country + " selected successfully.");
		} else if (country.equalsIgnoreCase(NHSConstants.Wales)) {
			radioBtnWales.click();
			log.info(country + " selected successfully.");
		} else if (country.equalsIgnoreCase(NHSConstants.Northern_Ireland)) {
			radioBtnIreland.click();
			log.info(country + " selected successfully.");
		} else {
			Assert.fail(country + "given does not matched");
		}
	}
	
	public void clicknextButton()
	{
		nextBtn.click();
		log.info("Successfully clicked on next button");
	}
}
