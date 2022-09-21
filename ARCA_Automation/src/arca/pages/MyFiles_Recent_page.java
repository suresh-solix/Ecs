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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.DriverFactory;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class MyFiles_Recent_page extends Navigation {
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_Recent_page.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Recent_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Recent_page");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Recent_page--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_page.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "MyFiles_Recent_page";
	}



	//------------------------------------MyFiles_Recent_page_Share_multiple_files_to_user---------------------------
	
	public static void MyFiles_Recent_page_Share_multiple_files_to_user()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			click("recent_page");
			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before Moved" + nooffiles);
			click("select_all_files");

			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right).perform();
			Thread.sleep(2000);
			click("Share");
			WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
			noUserOr.sendKeys("li");

			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

			getPageObject("search_result_first_element").click(); 
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
			click("share_button");

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			Navigation.other_user_in_same_tenant();

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			click("shared_with_me");

			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files After Moved" + Aftermovedfilestofolder);
			if(Aftermovedfilestofolder==nooffiles)
			{


				log.info("--------------------------------------------No of moved files is equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_page_Share_multiple_files_to_user_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_page_Share_multiple_files_to_user successfully","MyFiles_Recent_page_Share_multiple_files_to_user",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_page_Share_multiple_files_to_user_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_page_Share_multiple_files_to_user failed","MyFiles_Recent_page_Share_multiple_files_to_user",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait351 = new WebDriverWait(driver, 120);
			wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			Navigation.login();

			
			WebDriverWait wait511 = new WebDriverWait(driver, 120);
			wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			click("recent_page");
			
			WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right1).perform();
			Thread.sleep(2000);
			click("Share");
			
			select("shared_user_popup_dropdown","visibletext","Remove");
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
			
			WebDriverWait wait2221 = new WebDriverWait(driver, 60);
			wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");
			
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait3511 = new WebDriverWait(driver, 120);
			wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			
			
		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_page_Share_multiple_files_to_user",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_page_Share_multiple_files_to_user_failed_Error.png");
			ATUReports.add("MyFiles_Recent_page_Share_multiple_files_to_user failed","MyFiles_Recent_page_Share_multiple_files_to_user",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


	//------------------------------------MyFiles_Recent_page_Share_multiple_files_to_Group---------------------------


	public static void MyFiles_Recent_page_Share_multiple_files_to_Group()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			click("recent_page");
			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before Moved" + nooffiles);
			click("select_all_files");

			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right).perform();
			Thread.sleep(2000);
			click("Share");
			WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
			noUserOr.sendKeys("T");

			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

			getPageObject("search_result_first_element").click(); 
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
			click("share_button");

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			Navigation.other_user_in_same_tenant();

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			click("shared_with_me");

			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files After Moved" + Aftermovedfilestofolder);
			if(Aftermovedfilestofolder==nooffiles)
			{


				log.info("--------------------------------------------No of moved files is equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_page_Share_multiple_files_to_Group_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_page_Share_multiple_files_to_Group successfully","MyFiles_Recent_page_Share_multiple_files_to_Group",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_page_Share_multiple_files_to_Group_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_page_Share_multiple_files_to_Group failed","MyFiles_Recent_page_Share_multiple_files_to_Group",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait351 = new WebDriverWait(driver, 120);
			wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			
Navigation.login();

			
			WebDriverWait wait511 = new WebDriverWait(driver, 120);
			wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			click("recent_page");
			
			WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right1).perform();
			Thread.sleep(2000);
			click("Share");
			
			select("shared_user_popup_dropdown","visibletext","Remove");
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
			
			WebDriverWait wait2221 = new WebDriverWait(driver, 60);
			wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");
			
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait3511 = new WebDriverWait(driver, 120);
			wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_page_Share_multiple_files_to_Group",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_page_Share_multiple_files_to_Group_failed_Error.png");
			ATUReports.add("MyFiles_Recent_page_Share_multiple_files_to_Group failed","MyFiles_Recent_page_Share_multiple_files_to_Group",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//------------------------------------MyFiles_Recent_Share_file_with_internal_user_with_permissions---------------------------

	public static void MyFiles_Recent_Share_file_with_internal_user_with_permissions()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			click("recent_page");
			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before Moved" + nooffiles);

			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right).perform();
			Thread.sleep(2000);
			click("Share");
			WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
			noUserOr.sendKeys("li");

			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

			getPageObject("search_result_first_element").click(); 
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
			click("share_button");

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Shared Successfully')]")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			Navigation.other_user_in_same_tenant();

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			click("shared_with_me");

			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files After Moved" + Aftermovedfilestofolder);

			if(Aftermovedfilestofolder==1)
			{


				log.info("--------------------------------------------No of moved files is equal to before--------------------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Share_file_with_internal_user_with_permissions_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_Share_file_with_internal_user_with_permissions successfully","MyFiles_Recent_Share_file_with_internal_user_with_permissions",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Share_file_with_internal_user_with_permissions_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_Share_file_with_internal_user_with_permissions failed","MyFiles_Recent_Share_file_with_internal_user_with_permissions",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait351 = new WebDriverWait(driver, 120);
			wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_Share_file_with_internal_user_with_permissions",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Share_file_with_internal_user_with_permissions_failed_Error.png");
			ATUReports.add("MyFiles_Recent_Share_file_with_internal_user_with_permissions failed","MyFiles_Recent_Share_file_with_internal_user_with_permissions",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


	//-------------------------------------MyFiles_Recent_Page_Add_comment_to_file----------------------------------------

	public static void MyFiles_Recent_Page_Add_comment_to_file()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			click("recent_page");

			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right).perform();
			Thread.sleep(1000);
			click("Add_Comment");
			String s1 ="Testing";
			sendKeys("Text_area_comments",s1);
			click("Save");

			//Here Toast message is a confirmation Verification
			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Successfully saved the comment']")));
			Thread.sleep(1000);
			click("toast_close");
			Thread.sleep(1000);
			click("toast_close");

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait351 = new WebDriverWait(driver, 120);
			wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_Page_Add_comment_to_file",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Add_comment_to_file_failed_Error.png");
			ATUReports.add("MyFiles_Recent_Page_Add_comment_to_file failed","MyFiles_Recent_Page_Add_comment_to_file",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//--------------------------------------MyFiles_Recent_Page_Add_tags_to_multiple_files--------------------------------------

	public static void MyFiles_Recent_Page_Add_tags_to_multiple_files()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			click("recent_page");
			click("All_Files");
			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right).perform();
			Thread.sleep(1000);
			click("right_click_add_tag");
			sendKeys("Add_Tag","Testind Demo Tag 1");
			click("Save");

			//Here Toast message is a confirmation Verification
			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Updated the tags successfully']")));
			Thread.sleep(1000);
			click("toast_close");
			Thread.sleep(1000);
			getPageObject("Single_File").click(); 
			click("Details_circle");
			Thread.sleep(1000);
			getPageObject("Second_File").click(); 

			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");

			WebDriverWait wait351 = new WebDriverWait(driver, 120);
			wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_Page_Add_tags_to_multiple_files",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Add_tags_to_multiple_files_failed_Error.png");
			ATUReports.add("MyFiles_Recent_Page_Add_tags_to_multiple_files failed","MyFiles_Recent_Page_Add_tags_to_multiple_files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//------------------------------MyFiles_Recent_Page_Add_multiple_files_to_collection-------------------------------

	public static void MyFiles_Recent_Page_Add_multiple_files_to_collection()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);
			click("recent_page");

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before Moved" + nooffiles);
			click("select_all_files");

			for(int i=25; i<=nooffiles-1; i++)
			{
				driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();
			}

			WebElement Files1 = driver.findElement(By.xpath("(//div[@class='fileName'])"));

			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right).perform();
			Thread.sleep(1000);

			WebElement Addtocollections =	driver.findElement(By.xpath("(//span[contains(text(),'Add to Collection')])[1]"));
			actions.moveToElement(Addtocollections).perform();
			Thread.sleep(2000);

			WebElement Create = driver.findElement(By.xpath("(//*[contains(text(),'Create New Collection')])"));
			Create.click();
			Thread.sleep(2000);
			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String collection_folder_name="collection "+dateFormatted;
			sendKeys("collections_name_textarea",collection_folder_name);

			click("Save");
			Thread.sleep(2000);
			WebElement close = driver.findElement(By.xpath("//div[text()='Added file(s) to the collection successfully!!']"));
			close.click();
			Thread.sleep(2000);
			click("collections");
			Thread.sleep(2000);

			WebElement ele11 = getPageObject("View");
			actions.doubleClick(ele11).perform();

			Thread.sleep(2000);

			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files Moved" + Aftermovedfilestofolder);

			if(Aftermovedfilestofolder==25)
			{


				log.info("--------------------------No of moved files is equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Add_multiple_files_to_collection_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_Page_Add_multiple_files_to_collection successfully","MyFiles_Recent_Page_Add_multiple_files_to_collection",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Add_multiple_files_to_collection_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_Page_Add_multiple_files_to_collection failed","MyFiles_Recent_Page_Add_multiple_files_to_collection",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");


			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));



		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_Page_Add_multiple_files_to_collection",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Add_multiple_files_to_collection_failed_Error.png");
			ATUReports.add("MyFiles_Recent_Page_Add_multiple_files_to_collection failed","MyFiles_Recent_Page_Add_multiple_files_to_collection",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//------------------------------------------MyFiles_Recent_Page_Multiple_files_copy----------------------------------


	public static void MyFiles_Recent_Page_Multiple_files_copy()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			Actions act = new Actions(driver);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);
			click("recent_page");

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before " + nooffiles);
			click("select_all_files");

			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
			actions.contextClick(right).perform();

			click("file_right_click_copy_move");

			WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
			act.doubleClick(el).perform();
			Thread.sleep(1000);
			getPageObject("Folder_Create").click();
			Thread.sleep(1000);
			sendKeys("Create_Folder_name","Multi Files Copy");
			Thread.sleep(1000);
			click("Create_button");
			Thread.sleep(1000);
			getPageObject("Recent_Copy").click();
			Thread.sleep(2000);
			click("Close_Pop");
			
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied')]")));
			Thread.sleep(1000);
			click("toast_close");
			Thread.sleep(1000);
			WebElement el11 =driver.findElement(By.xpath("//span[contains(text(),'My Files')]"));
			act.doubleClick(el11).perform();
			
			
			Thread.sleep(1000);
			WebElement el111 =driver.findElement(By.xpath("//div[contains(text(),'Multi Files Copy')]"));
			act.doubleClick(el111).perform();

			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files After" + Aftermovedfilestofolder);

			if(Aftermovedfilestofolder==nooffiles)
			{


				log.info("--------------------------No of moved files is equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Multiple_files_copy_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_Page_Multiple_files_copy successfully","MyFiles_Recent_Page_Multiple_files_copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Multiple_files_copy_failed.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_Page_Multiple_files_copy failed","MyFiles_Recent_Page_Multiple_files_copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");


			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_Page_Multiple_files_copy",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Multiple_files_copy_failed_Error.png");
			ATUReports.add("MyFiles_Recent_Page_Multiple_files_copy failed","MyFiles_Recent_Page_Multiple_files_copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//---------------------------------MyFiles_Recent_Page_Multiple_files_Download---------------------------------------


	public static void MyFiles_Recent_Page_Multiple_files_Download()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			Actions act = new Actions(driver);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);
			click("recent_page");

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Download" + nooffiles);
			click("select_all_files");

			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
			actions.contextClick(right).perform();
			click("Downloads");

			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Depending on the file/folder size, download might take some time. ')]")));
			Thread.sleep(1000);
			click("toast_close");

			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");


			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));



		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_Page_Multiple_files_Download",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Multiple_files_Download_failed_Error.png");
			ATUReports.add("MyFiles_Recent_Page_Multiple_files_Download failed","MyFiles_Recent_Page_Multiple_files_Download",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//-----------------------------MyFiles_Recent_Page_Add_reminder_to_file-------------------------------

	public static void MyFiles_Recent_Page_Add_reminder_to_file()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			Actions act = new Actions(driver);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);
			click("recent_page");

			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right).perform();
			click("Add_Remainders");

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

			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");


			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_Page_Add_reminder_to_file",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Add_reminder_to_file_failed_Error.png");
			ATUReports.add("MyFiles_Recent_Page_Add_reminder_to_file failed","MyFiles_Recent_Page_Add_reminder_to_file",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	//----------------------------MyFiles_Recent_Page_File_rename---------------------------------------

	public static void MyFiles_Recent_Page_File_rename()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			Actions act = new Actions(driver);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);
			click("recent_page");

			WebElement right=	driver.findElement(By.xpath("(//div[contains(text(),'New Text 1.txt')])[2]"));
			actions.contextClick(right).perform();
			click("File_Rename");
			getPageObject("rename_file_textarea").clear();
			sendKeys("Rename_input","Test");
			click("Save");
			Thread.sleep(1000);
			
			WebDriverWait wait22 = new WebDriverWait(driver, 60);
			wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'New Text 1 Renamed to Test')]")));
			Thread.sleep(1000);
			click("toast_close");
	//		Thread.sleep(1000);
	//		click("toast_close");
			//Here click Profile and Sign out
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");


			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_Page_File_rename",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_File_rename_failed_Error.png");
			ATUReports.add("MyFiles_Recent_Page_File_rename failed","MyFiles_Recent_Page_File_rename",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

		//----------------------------------MyFiles_Recent_Page_File_view_versions--------------------------------------------

	public static void MyFiles_Recent_Page_File_view_versions()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			Actions act = new Actions(driver);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);
			click("recent_page");
			
			WebElement right=	driver.findElement(By.xpath("(//div[@class='fileName'])[1]"));
			actions.contextClick(right).perform();
			click("View_version");
			Thread.sleep(1000);
			getPageObject("Current_version").isDisplayed();
			
			{
				log.info("--------------------------No of MyFiles_Reminders_Files_Bell_Icon------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_Recent_Page_File_view_versions_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_Recent_Page_File_view_versions successfully","MyFiles_Recent_Page_File_view_versions",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			Thread.sleep(1000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_Out");
			click("Ok");
			
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Recent_Page_File_view_versions",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_File_view_versions_failed_Error.png");
	ATUReports.add("MyFiles_Recent_Page_File_view_versions failed","MyFiles_Recent_Page_File_view_versions",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


		//----------------------------MyFiles_Recent_Page_Multiple_Files_trash------------------------------------

public static void MyFiles_Recent_Page_Multiple_Files_trash()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		Actions act = new Actions(driver);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		click("recent_page");
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before Moved" + nooffiles);
		click("select_all_files");
		
		WebElement right=	driver.findElement(By.xpath("(//div[@class='fileName'])[1]"));
		actions.contextClick(right).perform();
		click("Right_click_Trash");
		Thread.sleep(1000);
		click("Trash_Button"); 
		
		WebDriverWait wait22 = new WebDriverWait(driver, 60);
		wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved to trash')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of files Moved Trash" + Aftermovedfilestofolder);

		if(Aftermovedfilestofolder==nooffiles)
		{
			log.info("--------------------------------------------No of moved multiple_files is equal to before--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Multiple_Files_trash_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_Multiple_Files_trash successfully","MyFiles_Recent_Page_Multiple_Files_trash",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Multiple_Files_trash_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_Multiple_Files_trash failed","MyFiles_Recent_Page_Multiple_Files_trash",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		Thread.sleep(8000);
		click("Menu_Trash");
		click("select_all_files");
		
		WebElement right1=	driver.findElement(By.xpath("(//div[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		click("Restore");	
		
		WebDriverWait wait221 = new WebDriverWait(driver, 60);
		wait221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'File(s) restored successfully')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_Out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		
}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Recent_Page_Multiple_Files_trash",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Multiple_Files_trash_failed_Error.png");
	ATUReports.add("MyFiles_Recent_Page_Multiple_Files_trash failed","MyFiles_Recent_Page_Multiple_Files_trash",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//---------------------------------------MyFiles_Recent_Page_File_Preview---------------------------------

public static void MyFiles_Recent_Page_File_Preview()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		Actions act = new Actions(driver);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		click("recent_page");
		
		String file1 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]")).getText();
		System.out.println(file1);
		
		WebElement right=	driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		click("click_preview");
		Thread.sleep(1000);
		String file2 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]")).getText();
		System.out.println(file2);
		
		if(file1.equals(file2))
		{
			log.info("--------------------------------------------File name is equal to before--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_File_Preview_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_File_Preview successfully","MyFiles_Recent_Page_File_Preview",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_File_Preview_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_File_Preview failed","MyFiles_Recent_Page_File_Preview",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		click("Left_Back");
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_Out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Recent_Page_File_Preview",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_File_Preview_failed_Error.png");
	ATUReports.add("MyFiles_Recent_Page_File_Preview failed","MyFiles_Recent_Page_File_Preview",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


//---------------------------------------MyFiles_Recent_Page_Right_and_Left_Naviation---------------------------------

public static void MyFiles_Recent_Page_Right_and_Left_Naviation()
{

try
{

	actions = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	Actions act = new Actions(driver);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	click("recent_page");
	
	String file1 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]")).getText();
	System.out.println(file1);
	
	WebElement right=	driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]"));
	actions.contextClick(right).perform();
	Thread.sleep(1000);
	click("click_preview");
	Thread.sleep(1000);
	String file2 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]")).getText();
	System.out.println(file2);
	
	if(file1.equals(file2))
	{
		log.info("--------------------------------------------File name is equal to before--------------------------------------------");

		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_File_Preview_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Recent_Page_File_Preview successfully","MyFiles_Recent_Page_File_Preview",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}
	else
	{

		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_File_Preview_failed.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Recent_Page_File_Preview failed","MyFiles_Recent_Page_File_Preview",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}
	
	Thread.sleep(2000);
	click("Arrow_Right");

	String file3 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[2]")).getText();
	System.out.println(file3);

	if(file1.equals(file3))
	{


		log.info("--------------------------No of  file  is  equal to before------------------------------");

		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Right_and_Left_Naviation_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Recent_Page_Right_and_Left_Naviation successfully","MyFiles_Recent_Page_Right_and_Left_Naviation",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}

	else 
	{
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Right_and_Left_Naviation_failed.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Recent_Page_Right_and_Left_Naviation failed","MyFiles_Recent_Page_Right_and_Left_Naviation",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Thread.sleep(2000);
	}
	
	click("Arrow_Left");
	
	Thread.sleep(1000);
	click("Left_Back");
	Thread.sleep(1000);
	click("Profile_Icon");
	Thread.sleep(1000);
	click("Sign_Out");
	click("Ok");
	
	WebDriverWait wait35 = new WebDriverWait(driver, 120);
	wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

}
catch (Exception e) {

System.out.println("errror at: ");
e.printStackTrace();
log.error("Error in MyFiles_Recent_Page_Right_and_Left_Naviation",e);	
//log.fatal(e.getMessage(),e);
captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Right_and_Left_Naviation_failed_Error.png");
ATUReports.add("MyFiles_Recent_Page_Right_and_Left_Naviation failed","MyFiles_Recent_Page_Right_and_Left_Naviation",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//-------------------------------MyFiles_Recent_Page_File_Preview_Download--------------------------------


public static void MyFiles_Recent_Page_File_Preview_Download()
{

try
{

	actions = new Actions(driver);

	Navigation.login();

	driver.get(Home_Page);
	Actions act = new Actions(driver);
	WebDriverWait wait5 = new WebDriverWait(driver, 120);
	wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
	Thread.sleep(1000);
	click("recent_page");
	
	WebElement right=	driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]"));
	actions.contextClick(right).perform();
	Thread.sleep(1000);
	click("Downloads");
	Thread.sleep(1000);
	WebDriverWait wait221 = new WebDriverWait(driver, 60);
	wait221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Depending on the file/folder size, download might take some time.')]")));
	Thread.sleep(1000);
	click("toast_close");
	Thread.sleep(1000);
		
	Thread.sleep(1000);
	
	Thread.sleep(1000);
	click("Profile_Icon");
	Thread.sleep(1000);
	click("Sign_Out");
	click("Ok");
	
	WebDriverWait wait35 = new WebDriverWait(driver, 120);
	wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

}
catch (Exception e) {

System.out.println("errror at: ");
e.printStackTrace();
log.error("Error in MyFiles_Recent_Page_File_Preview_Download",e);	
//log.fatal(e.getMessage(),e);
captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_File_Preview_Download_failed_Error.png");
ATUReports.add("MyFiles_Recent_Page_File_Preview_Download failed","MyFiles_Recent_Page_File_Preview_Download",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//-----------------------------MyFiles_Recent_Page_Share_to_Internal_User---------------------------

public static void MyFiles_Recent_Page_Share_to_Internal_User() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		click("recent_page");
		
		String file1 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]")).getText();
		System.out.println(file1);
		
		WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
		actions.contextClick(right).perform();
		
		click("Share");
		Thread.sleep(2000);

		WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr.sendKeys("li");


		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		click("share_button");

		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
		Thread.sleep(2000);
		click("toast_close");
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_Out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		Navigation.other_user_in_same_tenant();

		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		click("shared_with_me");

		String file2 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]")).getText();
		System.out.println(file2);
		
		if(file1.equals(file2))
		{
			log.info("--------------------------No of Shared Files name is  equal to before ------------------------------");

			captureScreenShot(ScreenShotsFilePath +"MyFiles_Recent_Page_Share_to_Internal_User_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_Share_to_Internal_User successfully","MyFiles_Recent_Page_Share_to_Internal_User",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			Thread.sleep(2000); 
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Share_to_Internal_User_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_Share_to_Internal_User failed","MyFiles_Recent_Page_Share_to_Internal_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		
		WebElement elementLocator9 = getPageObject("share_first_file");
		actions.contextClick(elementLocator9).perform();
		Thread.sleep(2000);

		WebElement shared_file_right_click_options = driver.findElement(By.xpath("//div[@class='files']/div[2][@class='context-list']/ul"));
		List<WebElement> each_file_li_tag=shared_file_right_click_options.findElements(By.tagName("li"));

		for(int i=0;i<each_file_li_tag.size();i++)
		{

			WebElement li =each_file_li_tag.get(i);
			String each_li = each_file_li_tag.get(i).getText();
			log.info("Shared file right click options "+each_li);

			if( each_li.contains("Preview") || each_li.contains("Share +") || each_li.contains("Add/View Comment") || each_li.contains("Add/View Tags") || each_li.contains("Add to Collection") || each_li.contains("External Sharing") || each_li.contains("Copy / Move") || each_li.contains("Download") || each_li.contains("Add Reminders") || each_li.contains("Rename") || each_li.contains("View Versions") || each_li.contains("Trash"))
			{
				log.info("file right click option exist");
				Thread.sleep(2000);

			}
			else
			{
				log.info("file right click option does not exist");
				ATUReports.add("folder right click option failed","folder right click option",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		}

		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");

		WebDriverWait wait351 = new WebDriverWait(driver, 120);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		
	}
	catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Recent_Page_Share_to_Internal_User",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Share_to_Internal_User_failed_Error.png");
	ATUReports.add("MyFiles_Recent_Page_Share_to_Internal_User failed","MyFiles_Recent_Page_Share_to_Internal_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	}


		//---------------------------MyFiles_Recent_Page_Share_to_Group------------------------------------


public static void MyFiles_Recent_Page_Share_to_Group() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.other_user_in_same_tenant();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("recent_page");
		
		String file1 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]")).getText();
		System.out.println(file1);
		
		WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
		actions.contextClick(right).perform();
		click("Share");


		WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr.sendKeys("T");


		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		click("share_button");

		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
		Thread.sleep(2000);
		click("toast_close");

		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_Out");
		click("Ok");
		Thread.sleep(5000);

		Navigation.login();

		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

		click("Profile_Icon");
		Thread.sleep(1000);
		click("Admin_Console");
		Thread.sleep(1000);
		click("Users_&_Groups");
		Thread.sleep(1000);
		click("Admin_Group");
		Thread.sleep(1000);
		click("Group_3dots");
		Thread.sleep(1000);
		click("View_Group");
		click("Content_Access");
		Thread.sleep(2000);

		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(1000);
		String file2 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]")).getText();
		System.out.println(file2);

		
		if(file1.equals(file2))
		{


			log.info("--------------------------No of Shared Files name is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Edit_Permission_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission successfully","MyFiles_share_User_to_Group_Edit_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			Thread.sleep(2000); 
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Edit_Permissionn_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission failed","MyFiles_share_User_to_Group_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		click("Profile_Icon");
		Thread.sleep(1000);
		click("My_Files");

		click("shared_with_me");
		String file3 =driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]")).getText();
		System.out.println(file3);

		
		if(file1.equals(file3))
		{


			log.info("--------------------------No of Shared Files name is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath +"MyFiles_share_User_to_Group_Edit_Permission_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission successfully","MyFiles_share_User_to_Group_Edit_Permission",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			Thread.sleep(2000); 
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_share_User_to_Group_Edit_Permissionn_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_share_User_to_Group_Edit_Permission failed","MyFiles_share_User_to_Group_Edit_Permission",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_Out");
		click("Ok");
		
		WebDriverWait wait351 = new WebDriverWait(driver, 120);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
	}

	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Recent_Page_Share_to_Internal_User",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Share_to_Internal_User_failed_Error.png");
		ATUReports.add("MyFiles_Recent_Page_Share_to_Internal_User failed","MyFiles_Recent_Page_Share_to_Internal_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


		
		//------------------------------MyFiles_Recent_Page_Share_with_link_to_Internal_User--------------------------------


public static void MyFiles_Recent_Page_Share_with_link_to_Internal_User()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		click("recent_page");

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		click("click_preview");
		Thread.sleep(1000);
		click("Share_Icon");
		Thread.sleep(1000);

		WebElement noUserOr1 = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr1.sendKeys("li");

//		WebDriverWait wait311 = new WebDriverWait(driver, 60);
//		wait311.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
		getPageObject("search_result_first_element").click(); 

		select("shared_user_popup_sharelink_dropdown","visibletext","Edit"); 
		click("share_button");
		Thread.sleep(2000);
		click("share_button");
		
		Thread.sleep(1000);
		

		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied Successfully')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		click("toast_close");
		
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
	//	click("Ok");

		WebDriverWait wait3511 = new WebDriverWait(driver, 120);
		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		

//		Navigation.other_user_in_same_tenant();
//
//		driver.get(Home_Page);
//		WebDriverWait wait51 = new WebDriverWait(driver, 120);
//		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
//
//		Thread.sleep(2000);
//		click("shared_with_me");
//		Thread.sleep(2000);
//
//		click("Profile_Icon");
//		Thread.sleep(2000);
//		click("Sign_out");
//		Thread.sleep(1000);
//		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Recent_Page_Share_with_link_to_Internal_User",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Share_with_link_to_Internal_User_Error.png");
		ATUReports.add("MyFiles_Recent_Page_Share_with_link_to_Internal_User failed","MyFiles_Recent_Page_Share_with_link_to_Internal_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
  }


		//----------------------------MyFiles_Recent_Page_Copy------------------------------------


public static void MyFiles_Recent_Page_Copy()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		click("recent_page");

		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before Copy" + nooffiles);

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		click("Copy_Move");

		WebElement el =driver.findElement(By.xpath("//span[text()='My Drive']"));
		act.doubleClick(el).perform();

		getPageObject("Folder_Create").click();
		Thread.sleep(1000);
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String name= "Files Copy"+dateFormatted;

		log.info("Creating  name: "+name);

		sendKeys("Create_Folder_name",name);
		Thread.sleep(1000);
		click("Create_button");
		Thread.sleep(1000);
		getPageObject("Recent_Copy").click();
		Thread.sleep(2000);
		click("Close_Pop");
		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied')]")));
		Thread.sleep(1000);
		click("toast_close");
		click("Left_Back");
		Thread.sleep(1000);
		click("copy_mydrive");
		
		WebElement el11 =driver.findElement(By.xpath("//div[contains(text(),'Files Copy')]"));
		act.doubleClick(el11).perform();

		List<WebElement> Aftercopyfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Afterfiles = Aftercopyfiles.size();
		System.out.println("No of files After Copy" + Afterfiles);


		if( Afterfiles== 1)
		{


			log.info("--------------------------No of  file  is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Copy_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_Copy successfully","MyFiles_Recent_Page_Copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Copy_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_Copy failed","MyFiles_Recent_Page_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Recent_Page_Copy",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Copy_Error.png");
		ATUReports.add("MyFiles_Recent_Page_Copy  failed","MyFiles_Recent_Page_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


		//--------------------------------MyFiles_Recent_Page_Copy_Check_Versions----------------------



public static void MyFiles_Recent_Page_Copy_Check_Versions()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		click("recent_page");

		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before Copy" + nooffiles);

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Details_circle");
		Thread.sleep(1000);
	//	click("Saved_versions");
		getPageObject("Remainder_file_icon").isDisplayed();
		
		click("Left_Back");
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");


		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Recent_Page_Copy_Check_Versions",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Copy_Check_Versions_Error.png");
	ATUReports.add("MyFiles_Recent_Page_Copy_Check_Versions  failed","MyFiles_Recent_Page_Copy_Check_Versions",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


		//------------------------------MyFiles_Recent_Page_Add_Edit_Delete_Comments---------------------------


public static void MyFiles_Recent_Page_Add_Edit_Delete_Comments()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		click("recent_page");

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		Thread.sleep(1000);
		click("Add_comments");
		sendKeys("Text_area","ECS");
		Thread.sleep(1000);
		click("Save");
		WebDriverWait wait51 = new WebDriverWait(driver, 60);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully saved the comment')]")));
		Thread.sleep(1000);
		click("toast_close");
		click("Left_Back");

		//--Comments are Edited--

		WebElement right11=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right11).perform();
		Thread.sleep(1000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		Thread.sleep(1000);
		click("Add_comments");
		Thread.sleep(2000);
		getPageObject("Edit_3dots").click();
		Thread.sleep(1000);
		getPageObject("Edit").click();
		Thread.sleep(1000);
		getPageObject("Text_area_edit").clear();
		getPageObject("Text_area_edit").sendKeys("Test");
		click("Save");							
		WebDriverWait wait511 = new WebDriverWait(driver, 60);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully edited the comment')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		click("Left_Back");

		//--Comments are Deleted--

		WebElement right21=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right21).perform();
		Thread.sleep(1000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		Thread.sleep(1000);
		click("Add_comments");
		Thread.sleep(2000);
		getPageObject("Edit_3dots").click();
		Thread.sleep(1000);
		click("Delete");
		click("Ok");	
		WebDriverWait wait41 = new WebDriverWait(driver, 60);
		wait41.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully deleted the comments.')]")));
		Thread.sleep(1000);
		click("toast_close");
		click("Left_Back");
		Thread.sleep(1000);

		//Profile click and logout
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");


		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


		
}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Recent_Page_Add_Edit_Delete_Comments",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Add_Edit_Delete_Comments_Error.png");
	ATUReports.add("MyFiles_Recent_Page_Add_Edit_Delete_Comments  failed","MyFiles_Recent_Page_Add_Edit_Delete_Comments",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

	//--------------------------MyFiles_Recent_Page_Tag_Add_Edit_Delete-------------------------

public static void MyFiles_Recent_Page_Tag_Add_Edit_Delete()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		
	//	Actions act = new Actions(driver);
		click("recent_page");
		
		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		click("Add_View_Tags");
		Thread.sleep(1000);
		sendKeys("Add_Tag","Testing-1");
		click("Save");
		WebDriverWait wait511 = new WebDriverWait(driver, 60);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the tags successfully')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		click("Left_Back");
		
		// Editing Tag
		WebElement right11=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right11).perform();
		Thread.sleep(2000);
		click("click_preview");
		click("Three_Dots");
		click("Add_View_Tags");
//		sendKeys("Add_Tag","",Keys.BACK_SPACE);
		Thread.sleep(1000);
		sendKeys("Add_Tag","Testing-2");
		click("Save");
		Thread.sleep(1000);
		WebDriverWait wait5111 = new WebDriverWait(driver, 60);
		wait5111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the tags successfully')]")));
		Thread.sleep(1000);
		click("toast_close");
		click("Left_Back");
		Thread.sleep(1000);
		
		//  Deleting Tag
		WebElement right111=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right111).perform();
		Thread.sleep(2000);
		click("click_preview");
		click("Three_Dots");
		click("Add_View_Tags");
		Thread.sleep(1000);
		getPageObject("add_tag_input_field").sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
		click("Save");
		Thread.sleep(1000);
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait5111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the tags successfully')]")));
		Thread.sleep(1000);
		click("toast_close");
		click("Left_Back");
		Thread.sleep(1000);
		
		//Profile click and logout
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");


		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));



	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Recent_Page_Tag_Add_Edit_Delete",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Tag_Add_Edit_Delete_Error.png");
		ATUReports.add("MyFiles_Recent_Page_Tag_Add_Edit_Delete failed","MyFiles_Recent_Page_Tag_Add_Edit_Delete",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

		//--------------------------MyFiles_Recent_Page_Rename---------------------------

public static void MyFiles_Recent_Page_Rename()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		click("recent_page");
		
		WebElement right1=	driver.findElement(By.xpath("(//div[contains(text(),'New Word 1.docx')])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		Thread.sleep(1000);
		click("Rename");
		Thread.sleep(1000);
		getPageObject("rename_file_textarea").clear();
		sendKeys("Rename_input","Test 1");
		Thread.sleep(1000);
		click("Save"); 	

		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'New Word 1 Renamed to Test 1')]")));
		Thread.sleep(1000);
		click("toast_close");
		click("Left_Back");
		//Profile click and logout
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");


		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Recent_Page_Rename",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Rename_Error.png");
		ATUReports.add("MyFiles_Recent_Page_Rename failed","MyFiles_Recent_Page_Rename",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


		//-------------------MyFiles_Recent_Page_Add_File_to_Collection--------------------------------


public static void MyFiles_Recent_Page_Add_File_to_Collection()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		click("recent_page");
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before Moved " + nooffiles);
		click("select_all_files");
		
		for(int i=25; i<=nooffiles-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();
		}

		WebElement Files1 = driver.findElement(By.xpath("(//div[@class='fileName'])"));

		WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);

		WebElement Addtocollections =	driver.findElement(By.xpath("(//span[contains(text(),'Add to Collection')])[1]"));
		actions.moveToElement(Addtocollections).perform();
		Thread.sleep(2000);

		WebElement Create = driver.findElement(By.xpath("(//*[contains(text(),'Create New Collection')])"));
		Create.click();
		Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String collection_folder_name="collection "+dateFormatted;
		sendKeys("collections_name_textarea",collection_folder_name);

		click("Save");
		Thread.sleep(2000);
		WebElement close = driver.findElement(By.xpath("//div[text()='Added file(s) to the collection successfully!!']"));
		close.click();
		Thread.sleep(2000);
		click("collections");
		Thread.sleep(2000);

		WebElement ele11 = getPageObject("View");
		actions.doubleClick(ele11).perform();

		Thread.sleep(2000);

		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of files After Moved " + Aftermovedfilestofolder);

		if(Aftermovedfilestofolder==25)
		{


			log.info("--------------------------No of Select files is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Add_multiple_files_to_collection_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_Add_multiple_files_to_collection successfully","MyFiles_Recent_Page_Add_multiple_files_to_collection",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Add_multiple_files_to_collection_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Recent_Page_Add_multiple_files_to_collection failed","MyFiles_Recent_Page_Add_multiple_files_to_collection",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		click("recent_page");
		
		WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-footer'])[1]"));
		actions.contextClick(right1).perform();
		
		WebElement Addtocollections1 =	driver.findElement(By.xpath("//span[contains(text(),'Add to Collection')]"));
		actions.moveToElement(Addtocollections1).perform();
		
		Thread.sleep(1000);
		System.out.println(" Try to add files  "+"are Disable");
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");


		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));



	}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Recent_Page_Rename",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Recent_Page_Rename_Error.png");
			ATUReports.add("MyFiles_Recent_Page_Rename failed","MyFiles_Recent_Page_Rename",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
}





