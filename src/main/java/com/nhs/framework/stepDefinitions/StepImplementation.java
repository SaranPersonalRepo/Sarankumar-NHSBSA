package com.nhs.framework.stepDefinitions;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.nhs.framework.PageObjects.NHS_Benefits;
import com.nhs.framework.PageObjects.NHS_ClaimBenfitsTaxCredits;
import com.nhs.framework.PageObjects.NHS_DOB;
import com.nhs.framework.PageObjects.NHS_DentalPracticeCountry;
import com.nhs.framework.PageObjects.NHS_GPPractice;
import com.nhs.framework.PageObjects.NHS_PageLevelError;
import com.nhs.framework.PageObjects.NHS_Partner;
import com.nhs.framework.PageObjects.NHS_Result;
import com.nhs.framework.PageObjects.NHS_Start;
import com.nhs.framework.PageObjects.NHS_UniversalCredit;
import com.nhs.framework.PageObjects.NHS_WhereYouLive;
import com.nhs.framework.helper.BaseClass;
import com.nhs.framework.helper.LoggerHelper;
import com.nhs.framework.reusableComponents.CommonActions;
import com.nhs.framework.reusableComponents.NHSConstants;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/***
 * 
 * @author Sarankumar
 * Description - Implementation for feature file steps are handled in this class StepImplementation
 *
 */
public class StepImplementation {

	BaseClass baseClass=new BaseClass();
	NHS_PageLevelError pageError;
	private final Logger log = LoggerHelper.getLogger(StepImplementation.class);
	@Given("^user navigate to NHS application$")
	public void userNavigateToApplication() throws Exception
	{
		baseClass.initializeDriver();
		BaseClass.driver.get(BaseClass.propertyFileReader.getUrl());
		log.info("Navigated to application "+BaseClass.driver.getCurrentUrl());
	}
	
	@When("^user (.+) \"([^\"]*)\" (.+) in (.+) Page$")
	public void userActionOnPage(String actionOnPage, String valueOrElement, String elementType,String page) throws Exception
	{
		switch(page) {
		case NHSConstants.NHS_Start:
		{
			NHS_Start startPage=new NHS_Start(BaseClass.driver);
			pageError=new NHS_PageLevelError(BaseClass.driver);
			startPage.verifyStartPage();
			startPage.clickStartNowButton();
			pageError.verifyErrorsInPage(page);
			break;
		}
		case NHSConstants.NHS_WhereYouLive:{
			NHS_WhereYouLive whereYouLivePage=new NHS_WhereYouLive(BaseClass.driver);
			whereYouLivePage.verifyWhereYouLivePage();
			whereYouLivePage.selectCountry(valueOrElement);
			whereYouLivePage.clicknextButton();
			pageError.verifyErrorsInPage(page);
			break;
		}
		case NHSConstants.NHS_GPPractice:{
			NHS_GPPractice gpPracticePage=new NHS_GPPractice(BaseClass.driver);
			gpPracticePage.verifyGPPracticePage();
			gpPracticePage.selectResponse(valueOrElement);
			gpPracticePage.clicknextButton();
			pageError.verifyErrorsInPage(page);
			break;
		}
		case NHSConstants.NHS_DentalPracticeCountry:{
			NHS_DentalPracticeCountry dentalPrac=new NHS_DentalPracticeCountry(BaseClass.driver);
			dentalPrac.verifyDentalPracticePage();
			dentalPrac.selectCountry(valueOrElement);
			dentalPrac.clicknextButton();
			pageError.verifyErrorsInPage(page);
			break;
		}case NHSConstants.NHS_DOB:{
			NHS_DOB dobPage= new NHS_DOB(BaseClass.driver);
			dobPage.verifyDOBPage();
			dobPage.enterDOB(valueOrElement);
			dobPage.clicknextButton();
			pageError.verifyErrorsInPage(page);
			break;
		}case NHSConstants.NHS_Partner:{
			NHS_Partner partnerPage=new NHS_Partner(BaseClass.driver);
			partnerPage.verifyPartnerPage();
			partnerPage.selectResponse(valueOrElement);
			partnerPage.clicknextButton();
			pageError.verifyErrorsInPage(page);
			break;
		}case NHSConstants.NHS_ClaimBenfitsTaxCredits:{
			NHS_ClaimBenfitsTaxCredits claimBenfitPage=new NHS_ClaimBenfitsTaxCredits(BaseClass.driver);
			claimBenfitPage.verifyClaimBenfitsTaxCreditsPage();
			claimBenfitPage.selectResponse(valueOrElement);
			claimBenfitPage.clicknextButton();
			pageError.verifyErrorsInPage(page);
			break;
		}case NHSConstants.NHS_UniversalCredit:{
			NHS_UniversalCredit universalCreditPage=new NHS_UniversalCredit(BaseClass.driver);
			universalCreditPage.verifyUniversalCreditPage();
			universalCreditPage.selectResponse(valueOrElement);
			universalCreditPage.clicknextButton();
			pageError.verifyErrorsInPage(page);
			break;
		}case NHSConstants.NHS_Benefits:{
			NHS_Benefits benefitsPage=new NHS_Benefits(BaseClass.driver);
			benefitsPage.verifyBenefitsPage();
			benefitsPage.selectResponse(valueOrElement);
			benefitsPage.clicknextButton();
			pageError.verifyErrorsInPage(page);
			break;
		}
		default:
			Assert.fail(page+" Page not matched");
			break;
		}
	}
	
	@Then("^user verify result Page$")
	public void verifyResult() throws InterruptedException
	{
		NHS_Result resultPage=new NHS_Result(BaseClass.driver);
		resultPage.verifyResultPage();
		log.info("TestCase passed successfully.");
				
	}
	
	@Then("^wait on application$")
	public void hardWait() throws InterruptedException
	{
		Thread.sleep(5000);
	}
	
	@Then("^close the application$")
	public void closeApp()
	{
		BaseClass.driver.close();
		log.info("Application closed successfully");
	}

	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			CommonActions.takeScreenShotAndAttachInReport(BaseClass.driver, scenario);
			CommonActions.scrollDown(BaseClass.driver);
			CommonActions.takeScreenShotAndAttachInReport(BaseClass.driver, scenario);
			log.info("Scenario "+scenario.getName()+" failed inbetween with status "+scenario.getStatus().toString());
		}else
		{
			CommonActions.takeScreenShotAndAttachInReport(BaseClass.driver, scenario);
			CommonActions.scrollDown(BaseClass.driver);
			CommonActions.takeScreenShotAndAttachInReport(BaseClass.driver, scenario);
			log.info("Scenario "+scenario.getName()+" executed successfully with status "+scenario.getStatus().toString());
		}
		BaseClass.driver.quit();
	}
	
}
