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
			String folder_name = getPageObject("List_view_folder").getText();
			if(folder_name==null || folder_name=="-")
			{
				ATUReports.add("MyFiles_List_view failed","MyFiles_List_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
			
			// //tbody/tr[1]/td[3]
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
			noUserOr.sendKeys("fa");
			
			
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
		Thread.sleep(1000);
		act.doubleClick(ele).perform();
		click("Sorting_order");	
		Thread.sleep(1000);
		WebElement ele1 = getPageObject("List_view_Collections");
		act.doubleClick(ele1).perform();
		Thread.sleep(3000);
		click("Cheak_Box");
		
		WebElement right=	driver.findElement(By.xpath("//tbody/tr[1]"));
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

		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//div[@class='fileName']"));
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
}


		//-----------------------------MyFiles_List_view_Multiple_files_and_folders_copy----------------------------------

public static void MyFiles_List_view_Multiple_files_and_folders_copy()
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
		WebElement ele = getPageObject("Copy_Versions_Test"); 
		Actions act1 = new Actions(driver);
		act1.doubleClick(ele).perform();
		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();

		Thread.sleep(3000);
		click("Cheak_Box");
		
		WebElement right=	driver.findElement(By.xpath("//tbody/tr[2]"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		click("file_right_click_copy_move");
		
		WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
		act.doubleClick(el).perform();
		
		WebElement el1 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'Copy Versions Test')]"));
		act.doubleClick(el1).perform();
		Thread.sleep(3000);
		
		getPageObject("Folder_Create").click();
		Thread.sleep(2000);
		click("Folder_Create");
		sendKeys("Create_Folder_name","Copy Test List View");
		Thread.sleep(2000);
		click("Create_button");
		Thread.sleep(2000);
		getPageObject("Recent_Copy").click();
		Thread.sleep(2000);
		click("Close_Pop");
		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied')]")));
		Thread.sleep(1000);
		click("toast_close");  
		Thread.sleep(2000);
		click("Sorting_order");	
		WebElement el11 =driver.findElement(By.xpath("//div[@title='Copy Test List View']"));
		act.doubleClick(el11).perform();
		
		// Delete One Folder
		WebElement right1=	driver.findElement(By.xpath("//tbody/tr[2]"));
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		click("Right_click_Trash");
		Thread.sleep(1000);
		click("Trash_Button");
		Thread.sleep(1000);
		WebDriverWait wait3511 = new WebDriverWait(driver, 60);
		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved to trash')]")));
		Thread.sleep(1000);
		click("toast_close"); 
		Thread.sleep(2000);
		
		// creating a folder
		click("Cheak_Box");
		WebElement right11=	driver.findElement(By.xpath("//tbody/tr[2]"));
		actions.contextClick(right11).perform();
		Thread.sleep(1000);
		click("file_right_click_copy_move");
		
		WebElement el111 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
		act.doubleClick(el111).perform();
		
		WebElement el1111 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'Copy Versions Test')]"));
		act.doubleClick(el1111).perform();
		Thread.sleep(2000);
		
		WebElement el211 =driver.findElement(By.xpath("//*[@class='cp-item-sec1']//span[contains(text(),'Copy Test List View')]"));
		act.doubleClick(el211).perform();
		Thread.sleep(2000);
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//div[@class='fileName']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before Copied " + nooffiles);
		
		getPageObject("Folder_Create").click();
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);
		String name= "List View Copy"+dateFormatted;
		log.info("Creating  name: "+name);

		sendKeys("Create_Folder_name",name);
		Thread.sleep(2000);
		click("Create_button");
		Thread.sleep(2000);
		getPageObject("Recent_Copy").click();
		Thread.sleep(3000);
		click("Close_Pop");
		WebDriverWait wait35111 = new WebDriverWait(driver, 60);
		wait35111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied')]")));
		Thread.sleep(1000);
		click("toast_close");  
		Thread.sleep(2000);
		
		WebElement right21=	driver.findElement(By.xpath("//tbody/tr[1]"));
		act.doubleClick(right21).perform();
		
		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of files After Copied " + Aftermovedfilestofolder);
		
		if(Aftermovedfilestofolder==12)
		{
			log.info("--------------------------No of files copied is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_files_and_folders_copy_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Multiple_files_and_folders_copy successfully","MyFiles_List_view_Multiple_files_and_folders_copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_files_and_folders_copy_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Multiple_files_and_folders_copy failed","MyFiles_List_view_Multiple_files_and_folders_copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Multiple_files_and_folders_copy",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_files_and_folders_copy_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Multiple_files_and_folders_copy failed","MyFiles_List_view_Multiple_files_and_folders_copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

		//---------------------------MyFiles_List_view_Multiple_files_and_folders_Move----------------------------


public static void MyFiles_List_view_Multiple_files_and_folders_Move()
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
		Thread.sleep(1000);
		click("Sorting_order");	
		Thread.sleep(1000);
		WebElement ele = getPageObject("Copy_Versions_Test"); 
		Actions act1 = new Actions(driver);
		act1.doubleClick(ele).perform();
		Thread.sleep(1000);
		click("Sorting_order");	
		Thread.sleep(1000);
		WebElement el211 =driver.findElement(By.xpath("//div[@title='Copy Test List View']"));
		act.doubleClick(el211).perform();
		Thread.sleep(2000);
		click("Sorting_order");	
		Thread.sleep(2000);
		
		WebElement el3 =driver.findElement(By.xpath("(//td)[1]"));
		act.doubleClick(el3).perform();
		Thread.sleep(2000);
		click("Cheak_Box");
		Thread.sleep(1000);
		
//		List<WebElement> Beforemovedfiles1 = driver.findElements(By.xpath("//div[@class='fileName']"));
//		int nooffiles1 = Beforemovedfiles1.size();
//		System.out.println("No of files Before Moved " + nooffiles1);
//		Thread.sleep(1000);
		
		WebElement right1=	driver.findElement(By.xpath("//tbody/tr[2]"));
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		click("file_right_click_copy_move");
		
		WebElement el111 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
		act.doubleClick(el111).perform();
		
		WebElement el1111 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'Copy Versions Test')]"));
		act.doubleClick(el1111).perform();
		Thread.sleep(2000);
		
		WebElement el2111 =driver.findElement(By.xpath("//*[@class='cp-item-sec1']//span[contains(text(),'Copy Test List View')]"));
		act.doubleClick(el2111).perform();
		Thread.sleep(2000);
		
		WebElement ele4 =driver.findElement(By.xpath("(//div[@class='cp-item-sec1']//span[@class='justify-start'])[7]"));
		act.doubleClick(ele4).perform();
		Thread.sleep(2000);
		
		getPageObject("Folder_Create").click();
		
		DateFormat dateFormat1 = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date1 = new Date();

		// Now format the date
		String dateFormatted1= dateFormat1.format(date1);
		String name1= "List View Move"+dateFormatted1;
		log.info("Creating  name: "+name1);

		sendKeys("Create_Folder_name",name1);
		Thread.sleep(2000);
		click("Create_button");
		Thread.sleep(2000);
		getPageObject("move_button").click();
		Thread.sleep(2000);
		click("Close_Pop");
		
		WebDriverWait wait351111 = new WebDriverWait(driver, 60);			
		wait351111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
		Thread.sleep(1000);
		click("toast_close");  
		Thread.sleep(2000);
		WebElement ele41 =driver.findElement(By.xpath("//div[@class='fileName']"));
		act.doubleClick(ele41).perform();
		Thread.sleep(3000);
		
		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of files After Moved " + Aftermovedfilestofolder);
		
		if(Aftermovedfilestofolder==12)
		{
			log.info("--------------------------No of files copied is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_files_and_folders_Move_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Multiple_files_and_folders_Move successfully","MyFiles_List_view_Multiple_files_and_folders_Move",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_files_and_folders_Move_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Multiple_files_and_folders_Move failed","MyFiles_List_view_Multiple_files_and_folders_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Multiple_files_and_folders_Move",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_files_and_folders_Move_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Multiple_files_and_folders_Move failed","MyFiles_List_view_Multiple_files_and_folders_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


		//--------------------------MyFiles_List_view_Multipe_Files_Download----------------------------

public static void MyFiles_List_view_Multipe_Files_Download()
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
		Thread.sleep(2000);
		WebElement ele1 = getPageObject("List_Multiple_files");
		act.doubleClick(ele1).perform();
		Thread.sleep(1000);
		click("Cheak_Box");		
		
		WebElement right=	driver.findElement(By.xpath("//tbody/tr[2]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		
		click("right_click_download");
		
		WebDriverWait wait511 = new WebDriverWait(driver, 60);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Depending on the file/folder size, download might take some time.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Multipe_Files_Download",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multipe_Files_Download_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Multipe_Files_Download failed","MyFiles_List_view_Multipe_Files_Download",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


//--------------------------MyFiles_List_view_Multipe_Folders_Download----------------------------

public static void MyFiles_List_view_Multipe_Folders_Download()
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
		click("Sorting_order");		
		Thread.sleep(1000);
		Thread.sleep(1000);
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		click("Sorting_order");	
		Thread.sleep(2000);
		WebElement ele1 = getPageObject("List_Multiple_folders");
		act.doubleClick(ele1).perform();
		Thread.sleep(1000);
		click("Cheak_Box");		
		
		WebElement right=	driver.findElement(By.xpath("//tbody/tr[2]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		click("right_click_download");
		
		WebDriverWait wait511 = new WebDriverWait(driver, 60);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Depending on the file/folder size, download might take some time.')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Multipe_Folders_Download",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multipe_Folders_Download_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Multipe_Folders_Download failed","MyFiles_List_view_Multipe_Folders_Download",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

		//----------------------MyFiles_List_view_Add_Remainder_File-----------------------------

public static void MyFiles_List_view_Add_Remainder_File()
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
		Thread.sleep(2000);
		WebElement ele1 = getPageObject("List_Multiple_files");
		act.doubleClick(ele1).perform();
		Thread.sleep(1000);
//		click("Cheak_Box");		
		
		WebElement right=	driver.findElement(By.xpath("//tbody/tr[1]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		
		click("add_reminder");
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
		getPageObject("List_Remainder_clock").isDisplayed();
		
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Add_Remainder_File",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Add_Remainder_File_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Add_Remainder_File failed","MyFiles_List_view_Add_Remainder_File",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

//----------------------MyFiles_List_view_Add_Remainder_Folder-----------------------------

public static void MyFiles_List_view_Add_Remainder_Folder()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		click("Sorting_order");
		Thread.sleep(1000);
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		click("Sorting_order");	
		Thread.sleep(2000);
		WebElement ele1 = getPageObject("List_Multiple_folders");
		act.doubleClick(ele1).perform();
		Thread.sleep(1000);
//		click("Cheak_Box");		
		
		WebElement right=	driver.findElement(By.xpath("//tbody/tr[1]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		
		click("add_reminder");
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
		getPageObject("List_Remainder_clock").isDisplayed();
		
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Add_Remainder_Folder",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Add_Remainder_Folder_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Add_Remainder_Folder failed","MyFiles_List_view_Add_Remainder_Folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


		//---------------------------MyFiles_List_view_File_view_versions-----------------------------


public static void MyFiles_List_view_File_view_versions()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();
		
		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		click("Sorting_order");
		
		click("List_View");
		Thread.sleep(1000);
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		click("Sorting_order");	
		Thread.sleep(2000);
		
		WebElement right1=	driver.findElement(By.xpath("//tbody/tr[12]"));
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		click("file_right_click_copy_move");
		
//		WebElement el111 =driver.findElement(By.xpath(""));
//		act.doubleClick(el111).perform();
		
		WebElement el14 =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
		act.doubleClick(el14).perform();
		
		WebElement el112 =driver.findElement(By.xpath("//span[normalize-space()='List_View']"));
		act.doubleClick(el112).perform();
		Thread.sleep(2000);
		
		WebElement el12 =driver.findElement(By.xpath("//span[normalize-space()='Multiple Files']"));
		act.doubleClick(el12).perform();
		
		click("Copy");
		WebElement el111 =driver.findElement(By.xpath("//div[@title='Multiple Files']"));
		act.doubleClick(el111).perform();
		
		WebElement right11=	driver.findElement(By.xpath("//tbody/tr[2]"));
		actions.contextClick(right11).perform();
		Thread.sleep(1000);
		click("View_version");
		Thread.sleep(1000);
		getPageObject("Current_Versions").isDisplayed();
		Thread.sleep(1000);
		click("view_Version_close");
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_File_view_versions",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_File_view_versions_failed_Error.png");
		ATUReports.add("MyFiles_List_view_File_view_versions failed","MyFiles_List_view_File_view_versions",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

	
		//-----------------------MyFiles_List_view_Multiple_Trash_Files------------------------------

public static void MyFiles_List_view_Multiple_Trash_Files()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();
		
		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		click("Sorting_order");
		
		click("List_View");
		Thread.sleep(1000);
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		click("Sorting_order");	
		Thread.sleep(2000);
		
		WebElement ele1 = getPageObject("Lish_Trash_Folder");
		act.doubleClick(ele1).perform();
		
		WebElement ele11 = getPageObject("Trash_Files_folder");
		act.doubleClick(ele11).perform();
		
		click("Cheak_Box");
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//div[@class='fileName']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		
		WebElement right11=	driver.findElement(By.xpath("//tbody/tr[2]"));
		actions.contextClick(right11).perform();
		Thread.sleep(1000);
		click("Right_click_Trash");
		click("Trash_Button");		
		
		WebDriverWait wait511 = new WebDriverWait(driver, 60);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved to trash')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		Thread.sleep(1000);
		click("Menu_Trash");
		
		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of files After " + Aftermovedfilestofolder);
		
		if(nooffiles==Aftermovedfilestofolder)
		{
			log.info("--------------------------No of  files is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_Trash_Files_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Multiple_Trash_Files successfully","MyFiles_List_view_Multiple_Trash_Files",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_Trash_Files_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Multiple_Trash_Files failed","MyFiles_List_view_Multiple_Trash_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Multiple_Trash_Files",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_Trash_Files_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Multiple_Trash_Files failed","MyFiles_List_view_Multiple_Trash_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

			//-------------------------MyFiles_List_view_Multiple_Trash_Folders-------------------------------------

public static void MyFiles_List_view_Multiple_Trash_Folders()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		Navigation.login();
		
		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'My Files')])[1]")));
		click("Sorting_order");
		
		click("List_View");
		Thread.sleep(1000);
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		click("Sorting_order");	
		Thread.sleep(2000);
		
		WebElement ele1 = getPageObject("Lish_Trash_Folder");
		act.doubleClick(ele1).perform();
		
		WebElement ele11 = getPageObject("Trash_Folders_folder");
		act.doubleClick(ele11).perform();
		
		click("Cheak_Box");
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//div[@class='fileName']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		
		WebElement right11=	driver.findElement(By.xpath("//tbody/tr[2]"));
		actions.contextClick(right11).perform();
		Thread.sleep(1000);
		click("Right_click_Trash");
		click("Trash_Button");		
		
		WebDriverWait wait511 = new WebDriverWait(driver, 60);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved to trash')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		click("Menu_Trash");
		
		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//div[@class='fileName']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of files After " + Aftermovedfilestofolder);
		
		if(nooffiles==Aftermovedfilestofolder)
		{
			log.info("--------------------------No of  files is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_Trash_Folders_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Multiple_Trash_Folders successfully","MyFiles_List_view_Multiple_Trash_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_Trash_Folders_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_List_view_Multiple_Trash_Folders failed","MyFiles_List_view_Multiple_Trash_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_List_view_Multiple_Trash_Folders",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_List_view_Multiple_Trash_Folders_failed_Error.png");
		ATUReports.add("MyFiles_List_view_Multiple_Trash_Folders failed","MyFiles_List_view_Multiple_Trash_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}
}