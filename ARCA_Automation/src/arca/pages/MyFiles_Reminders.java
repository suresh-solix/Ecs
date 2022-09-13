package arca.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DateFormatter;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class MyFiles_Reminders extends Navigation{
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_Reminders.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Reminders(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	//	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Reminders");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Reminders--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders.png");
	}
	private void setAuthorInfoForReports()
	{
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription()
	{
		ATUReports.indexPageDescription = "MyFiles_Reminders";
	}



	//-------------------------------------------MyFiles_Reminders_Files------------------------------------------
	public static void MyFiles_Reminders_Files() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			//Double click on element
			WebElement ele = getPageObject("MyFiles_Remainders"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			WebElement right=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
			actions.contextClick(right).perform();
			click("Add_Remainder");
			Thread.sleep(1000);


			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String reminder_name= "File Reminder on "+dateFormatted;

			log.info("Creating reminder name: "+reminder_name);

			sendKeys("reminder_name",reminder_name);

			click("date_picker");
			Thread.sleep(2000);
			click("pick_today_next_date");
			Thread.sleep(2000);
	//		click("select_time_link");
			Thread.sleep(2000);
			click("active_hours");
			Thread.sleep(2000);
			click("active_minutes");
			Thread.sleep(2000);
			click("frequency_period_icon");
			Thread.sleep(2000);
			select("frequency_period_dropdown","visibletext","Daily");
			Thread.sleep(2000);
			click("create_reminder_button");

			WebDriverWait wait22 = new WebDriverWait(driver, 60);
			wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Reminder added successfully!!!']")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(1000);
			click("toast_close");

			List<WebElement> Remainder = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Reminderfiles = Remainder.size();
			System.out.println("No of files added Remainder" + Reminderfiles);
			
			if(Reminderfiles==2)
			{


				log.info("--------------------------------------------No of added Remainder files is equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Files_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Reminders_Files successfully","MyFiles_Reminders_Files",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Files_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Reminders_Files failed","MyFiles_Reminders_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


		}

		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Reminders_Files",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Files_failed_Error.png");
			ATUReports.add("MyFiles_Reminders_Files failed","MyFiles_Reminders_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


	//------------------------------------------MyFiles_Reminders_Files_Edit------------------------------------


	public static void MyFiles_Reminders_Files_Edit() 
	{

		try
		{

			actions = new Actions(driver);

			//		Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			//Double click on element
			WebElement ele1 = getPageObject("MyFiles_Remainders"); 
			Actions act1 = new Actions(driver);
			act1.doubleClick(ele1).perform();

			WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
			actions.contextClick(right1).perform();
			click("Add_Remainder");
			Thread.sleep(1000);

			WebElement l = driver.findElement(By.xpath("(//*[@src='/static/img/context/edit.svg'])[2]"));
			String s = l.getAttribute("title");
			l.click();
			Thread.sleep(1000);
		//	click("select_time_link");
			Thread.sleep(2000);
			click("Edit_active_hours");
			Thread.sleep(2000);
			click("Edit_active_minutes");
			Thread.sleep(2000);
			click("frequency_period_icon");
			Thread.sleep(2000);
			select("frequency_period_dropdown","visibletext","Daily");
			click("Ok");
			Thread.sleep(2000);
			click("Update");
			Thread.sleep(2000);

			WebDriverWait wait22 = new WebDriverWait(driver, 60);
			wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Edited reminder successfully!!']")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(1000);
			click("toast_close");


		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Reminders_Files_Edit",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Files_Edit_failed_Error.png");
			ATUReports.add("MyFiles_Reminders_Files_Edit failed","MyFiles_Reminders_Files_Edit",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}



	//------------------------------------------MyFiles_Reminders_Files_Bell_Icon------------------------------------


	public static void MyFiles_Reminders_Files_Bell_Icon() 
	{

		try
		{

			actions = new Actions(driver);

			//	Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			//Double click on element
			WebElement ele1 = getPageObject("MyFiles_Remainders"); 
			Actions act1 = new Actions(driver);
			act1.doubleClick(ele1).perform();
			Thread.sleep(1000);
			
			getPageObject("Remainder_file_icon").isDisplayed();
	

			{
				log.info("--------------------------No of MyFiles_Reminders_Files_Bell_Icon------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_Reminders_Files_Bell_Icon_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Reminders_Files_Bell_Icon successfully","MyFiles_Reminders_Files_Bell_Icon",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Reminders_Files_Bell_Icon",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Files_Bell_Icon_failed_Error.png");
			ATUReports.add("MyFiles_Reminders_Files_Bell_Icon failed","MyFiles_Reminders_Files_Bell_Icon",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


	//----------------------------------------MyFiles_Reminders_Delete------------------------------------------

	public static void MyFiles_Reminders_Delete() 
	{

		try
		{

			actions = new Actions(driver);

			//	Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			//Double click on element
			WebElement ele1 = getPageObject("MyFiles_Remainders"); 
			Actions act1 = new Actions(driver);
			act1.doubleClick(ele1).perform();

			WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
			actions.contextClick(right1).perform();
			click("Add_Remainder");
			Thread.sleep(1000);

			WebElement ll = driver.findElement(By.xpath("(//*[@src='/static/img/context/trash2.svg'])[2]"));
			String s = ll.getAttribute("title");
			ll.click();
	//		Thread.sleep(1000);
			click("Ok");
			Thread.sleep(1000);
			
			WebDriverWait wait22 = new WebDriverWait(driver, 60);
			wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Deleted reminder successfully']")));
			Thread.sleep(1000);
			click("toast_close");
			Thread.sleep(1000);
			click("toast_close");
			Thread.sleep(3000);

			{
				log.info("--------------------------No of MyFiles_Reminders_Delete------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_Reminders_Delete_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Reminders_Delete successfully","MyFiles_Reminders_Delete ",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_Out");
			click("Ok");
			Thread.sleep(4000);
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Reminders_Delete",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Delete_failed_Error.png");
			ATUReports.add("MyFiles_Reminders_Delete failed","MyFiles_Reminders_Delete",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


//-------------------------------------------MyFiles_Reminders_Folders------------------------------------------
	
	
	public static void MyFiles_Reminders_Folders() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			//Double click on element
			WebElement ele = getPageObject("MyFiles_Remainders"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			WebElement right=	driver.findElement(By.xpath("//div[contains(text(),'fol 1')]"));
			actions.contextClick(right).perform();
			click("Add_Remainder");
			Thread.sleep(1000);

			
			
			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String reminder_name= "Folder Reminder on "+dateFormatted;

			log.info("Creating reminder name: "+reminder_name);

			sendKeys("reminder_name",reminder_name);

//			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
//    		 LocalDateTime now = LocalDateTime.now();  
//			 click("Icon_Calender");
//			 click("Date");
// 			 click("Stopwatch");
 			 
			click("date_picker");
			Thread.sleep(2000);
			click("pick_today_next_date");
			Thread.sleep(2000);
			
			click("active_hours");
			Thread.sleep(2000);
			click("active_minutes");
			Thread.sleep(2000);
			click("frequency_period_icon");
			Thread.sleep(2000);
			select("frequency_period_dropdown","visibletext","Daily");
			Thread.sleep(2000);
			click("create_reminder_button");

			WebDriverWait wait22 = new WebDriverWait(driver, 60);
			wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Reminder added successfully!!!']")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(1000);
			click("toast_close");

			List<WebElement> Remainder = driver.findElements(By.xpath("//*[@class='folder-name']"));
			int Reminderfolder = Remainder.size();
			System.out.println("No of Folders added Remainder" + Reminderfolder);
			if(Reminderfolder==1)
			{


				log.info("--------------------------------------------No of added Reminders Folders--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Reminders_Folders successfully","MyFiles_Reminders_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Reminders_Folders failed","MyFiles_Reminders_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			
			{
				log.info("--------------------------No of MyFiles_Reminders_Folders------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_Reminders_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Reminders_Folders successfully","MyFiles_Reminders_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


		}

		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Reminders_Folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Folders_failed_Error.png");
			ATUReports.add("MyFiles_Reminders_Folders failed","MyFiles_Reminders_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}



//------------------------------------------MyFiles_Reminders_Folders_Edit------------------------------------


	public static void MyFiles_Reminders_Folders_Edit() 
	{

		try
		{

			actions = new Actions(driver);

			//		Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			//Double click on element
			WebElement ele1 = getPageObject("MyFiles_Remainders"); 
			Actions act1 = new Actions(driver);
			act1.doubleClick(ele1).perform();

			WebElement right1=	driver.findElement(By.xpath("(//*[@class='folder-name'])[1]"));
			actions.contextClick(right1).perform();
			click("Add_Remainder");
			Thread.sleep(1000);

			WebElement l = driver.findElement(By.xpath("(//*[@src='/static/img/context/edit.svg'])[2]"));
			String s = l.getAttribute("title");
			l.click();
			Thread.sleep(1000);

			Thread.sleep(2000);
			click("Edit_active_fol_hours");
			Thread.sleep(2000);
			click("Edit_active_minutes");
			Thread.sleep(2000);
			click("frequency_period_icon");
			Thread.sleep(2000);
			select("frequency_period_dropdown","visibletext","Daily");
			click("Ok");
			Thread.sleep(2000);
			click("Update");
			Thread.sleep(2000);

			WebDriverWait wait22 = new WebDriverWait(driver, 60);
			wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Edited reminder successfully!!']")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(1000);
			click("toast_close");


		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Reminders_Folders_Edit",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Folders_Edit_failed_Error.png");
			ATUReports.add("MyFiles_Reminders_Folders_Edit failed","MyFiles_Reminders_Folders_Edit",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	


//------------------------------------------MyFiles_Reminders_Folder_Bell_Icon------------------------------------


	public static void MyFiles_Reminders_Folder_Bell_Icon() 
	{

		try
		{

			actions = new Actions(driver);

			//	Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			//Double click on element
			WebElement ele1 = getPageObject("MyFiles_Remainders"); 
			Actions act1 = new Actions(driver);
			act1.doubleClick(ele1).perform();
			Thread.sleep(1000);
			
			getPageObject("Remainder_file_icon").isDisplayed();
			


			{
				log.info("--------------------------No of MyFiles_Reminders_Folder_Bell_Icon------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_Reminders_Folder_Bell_Icon_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Reminders_Folder_Bell_Icon successfully","MyFiles_Reminders_Folder_Bell_Icon",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Reminders_Folder_Bell_Icon",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Folder_Bell_Icon_failed_Error.png");
			ATUReports.add("MyFiles_Reminders_Folder_Bell_Icon failed","MyFiles_Reminders_Folder_Bell_Icon",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


	//----------------------------------------MyFiles_Reminders_Folder_Delete------------------------------------------

	public static void MyFiles_Reminders_Folder_Delete() 
	{

		try
		{

			actions = new Actions(driver);

			//	Navigation.login();

			driver.get(Home_Page);

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(2000);
			//Double click on element
			WebElement ele1 = getPageObject("MyFiles_Remainders"); 
			Actions act1 = new Actions(driver);
			act1.doubleClick(ele1).perform();

			WebElement right1=	driver.findElement(By.xpath("//*[@class='folder-name']"));
			actions.contextClick(right1).perform();
			click("Add_Remainder");
			Thread.sleep(1000);

			WebElement ll = driver.findElement(By.xpath("(//*[@src='/static/img/context/trash2.svg'])[2]"));
			String s = ll.getAttribute("title");
			ll.click();
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(1000);
			WebDriverWait wait22 = new WebDriverWait(driver, 60);
			wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Deleted reminder successfully']")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(1000);
			click("toast_close");
			Thread.sleep(3000);

			{
				log.info("--------------------------No of MyFiles_Reminders_Folder_Delete------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_Reminders_Folder_Delete_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Reminders_Folder_Delete successfully","MyFiles_Reminders_Folder_Delete",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_Out");
			click("Ok");
			
			WebDriverWait wait35 = new WebDriverWait(driver, 60);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Reminders_Folder_Delete",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Reminders_Folder_Delete_failed_Error.png");
			ATUReports.add("MyFiles_Reminders_Folder_Delete failed","MyFiles_Reminders_Folder_Delete",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
}