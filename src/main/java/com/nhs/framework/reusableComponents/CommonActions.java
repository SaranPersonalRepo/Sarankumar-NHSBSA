package com.nhs.framework.reusableComponents;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nhs.framework.helper.BaseClass;
import com.nhs.framework.helper.LoggerHelper;

import io.cucumber.java.Scenario;
/***
 * 
 * @author Sarankumar
 * Description - Below CommonActions class handles commnonly used events to happen with elements like visiblity,clickable,Displayed and screenshot of page, scrollDown
 *
 */
public class CommonActions {
	private static final Logger log = LoggerHelper.getLogger(CommonActions.class);
	private WebDriver driver;
	private static JavascriptExecutor jse;
	
	public CommonActions(WebDriver driver) {
		this.driver = driver;}
	
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	public void waitForElementVisibleWithPolling(WebElement locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
		log.info(locator);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public void waitForElementVisibility(WebDriver driver, WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element found..."+element.getText());
	}
	
	public WebElement waitForElementTillClickable(WebDriver driver,WebElement element,long time){
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickOn(WebElement element) {
		element.click();
	}
	public static void takeScreenShotAndAttachInReport(WebDriver driver, Scenario scenario)
	{
		try {
			final byte[] screenShot=((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot,NHSConstants.fileType, scenario.getName()+new Random().nextInt(1000));
			log.info("Screenshot Captured..");
		}catch(Exception e)
		{
			e.printStackTrace();
			log.info(e.getMessage());
		}
		
	}
	public static void scrollDown(WebDriver driver)
	{
		try {
			jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

	}
	public boolean isDisplayed(WebDriver driver, WebElement element, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			log.info(e);
			return false;
		}
	}
}
