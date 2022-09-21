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

public class MyFiles_List_view extends Navigation {
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_List_view.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_List_view(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_List_view");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_List_view--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view.png");
	}
	private void setAuthorInfoForReports()
	{
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription()
	{
		ATUReports.indexPageDescription = "MyFiles_List_view";
	}

	

		//---------------------MyFiles_List_view---------------------

	public static void MyFiles_List_view()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
			
			click("List_View");
			
			getPageObject("List_view_Name").isDisplayed();
			getPageObject("List_view_folder").isDisplayed();
			
			getPageObject("List_View_Owner").isDisplayed();
			getPageObject("List_View_Owner_name").isDisplayed();
			
			getPageObject("List_View_Create").isDisplayed();
			getPageObject("List_View_Create_DayTime").isDisplayed();
			
			getPageObject("List_View_Size").isDisplayed();
			getPageObject("List_View_Size_Foder").isDisplayed();
		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_List_view",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_failed_Error.png");
			ATUReports.add("MyFiles_List_view failed","MyFiles_List_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


		//-----------------------------MyFiles_List_view_Share_User-----------------------------------------
	public static void MyFiles_List_view_Share_User()
	{

		try
		{

			actions = new Actions(driver);
			Actions act = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
			
			click("List_View");
			click("Sorting_order");
			Thread.sleep(1000);
			WebElement ele = getPageObject("Folder_List_view");
			act.doubleClick(ele).perform();
			
			click("Cheak_Box");
			WebElement right=	driver.findElement(By.xpath("(//div[@class='fileName'])[5]"));
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
			
		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_List_view_Share_User",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Share_User_failed_Error.png");
			ATUReports.add("MyFiles_List_view_Share_User failed","MyFiles_List_view_Share_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}


		//--------------------------MyFiles_List_view_Add_comment_to_file---------------------------

 public static void MyFiles_List_view_Add_comment_to_file()
 {

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		click("List_View");
		click("Sorting_order");
		Thread.sleep(1000);
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		click("Sorting_order");	
		
		Thread.sleep(1000);
		WebElement right=	driver.findElement(By.xpath("(//div[@class='fileName'])[7]"));
		actions.contextClick(right).perform();
		Thread.sleep(3000);
		
	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Add_comment_to_file",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Add_comment_to_file_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Add_comment_to_file failed","MyFiles_List_view_Add_comment_to_file",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

		//-----------------------MyFiles_List_view_Add_comment_to_folder------------------------------

 public static void MyFiles_List_view_Add_comment_to_folder()
 {

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		click("List_View");
		click("Sorting_order");
		Thread.sleep(1000);
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		click("Sorting_order");	
				
		Thread.sleep(1000);
		WebElement right=	driver.findElement(By.xpath("(//div[@class='fileName'])[3]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		click("file_right_click_add_comment");
		sendKeys("Text_Area","List view");
		click("Save"); 	
		
		WebDriverWait wait51 = new WebDriverWait(driver, 60);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully saved the comment')]")));
		Thread.sleep(1000);
		click("toast_close");
		
	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Add_comment_to_folder",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Add_comment_to_folder_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Add_comment_to_folder failed","MyFiles_List_view_Add_comment_to_folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


		//--------------------MyFiles_List_view_Add_Tags_to_multiple_files_folders----------------------------
 
 public static void MyFiles_List_view_Add_Tags_to_multiple_files_folders()
 {

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		click("List_View");
		click("Sorting_order");
		Thread.sleep(1000);
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		click("Sorting_order");	
		click("Cheak_Box");		
		
		WebElement right=	driver.findElement(By.xpath("(//div[@class='fileName'])[3]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		click("right_click_add_tag");
		sendKeys("Add_Tag","Tag List view");
		click("Save"); 	
		
		WebDriverWait wait511 = new WebDriverWait(driver, 60);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated the tags successfully')]")));
		Thread.sleep(1000);
		click("toast_close");
		
	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Add_Tags_to_multiple_files_folders",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Add_Tags_to_multiple_files_folders_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Add_Tags_to_multiple_files_folders failed","MyFiles_List_view_Add_Tags_to_multiple_files_folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

		//----------------------MyFiles_List_view_Add_multiple_files_to_collection ----------------------------


public static void MyFiles_List_view_Add_multiple_files_to_collection()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		
		click("List_View");
		click("Sorting_order");
		Thread.sleep(1000);
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		click("Sorting_order");	
		
		WebElement ele1 = getPageObject("List_view_Collections");
		act.doubleClick(ele1).perform();
		click("Cheak_Box");
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		
		WebElement right=	driver.findElement(By.xpath("(//div[@class='fileName'])[4]"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		
		WebElement Addtocollections =	driver.findElement(By.xpath("//span[contains(text(),'Add to Collection')]"));
		actions.moveToElement(Addtocollections).perform();
		Thread.sleep(1000);

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
		WebDriverWait wait511 = new WebDriverWait(driver, 60);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Added file(s) to the collection successfully!!']")));
		Thread.sleep(1000);
		click("toast_close");
		
		Thread.sleep(2000);
		click("collections");
		Thread.sleep(2000);

		WebElement ele11 = getPageObject("View");
		act.doubleClick(ele11).perform();

		Thread.sleep(2000);

		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfilestocollections = Aftermovedfiles.size();
		System.out.println("No of files After Moved to Collections " + Aftermovedfilestocollections);
		
		if(Aftermovedfilestocollections==21)
		{
			log.info("--------------------------------------------No of  files is  equal to before--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Add_multiple_files_to_collection_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Add_multiple_files_to_collection successfully","MyFiles_List_view_Add_multiple_files_to_collection",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{

			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Add_multiple_files_to_collection_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Add_multiple_files_to_collection failed","MyFiles_List_view_Add_multiple_files_to_collection",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		
		
	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Add_multiple_files_to_collection",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Add_multiple_files_to_collection_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Add_multiple_files_to_collection failed","MyFiles_List_view_Add_multiple_files_to_collection",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}}