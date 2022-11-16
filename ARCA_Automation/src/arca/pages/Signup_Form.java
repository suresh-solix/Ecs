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
import org.seleniumhq.jetty9.util.thread.Scheduler.Task;
import org.testng.Assert;
import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Signup_Form extends Navigation {

	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(Signup_Form.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public static String Temp_mail = "https://temp-mail.org/en/";
	public Signup_Form(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("Signup_Form");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------Signup_Form--------------------");
		captureScreenShot(ScreenShotsFilePath + "Signup_Form.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "Signup_Form";
	}

			//--------------------------Signup_Form_Delete_Old_Email----------------------------


public static void Signup_Form_Delete_Old_Email()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

		driver.get(Temp_mail);
		
		Thread.sleep(2000);
		click("Temp_mail_delete");
		
		
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Signup_Form_Delete_Old_Email",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Signup_Form_Delete_Old_Email_failed_Error.png");
		ATUReports.add("Signup_Form_Delete_Old_Email failed","Signup_Form_Delete_Old_Email",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

			//-----------------------------Signup_Form_Copy_New_Mail--------------------------------

public static void Signup_Form_Copy_New_Mail()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

		driver.get(Temp_mail);
		
		Thread.sleep(2000);
		click("Temp_mail_delete");
		
		Thread.sleep(2000);
		driver.navigate().back();
		
		click("Copy_mail");
		
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Signup_Form_Copy_New_Mail",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Signup_Form_Copy_New_Mail_failed_Error.png");
		ATUReports.add("Signup_Form_Copy_New_Mail failed","Signup_Form_Copy_New_Mail",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

//-----------------------------Signup_Form_Fill_Signup_Form--------------------------------

public static void Signup_Form_Fill_Signup_Form()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

        driver.get(Temp_mail);
        
        Thread.sleep(4000);
        String link_text=driver.findElement(By.xpath("//input[@id='mail']")).getAttribute("value").toString();
        log.info("link Text is:"+link_text);
				
		driver.get(Home_Page);
		driver.navigate().refresh();
		Thread.sleep(2000);
		getPageObject("Create_new_Account").click();
		Thread.sleep(2000);
		       // --Form Creating
				DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);

				String single_file_folder_name="Admin "+dateFormatted;
				
				sendKeys("Business_Name",single_file_folder_name);
				sendKeys("Create_mail",link_text);
				sendKeys("First_name","Admin");
				sendKeys("Last_name","test");
				sendKeys("Signup_Password","Test@123");
				Thread.sleep(2000);
				click("Sigup_Free_Trial");
				Thread.sleep(4000);
				click("Button_Confirm");
				Thread.sleep(2000);
				click("New_Organization_account");
				click("Continue");
				Thread.sleep(2000);
				click("Skip_for_now");
				click("Sigup_Free_Trial");
				Thread.sleep(3000);
				Thread.sleep(1000);
				click("Profile_Icon");
				Thread.sleep(2000);
				click("Sign_out");
				Thread.sleep(1000);
				click("Ok");
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Signup_Form_Fill_Signup_Form",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Signup_Form_Fill_Signup_Form_failed_Error.png");
		ATUReports.add("Signup_Form_Fill_Signup_Form failed","Signup_Form_Fill_Signup_Form",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

		
			//---------------------------Signup_Default_Storage_Monthly_billing_free_trial-----------------------------------

public static void Signup_Default_Storage_Monthly_billing_free_trial()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

        driver.get(Temp_mail);
        
        Thread.sleep(4000);
        String link_text=driver.findElement(By.xpath("//input[@id='mail']")).getAttribute("value").toString();
        log.info("link Text is:"+link_text);
				
		driver.get(Home_Page);
		Thread.sleep(2000);
		getPageObject("Create_new_Account").click();
		Thread.sleep(2000);
		       // --Form Creating
				DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);

				String single_file_folder_name="Admin "+dateFormatted;
				
				sendKeys("Business_Name",single_file_folder_name);
				sendKeys("Create_mail",link_text);
				sendKeys("First_name","Admin");
				sendKeys("Last_name","test");
				sendKeys("Signup_Password","Test@123");
				Thread.sleep(2000);
				click("Sigup_Free_Trial");
				Thread.sleep(4000);
				click("Button_Confirm");
				Thread.sleep(2000);
				click("New_Organization_account");
				click("Continue");
				Thread.sleep(2000);
				click("Skip_for_now");
				getPageObject("Bill_per_month").isDisplayed();
				Thread.sleep(2000);
				// Page Down
				Actions at = new Actions(driver);
				at.sendKeys(Keys.PAGE_DOWN).build().perform();

				click("Free_Trial_Billing");
				Thread.sleep(3000);
				Thread.sleep(1000);
				click("Profile_Icon");
				Thread.sleep(2000);
				click("Sign_out");
				Thread.sleep(1000);
				click("Ok");
				
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Signup_Default_Storage_Monthly_billing_free_trial",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Signup_Default_Storage_Monthly_billing_free_trial_failed_Error.png");
		ATUReports.add("Signup_Default_Storage_Monthly_billing_free_trial failed","Signup_Default_Storage_Monthly_billing_free_trial",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


//---------------------------Signup_Default_Storage_Yearly_billing_free_trial-----------------------------------

public static void Signup_Default_Storage_Yearly_billing_free_trial()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

      driver.get(Temp_mail);
      
      Thread.sleep(4000);
      String link_text=driver.findElement(By.xpath("//input[@id='mail']")).getAttribute("value").toString();
      log.info("link Text is:"+link_text);
				
		driver.get(Home_Page);
		Thread.sleep(2000);
		getPageObject("Create_new_Account").click();
		Thread.sleep(2000);
		       // --Form Creating
				DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);

				String single_file_folder_name="Admin "+dateFormatted;
				
				sendKeys("Business_Name",single_file_folder_name);
				sendKeys("Create_mail",link_text);
				sendKeys("First_name","Admin");
				sendKeys("Last_name","test");
				sendKeys("Signup_Password","Test@123");
				Thread.sleep(2000);
				click("Sigup_Free_Trial");
				Thread.sleep(4000);
				click("Button_Confirm");
				Thread.sleep(2000);
				click("New_Organization_account");
				click("Continue");
				Thread.sleep(2000);
				click("Skip_for_now");
				click("Toggle_Button");
				getPageObject("Bill_per_Yearly").isDisplayed();
				Thread.sleep(2000);
				// Page Down
				Actions at = new Actions(driver);
				at.sendKeys(Keys.PAGE_DOWN).build().perform();

				click("Free_Trial_Billing");
				Thread.sleep(3000);
				Thread.sleep(1000);
				click("Profile_Icon");
				Thread.sleep(2000);
				click("Sign_out");
				Thread.sleep(1000);
				click("Ok");
				
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Signup_Default_Storage_Yearly_billing_free_trial",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Signup_Default_Storage_Yearly_billing_free_trial_failed_Error.png");
		ATUReports.add("Signup_Default_Storage_Yearly_billing_free_trial failed","Signup_Default_Storage_Yearly_billing_free_trial",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


//---------------------------Signup_Default_Storage_Monthly_billing_Credit_card_payment-----------------------------------

public static void Signup_Default_Storage_Monthly_billing_Credit_card_payment()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

      driver.get(Temp_mail);
      
      Thread.sleep(4000);
      String link_text=driver.findElement(By.xpath("//input[@id='mail']")).getAttribute("value").toString();
      log.info("link Text is:"+link_text);
      		
		driver.get(Home_Page);
		Thread.sleep(2000);
		getPageObject("Create_new_Account").click();
		Thread.sleep(2000);
		       // --Form Creating
				DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);

				String single_file_folder_name="Admin "+dateFormatted;
				
				sendKeys("Business_Name",single_file_folder_name);
				sendKeys("Create_mail",link_text);
				sendKeys("First_name","Admin");
				sendKeys("Last_name","test");
				sendKeys("Signup_Password","Test@123");
				Thread.sleep(2000);
				click("Sigup_Free_Trial");
				Thread.sleep(4000);
				click("Button_Confirm");
				Thread.sleep(2000);
				click("New_Organization_account");
				click("Continue");
				Thread.sleep(2000);
				click("Skip_for_now");
				getPageObject("Bill_per_month").isDisplayed();
				Thread.sleep(2000);
				// Page Down
				Actions at = new Actions(driver);
				at.sendKeys(Keys.PAGE_DOWN).build().perform();
				//storage Range
			
				click("range_max");
		//		click("Storage_Range_Month_25TB");
				getPageObject("Set_Payment").isDisplayed();
				sendKeys("Credit_Card_name","Solix");
				sendKeys("Credit_card_Num","4242 4242 4242 4242");
				sendKeys("cvc","897");
				sendKeys("Credit_Expaired","0134");
				sendKeys("Credit_postal","520567");
				click("Credit_country");
				click("Credit_Apply");
				
				click("Free_Trial_Billing");
				Thread.sleep(3000);
				
				Thread.sleep(1000);
				click("Profile_Icon");
				Thread.sleep(2000);
				click("Sign_out");
				Thread.sleep(1000);
				click("Ok");
				
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in Signup_Default_Storage_Monthly_billing_Credit_card_payment",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "Signup_Default_Storage_Monthly_billing_Credit_card_payment_failed_Error.png");
		ATUReports.add("Signup_Default_Storage_Monthly_billing_Credit_card_payment failed","Signup_Default_Storage_Monthly_billing_Credit_card_payment",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}
}


		







