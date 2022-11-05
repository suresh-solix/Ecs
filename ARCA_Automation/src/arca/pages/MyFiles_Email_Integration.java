package arca.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
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

public class MyFiles_Email_Integration extends Navigation{
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_Email_Integration.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Email_Integration(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Email_Integration");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Email_Integration--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Email_Integration.png");
	}
	private void setAuthorInfoForReports()
	{
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription()
	{
		ATUReports.indexPageDescription = "MyFiles_Email_Integration";
	}


	
			//-----------------------------MyFiles_Email_Integration_Admin_account_Add_Email_Integration------------------------------
	

	public static void MyFiles_Email_Integration_Admin_account_Add_Email_Integration()
	{

		try
		{

			actions = new Actions(driver);
			Actions act = new Actions(driver);
			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
			
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Profile_settings");
			Thread.sleep(1000);
			click("Integration");
			click("Config_New_Mail");
			
			sendKeys("Integration_Mail","azamahmed2021@outlook.com");
			sendKeys("Itegration_passwd","system@123!");
			
			getPageObject("choose_path").click();
			WebElement als = getPageObject("Right_click_MyFiles");
			act.doubleClick(als).perform();
			Thread.sleep(2000);
			getPageObject("Create_Folder").click();
			Thread.sleep(2000);	
			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String name="Admin "+dateFormatted;
			
			sendKeys("Profile_Integration_Text",name);
			Thread.sleep(2000);
			click("Create_button");
			Thread.sleep(2000);
			click("Ok");
			Thread.sleep(3000);
			
			sendKeys("Mail_server","outlook.office365.com");
			getPageObject("Auth_type").click();
			sendKeys("Port_Num","993");
			
			Actions at = new Actions(driver);
			at.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			Thread.sleep(1000);
			getPageObject("Frequency_mail").click();
			Thread.sleep(1000);
			getPageObject("Archive").click();
			Thread.sleep(1000);
			click("Button_Test_Connection");
			
			WebDriverWait wait3511 = new WebDriverWait(driver, 60);
			wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Connection successful.')]")));
			Thread.sleep(1000);
			click("toast_close");  
			
			click("Submit_mail");	
			WebDriverWait wait35111 = new WebDriverWait(driver, 60);
			wait35111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Details saved successfully.')]")));
			Thread.sleep(1000);
			click("toast_close");  
			Thread.sleep(3000);
				
			getPageObject("MyFiles_Menu").click();
			
//			WebElement als1 = getPageObject("Folder_Admin");
//			act.doubleClick(als1).perform();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			
			WebDriverWait wait2 = new WebDriverWait(driver, 120);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			
		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Email_Integration_Admin_account_Add_Email_Integration",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Email_Integration_Admin_account_Add_Email_Integration_failed_Error.png");
			ATUReports.add("MyFiles_Email_Integration_Admin_account_Add_Email_Integration failed","MyFiles_Email_Integration_Admin_account_Add_Email_Integration",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
		
			//----------------------------------MyFiles_Email_Integration_Admin_account_Edit_Email_Integration-----------------------------------


	public static void MyFiles_Email_Integration_Admin_account_Edit_Email_Integration()
	{

		try
		{

			actions = new Actions(driver);
			Actions act = new Actions(driver);
			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
			
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Profile_settings");
			Thread.sleep(1000);
			click("Integration");
			Thread.sleep(3000);
			getPageObject("Click_New_Mail").click();
			Thread.sleep(2000);
			click("Edit_mail");
			Thread.sleep(1000);
			
			Actions at = new Actions(driver);
			at.sendKeys(Keys.PAGE_DOWN).build().perform();

			getPageObject("Frequency_mail_30Mints").click();
			Thread.sleep(1000);
			click("Button_Test_Connection");
			
			WebDriverWait wait3511 = new WebDriverWait(driver, 60);
			wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Connection successful.')]")));
			Thread.sleep(1000);
			click("toast_close");  
			
			click("Form_Submit");	
			WebDriverWait wait35111 = new WebDriverWait(driver, 60);
			wait35111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Details updated successfully.')]")));
			Thread.sleep(1000);
			click("toast_close");  
			Thread.sleep(3000);
			
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			
			WebDriverWait wait2 = new WebDriverWait(driver, 120);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			


}
catch (Exception e)
{

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Email_Integration_Admin_account_Edit_Email_Integration",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Email_Integration_Admin_account_Edit_Email_Integration_failed_Error.png");
	ATUReports.add("MyFiles_Email_Integration_Admin_account_Edit_Email_Integration failed","MyFiles_Email_Integration_Admin_account_Edit_Email_Integration",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}
	

		//-------------------------------MyFiles_Email_Integration_Admin_account_Delete_Email_Integration----------------------------------------



	public static void MyFiles_Email_Integration_Admin_account_Delete_Email_Integration()
	{

		try
		{

			actions = new Actions(driver);
			Actions act = new Actions(driver);
			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Profile_settings");
			Thread.sleep(1000);
			click("Integration");
			Thread.sleep(3000);
			getPageObject("Click_New_Mail").click();
			Thread.sleep(2000);
			click("Delete_mail");
			click("folder_ok_button");
			
			WebDriverWait wait35111 = new WebDriverWait(driver, 60);
			wait35111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Details deleted successfully.')]")));
			Thread.sleep(1000);
			click("toast_close");  
			
			
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			
			WebDriverWait wait2 = new WebDriverWait(driver, 120);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			


}
catch (Exception e)
{

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Email_Integration_Admin_account_Delete_Email_Integration",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Email_Integration_Admin_account_Delete_Email_Integration_failed_Error.png");
	ATUReports.add("MyFiles_Email_Integration_Admin_account_Delete_Email_Integration failed","MyFiles_Email_Integration_Admin_account_Delete_Email_Integration",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

	
//-----------------------------MyFiles_Email_Integration_User_account_Add_Email_Integration------------------------------


	public static void MyFiles_Email_Integration_User_account_Add_Email_Integration()
	{

		try
		{

			actions = new Actions(driver);
			Actions act = new Actions(driver);
			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
			
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Profile_settings");
			Thread.sleep(1000);
			click("Integration");
			click("Config_New_Mail");
			
			sendKeys("Integration_Mail","azamahmed2021@outlook.com");
			sendKeys("Itegration_passwd","system@123!");
			
			getPageObject("choose_path").click();
			WebElement als = getPageObject("Right_click_MyFiles");
			act.doubleClick(als).perform();
			Thread.sleep(2000);
			getPageObject("Create_Folder").click();
			Thread.sleep(2000);	
			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String name="User "+dateFormatted;
			
			sendKeys("Profile_Integration_Text",name);
			Thread.sleep(2000);
			click("Create_button");
			Thread.sleep(2000);
			click("Ok");
			Thread.sleep(3000);
			
			sendKeys("Mail_server","outlook.office365.com");
			getPageObject("Auth_type").click();
			sendKeys("Port_Num","993");
			
			Actions at = new Actions(driver);
			at.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			Thread.sleep(1000);
			getPageObject("Frequency_mail").click();
			Thread.sleep(1000);
			getPageObject("Archive").click();
			Thread.sleep(1000);
			click("Button_Test_Connection");
			
			WebDriverWait wait3511 = new WebDriverWait(driver, 60);
			wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Connection successful.')]")));
			Thread.sleep(1000);
			click("toast_close");  
			
			click("Submit_mail");	
			WebDriverWait wait35111 = new WebDriverWait(driver, 60);
			wait35111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Details saved successfully.')]")));
			Thread.sleep(1000);
			click("toast_close");  
			Thread.sleep(3000);
				
			getPageObject("MyFiles_Menu").click();
			
//			WebElement als1 = getPageObject("Folder_Admin");
//			act.doubleClick(als1).perform();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			
			WebDriverWait wait2 = new WebDriverWait(driver, 120);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			
		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Email_Integration_User_account_Add_Email_Integration",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Email_Integration_User_account_Add_Email_Integration_failed_Error.png");
			ATUReports.add("MyFiles_Email_Integration_User_account_Add_Email_Integration failed","MyFiles_Email_Integration_User_account_Add_Email_Integration",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//----------------------------------MyFiles_Email_Integration_User_account_Edit_Email_Integration-----------------------------------


		public static void MyFiles_Email_Integration_User_account_Edit_Email_Integration()
		{

			try
			{

				actions = new Actions(driver);
				Actions act = new Actions(driver);
				Navigation.other_user_in_same_tenant();

				driver.get(Home_Page);
				WebDriverWait wait5 = new WebDriverWait(driver, 120);
				wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
				
				click("Profile_Icon");
				Thread.sleep(1000);
				click("Profile_settings");
				Thread.sleep(1000);
				click("Integration");
				Thread.sleep(3000);
				getPageObject("Click_New_Mail").click();
				Thread.sleep(2000);
				click("Edit_mail");
				Thread.sleep(1000);
				
				Actions at = new Actions(driver);
				at.sendKeys(Keys.PAGE_DOWN).build().perform();

				getPageObject("Frequency_mail_30Mints").click();
				Thread.sleep(1000);
				click("Button_Test_Connection");
				
				WebDriverWait wait3511 = new WebDriverWait(driver, 60);
				wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Connection successful.')]")));
				Thread.sleep(1000);
				click("toast_close");  
				
				click("Form_Submit");	
				WebDriverWait wait35111 = new WebDriverWait(driver, 60);
				wait35111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Details updated successfully.')]")));
				Thread.sleep(1000);
				click("toast_close");  
				Thread.sleep(3000);
				
				Thread.sleep(2000);
				click("Profile_Icon");
				Thread.sleep(1000);
				click("Sign_out");
				click("Ok");
				
				WebDriverWait wait2 = new WebDriverWait(driver, 120);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
				


	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Email_Integration_User_account_Edit_Email_Integration",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Email_Integration_User_account_Edit_Email_Integration_failed_Error.png");
		ATUReports.add("MyFiles_Email_Integration_User_account_Edit_Email_Integration failed","MyFiles_Email_Integration_User_account_Edit_Email_Integration",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	}
		

			//-------------------------------MyFiles_Email_Integration_User_account_Delete_Email_Integration----------------------------------------



		public static void MyFiles_Email_Integration_User_account_Delete_Email_Integration()
		{

			try
			{

				actions = new Actions(driver);
				Actions act = new Actions(driver);
				Navigation.other_user_in_same_tenant();

				driver.get(Home_Page);
				WebDriverWait wait5 = new WebDriverWait(driver, 120);
				wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
				
				click("Profile_Icon");
				Thread.sleep(1000);
				click("Profile_settings");
				Thread.sleep(1000);
				click("Integration");
				Thread.sleep(3000);
				getPageObject("Click_New_Mail").click();
				Thread.sleep(2000);
				click("Delete_mail");
				click("folder_ok_button");
				
				WebDriverWait wait35111 = new WebDriverWait(driver, 60);
				wait35111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Details deleted successfully.')]")));
				Thread.sleep(1000);
				click("toast_close");  
				Thread.sleep(3000);
				
				Thread.sleep(2000);
				click("Profile_Icon");
				Thread.sleep(1000);
				click("Sign_out");
				click("Ok");


	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Email_Integration_User_account_Delete_Email_Integration",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Email_Integration_User_account_Delete_Email_Integration_failed_Error.png");
		ATUReports.add("MyFiles_Email_Integration_User_account_Delete_Email_Integration failed","MyFiles_Email_Integration_User_account_Delete_Email_Integration",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	}
}




