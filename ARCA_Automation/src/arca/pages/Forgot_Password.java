package arca.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Forgot_Password extends Navigation {
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(Forgot_Password.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public Forgot_Password(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Forgot_Password");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------Forgot_Password--------------------");
		captureScreenShot(ScreenShotsFilePath + "Forgot_Password.png");
	}
	private void setAuthorInfoForReports()
	{
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription()
	{
		ATUReports.indexPageDescription = "Forgot_Password";
	}

	
	
			//------------------------------Forgot_Password_Signup_and_Forgot_Password-------------------------------
	
	public static void Forgot_Password_Signup_and_Forgot_Password()
	{

		try
		{

			actions = new Actions(driver);
			Actions act = new Actions(driver);
			

		
			
		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in Forgot_Password_Signup_and_Forgot_Password",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "Forgot_Password_Signup_and_Forgot_Password_failed_Error.png");
			ATUReports.add("Forgot_Password_Signup_and_Forgot_Password failed","Forgot_Password_Signup_and_Forgot_Password",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}}
