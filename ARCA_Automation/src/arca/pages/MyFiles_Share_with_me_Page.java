package arca.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class MyFiles_Share_with_me_Page extends Navigation {
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_Share_with_me_Page.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Share_with_me_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Share_with_me_Page");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Share_with_me_Page--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page.png");
	}
	private void setAuthorInfoForReports()
	{
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() 
	{
		ATUReports.indexPageDescription = "MyFiles_Share_with_me_Page";
	}


		//--------------MyFiles_Share_with_me_Page_Share_multiple_Files_and_Folder---------------------
	
	public static void MyFiles_Share_with_me_Page_Share_multiple_Files_and_Folder() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.other_user_in_same_tenant();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			
			getPageObject("Share_with_me_folder").click();
			WebElement right  =	getPageObject("Share_with_me_folder");
			actions.contextClick(right).perform();
			click("Share");
			Thread.sleep(2000);
			
			WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
			noUserOr.sendKeys("ce");
			
			
			WebDriverWait wait31 = new WebDriverWait(driver, 60);
			wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
				
			getPageObject("search_result_first_element").click(); 
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
			click("share_button");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shared successfully.']")));
			Thread.sleep(2000);
			click("toast_close");
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			
			WebDriverWait wait35 = new WebDriverWait(driver, 120);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
			
			Navigation.login();

			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			
			click("shared_with_me");
			Thread.sleep(1000);
			getPageObject("Share_with_me_folder").isDisplayed();
			
			WebElement els =getPageObject("Share_with_me_folder");
			actions.doubleClick(els).perform();
			
			click("select_all_folders");
			Thread.sleep(1000);
			click("select_all_files");
			
			WebElement right1  =  driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
			actions.contextClick(right1).perform();
			Thread.sleep(1000);
			click("Share");
			Thread.sleep(2000);
			
			WebElement noUserOr1 = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
			noUserOr1.sendKeys("ba");
			
			
			WebDriverWait wait311 = new WebDriverWait(driver, 60);
			wait311.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
				
			getPageObject("search_result_first_element").click(); 
			Thread.sleep(2000);
			click("share_button");
			Thread.sleep(1000);
			click("share_button");
			WebDriverWait wait2221 = new WebDriverWait(driver, 60);
			wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shared successfully.']")));
			Thread.sleep(2000);
			click("toast_close");
			
			Thread.sleep(2000);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			click("Ok");
			
			WebDriverWait wait351 = new WebDriverWait(driver, 120);
			wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

			
		}
		catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_share_User_to_Group_Edit_Permission",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Share_multiple_Files_and_Folder_Error.png");
			ATUReports.add("MyFiles_Share_with_me_Page_Share_multiple_Files_and_Folder failed","MyFiles_Share_with_me_Page_Share_multiple_Files_and_Folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}	

		//-----------------------MyFiles_Share_with_me_Page_Share_Add_comment_File_Folder-----------------------

	
public static void MyFiles_Share_with_me_Page_Share_Add_comment_File_Folder() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		getPageObject("shared_with_me").click();
		
		WebElement els =getPageObject("Share_with_me_folder");
		actions.doubleClick(els).perform();
		// Adding Folder comment 
		WebElement right=	driver.findElement(By.xpath("(//article[@class='folder-article'])[2]"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		click("Add_Comment");
		String s1 ="SharewithFolder";
		sendKeys("Text_area_comments",s1);
		click("Save");
		getPageObject("comment").isDisplayed();
		//Here Toast message is a confirmation Verification
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully saved the comment.')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		click("toast_close");
		driver.navigate().refresh();
		
		// Files Right click
		WebElement right1=	driver.findElement(By.xpath("(//div[@class='fileName'])[2]"));
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		click("add_comment_share");
		String s11 ="SharewithFile";
		sendKeys("Text_area_comments",s11);
		click("Save");
		getPageObject("comment").isDisplayed();
		//Here Toast message is a confirmation Verification
		WebDriverWait wait511 = new WebDriverWait(driver, 120);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully saved the comment.')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		click("toast_close");

		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e)
	{

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Share_with_me_Page_Share_Add_comment_File_Folder",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Share_Add_comment_File_Folder_Error.png");
		ATUReports.add("MyFiles_Share_with_me_Page_Share_Add_comment_File_Folder failed","MyFiles_Share_with_me_Page_Share_Add_comment_File_Folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}	

		//-------------------------MyFiles_Share_with_me_Page_Add_Tag_Multiple_files_Folders---------------------------

public static void MyFiles_Share_with_me_Page_Add_Tag_Multiple_files_Folders() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		getPageObject("shared_with_me").click();
		
		WebElement els =getPageObject("Share_with_me_folder");
		actions.doubleClick(els).perform();
		
		click("select_all_folders");
		click("select_all_files");
		WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		click("right_click_add_tag");
		sendKeys("Add_Tag","Share Demo");
		Thread.sleep(1000);
		click("Save");

		//Here Toast message is a confirmation Verification
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Updated the tags successfully.']")));
		Thread.sleep(1000);
		click("toast_close");

		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e)
	{
		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Share_with_me_Page_Add_Tag_Multiple_files_Folders",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Add_Tag_Multiple_files_Folders_Error.png");
		ATUReports.add("MyFiles_Share_with_me_Page_Add_Tag_Multiple_files_Folders failed","MyFiles_Share_with_me_Page_Add_Tag_Multiple_files_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}	

		//---------------------MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections--------------------------

public static void MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		getPageObject("shared_with_me").click();
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		click("select_all_files");
		
		WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
		actions.contextClick(right).perform();

		WebElement Addtocollections =	driver.findElement(By.xpath("//span[contains(text(),'Add to Collection')]"));
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
		WebElement close = driver.findElement(By.xpath("//div[text()='Added file(s) to the collection successfully.']"));
		close.click();
		Thread.sleep(2000);
		click("collections");
		Thread.sleep(2000);

		WebElement ele11 = getPageObject("View");
		act.doubleClick(ele11).perform();

		Thread.sleep(2000);

		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfilestocollections = Aftermovedfiles.size();
		System.out.println("No of files After to Collections " + Aftermovedfilestocollections);
		
		if(Aftermovedfilestocollections==nooffiles)
		{
			log.info("--------------------------------------------No of  files is  equal to before--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections successfully","MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections failed","MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
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
	log.error("Error in MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections failed","MyFiles_Share_with_me_Page_Add_multiple_Files_To_Collections",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//-------------------------MyFiles_Share_with_me_Page_Guest_Account_Sharing-----------------------------

public static void MyFiles_Share_with_me_Page_Guest_Account_Sharing() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		getPageObject("shared_with_me").click();
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		click("select_all_files");
		
		List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int Beforemovedfolderstofolder = Beforemovedfolders.size();
		System.out.println("No of Folder Before " + Beforemovedfolderstofolder);
		
		click("select_all_folders");
		
		WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		WebElement mv = getPageObject("external_sharing");
		actions.moveToElement(mv).perform();
		Thread.sleep(1000);
		getPageObject("guest_user_account").click();
		Thread.sleep(1000);
		
		WebElement noUserOr = driver.findElement(By.xpath("//input[@id='shareToGuestAccounts']"));
		noUserOr.sendKeys("ke");
	//	sendKeys("Guest_user_text_area","ra");
		
		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
			
		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
//		click("share_button");
				
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Shared successfully.')]")));
		click("toast_close");
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		Thread.sleep(4000);
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		Navigation.external_guest_user();
//		driver.get(Guest_Home_Page);
		
		WebDriverWait wait6 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

		List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfiles1 = Aftermovedfiles2.size();
		System.out.println("No of files Shared" + Aftermovedfiles1);
		
		if(Aftermovedfiles1==nooffiles)
		{
			log.info("--------------------------No of Shared files is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing successfully","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing failed","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		
		List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
		int	Aftermovedfolderstofolder = Aftermovedfolders .size();
		System.out.println("No of folders Shared" + Aftermovedfolderstofolder);

		if(Aftermovedfolderstofolder==Beforemovedfolderstofolder)
		{


		log.info("--------------------------No of Shared folders is  equal to before------------------------------");

		captureScreenShot(ScreenShotsFilePath +"MyFiles_Share_with_me_Page_Guest_Account_Sharing_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing successfully","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		Thread.sleep(2000); 
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing failed","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		
		
		WebDriverWait wait351 = new WebDriverWait(driver, 120);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
}
catch (Exception e)
{
	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Share_with_me_Page_Guest_Account_Sharing",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing failed","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//----------------------MyFiles_Share_with_me_Page_Share_file_via_link-----------------------------

public static void MyFiles_Share_with_me_Page_Share_file_via_link() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		getPageObject("shared_with_me").click();
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		
		WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[2]"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		WebElement mv = getPageObject("external_sharing");
		actions.moveToElement(mv).perform();
		Thread.sleep(1000);
		getPageObject("external_link_sharing").click();
		Thread.sleep(1000);
		sendKeys("external_link_sharing_name","FileShare");
		Thread.sleep(1000);
		sendKeys("external_link_sharing_password","Password");
		Thread.sleep(1000);
		sendKeys("external_link_sharing_reenter_password","Password");
		Thread.sleep(1000);
		click("calender");
		Thread.sleep(1000);
		
		getPageObject("Next_Year_icon").click();
		
		
//		getPageObject("Future_Date").click();
		
		getPageObject("external_link_edit_toggle_bar").click();
		Thread.sleep(1000);
		getPageObject("external_link_sharing_generate_link").click();
		Thread.sleep(1000);

		Thread.sleep(1000);
}
catch (Exception e)
{
	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Share_with_me_Page_Share_file_via_link",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Share_file_via_link_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Share_file_via_link failed","MyFiles_Share_with_me_Page_Share_file_via_link",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//---------------------MyFiles_Share_with_me_Page_Share_Folder_via_link------------------------

public static void MyFiles_Share_with_me_Page_Share_Folder_via_link() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		getPageObject("shared_with_me").click();
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		
		WebElement right=	driver.findElement(By.xpath("(//*[@class='folder-article'])[2]"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		WebElement mv = getPageObject("external_sharing");
		actions.moveToElement(mv).perform();
		Thread.sleep(1000);
		getPageObject("external_link_sharing").click();
		Thread.sleep(1000);
		sendKeys("external_link_sharing_name","FileShare");
		Thread.sleep(1000);
		sendKeys("external_link_sharing_password","Password");
		Thread.sleep(1000);
		sendKeys("external_link_sharing_reenter_password","Password");
		Thread.sleep(1000);
		click("calender");
		Thread.sleep(1000);
		
		getPageObject("Next_Year_icon").click();
		
		
//		getPageObject("Future_Date").click();
		
		getPageObject("external_link_edit_toggle_bar").click();
		Thread.sleep(1000);
		getPageObject("external_link_sharing_generate_link").click();
		Thread.sleep(1000);

		Thread.sleep(1000);
}
catch (Exception e)
{
	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Share_with_me_Page_Share_Folder_via_link",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Share_Folder_via_link_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Share_Folder_via_link failed","MyFiles_Share_with_me_Page_Share_Folder_via_link",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//-----------------------MyFiles_Share_with_me_Page_Multiple_files_and_folders_copy----------------------------

public static void MyFiles_Share_with_me_Page_Multiple_files_and_folders_copy() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("Plus-Buttom");
		getPageObject("Plus_New_Folder").click();
		
		String single_folder_name="Copy-Share with me";
		sendKeys("Create-FolderName",single_folder_name);
		Thread.sleep(1000);
		click("Ok");
		Thread.sleep(2000);
		
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Folder is created successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		
		click("shared_with_me");
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		Thread.sleep(1000);
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		click("select_all_files");
		
		List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int Beforemovedfolderstofolder = Beforemovedfolders.size();
		System.out.println("No of Folder Before " + Beforemovedfolderstofolder);
		click("select_all_folders");
		
		WebElement right=	driver.findElement(By.xpath("//div[@class='files-info']"));
		actions.contextClick(right).perform();
		click("file_right_click_copy_move");
		
		WebElement els1 =getPageObject("Right_click_MyFiles");
		actions.doubleClick(els1).perform();
		Thread.sleep(1000);
		
		WebElement els11 =getPageObject("Right_click_copy_share_with_me");
		actions.doubleClick(els11).perform();
		Thread.sleep(1000);
		
		getPageObject("Folder_Create").click();
		Thread.sleep(2000);
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String name= "MyFileShare-Copy"+dateFormatted;

		log.info("Creating  name: "+name);

		sendKeys("Create_Folder_name",name);
		Thread.sleep(2000);
		click("Create_button");
		Thread.sleep(1000);
		click("MyDrive_Copy");
		Thread.sleep(2000);
		click("Close_Pop");
		
		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied.')]")));
		Thread.sleep(1000);
		click("toast_close");  
		
		Thread.sleep(1000);
		getPageObject("Menu_MyFiles").click();
		Thread.sleep(1000);
		
		WebElement el11 = getPageObject("Folder_copy_share_with_me");
		act.doubleClick(el11).perform();
		Thread.sleep(1000);

		WebElement el111 = getPageObject("Single_Folder_click");
		act.doubleClick(el111).perform();
		Thread.sleep(1000);
		
		List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfiles1 = Aftermovedfiles2.size();
		System.out.println("No of files Aftter Copied " + Aftermovedfiles1);
		
		if(Aftermovedfiles1==nooffiles)
		{
			log.info("--------------------------No of Shared files is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing successfully","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing failed","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		
		List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
		int	Aftermovedfolderstofolder = Aftermovedfolders .size();
		System.out.println("No of folders After Copied " + Aftermovedfolderstofolder);

		if(Aftermovedfolderstofolder==Beforemovedfolderstofolder)
		{


		log.info("--------------------------No of Shared folders is  equal to before------------------------------");

		captureScreenShot(ScreenShotsFilePath +"MyFiles_Share_with_me_Page_Guest_Account_Sharing_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing successfully","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		Thread.sleep(2000); 
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing failed","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

		click("shared_with_me");
		
		WebElement els2 =getPageObject("Share_with_me_folder");
		actions.doubleClick(els2).perform();
		Thread.sleep(1000);
		List<WebElement> Beforemovedfiles1 = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles1 = Beforemovedfiles1.size();
		System.out.println("No of files Before " + nooffiles1);
		click("select_all_files");
		
		List<WebElement> Beforemovedfolders1 = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int Beforemovedfolderstofolder1 = Beforemovedfolders1.size();
		System.out.println("No of Folder Before " + Beforemovedfolderstofolder1);
		click("select_all_folders");
		
		WebElement right1=	driver.findElement(By.xpath("//div[@class='files-info']"));
		actions.contextClick(right1).perform();
		click("file_right_click_copy_move");
		
		WebElement els3 =getPageObject("Share_with_me");
		actions.doubleClick(els3).perform();
		Thread.sleep(1000);
		
		WebElement els4 =getPageObject("MyFiles_share_user_Admin");
		actions.doubleClick(els4).perform();
		Thread.sleep(1000);
		
		getPageObject("Folder_Create").click();
		Thread.sleep(2000);
		
		DateFormat dateFormat1 = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date1 = new Date();

		// Now format the date
		String dateFormatted1= dateFormat1.format(date1);

		String name1= "Share-Copy"+dateFormatted1;

		log.info("Creating  name: "+name1);

		sendKeys("Create_Folder_name",name1);
		Thread.sleep(2000);
		click("Create_button");
		Thread.sleep(1000);
		click("MyDrive_Copy");
		Thread.sleep(2000);
		click("Close_Pop");
		
		WebDriverWait wait3511 = new WebDriverWait(driver, 60);
		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied.')]")));
		Thread.sleep(1000);
		click("toast_close");  
		Thread.sleep(1000);
		click("shared_with_me");
		
		WebElement els21 =getPageObject("Share_with_me_folder");
		actions.doubleClick(els21).perform();
		Thread.sleep(1000);
		click("Sorting_order");
		Thread.sleep(1000);
		WebElement els211 =getPageObject("Single_Folder_click");
		actions.doubleClick(els211).perform();
		Thread.sleep(1000);
		
		List<WebElement> Aftermovedfiles21 = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfiles11 = Aftermovedfiles21.size();
		System.out.println("No of files Aftter Copied " + Aftermovedfiles11);
		
		if(Aftermovedfiles11==nooffiles1)
		{
			log.info("--------------------------No of Shared files is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing successfully","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing failed","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		
		List<WebElement> Aftermovedfolders1 =driver.findElements(By.xpath("//*[@class='folder-article']"));
		int	Aftermovedfolderstofolder1 = Aftermovedfolders1 .size();
		System.out.println("No of folders After Copied " + Aftermovedfolderstofolder1);

		if(Aftermovedfolderstofolder1==Beforemovedfolderstofolder1)
		{


		log.info("--------------------------No of Shared folders is  equal to before------------------------------");

		captureScreenShot(ScreenShotsFilePath +"MyFiles_Share_with_me_Page_Guest_Account_Sharing_success.png");
		Thread.sleep(2000);
		ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing successfully","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		Thread.sleep(2000); 
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Guest_Account_Sharing_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Guest_Account_Sharing failed","MyFiles_Share_with_me_Page_Guest_Account_Sharing",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		
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
	log.error("Error in MyFiles_Share_with_me_Page_Multiple_files_and_folders_copy",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_files_and_folders_copy_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Multiple_files_and_folders_copy failed","MyFiles_Share_with_me_Page_Multiple_files_and_folders_copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//------------------------MyFiles_Share_with_me_Page_Multiple_files_Download--------------------------

public static void MyFiles_Share_with_me_Page_Multiple_files_Download() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("shared_with_me");
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		Thread.sleep(1000);
		// Before List of Files
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		
		click("select_all_files");
		Thread.sleep(1000);
		WebElement right1=	driver.findElement(By.xpath("//div[@class='files-info']"));
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		click("Downloads");
		Thread.sleep(1000);
		WebDriverWait wait3511 = new WebDriverWait(driver, 60);
		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Depending on the file/folder size, download might take some time. ')]")));
		Thread.sleep(1000);
		click("toast_close");  
		Thread.sleep(2000);
		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_Multiple_files_Download",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_files_Download_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Multiple_files_Download failed","MyFiles_Share_with_me_Page_Multiple_files_Download",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//--------------------MyFiles_Share_with_me_Page_Multiple_folders_Download--------------------------

public static void MyFiles_Share_with_me_Page_Multiple_folders_Download() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("shared_with_me");
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		Thread.sleep(1000);
		// Before List of Files
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		
		click("select_all_folders");
		Thread.sleep(1000);
		WebElement right1=	driver.findElement(By.xpath("//div[@class='files-info']"));
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		click("Downloads");
		Thread.sleep(1000);
		WebDriverWait wait3511 = new WebDriverWait(driver, 60);
		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Depending on the file/folder size, download might take some time. ')]")));
		Thread.sleep(1000);
		click("toast_close");  
		Thread.sleep(2000);
		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_Multiple_folders_Download",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_folders_Download_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Multiple_folders_Download failed","MyFiles_Share_with_me_Page_Multiple_folders_Download",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//------------------------MyFiles_Share_with_me_Page_Add_Remainder_Files_Folders---------------------------
public static void MyFiles_Share_with_me_Page_Add_Remainder_Files_Folders() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("shared_with_me");
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		Thread.sleep(1000);
		click("select_all_folders");
		Thread.sleep(1000);
		
		WebElement right1=	driver.findElement(By.xpath("//*[@class='folder-article']"));
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		
		click("Add_Remainder");
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String reminder_name= "Share Folder Remainder "+dateFormatted;

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
		wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Reminder added successfully.')]")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(2000);
		
		// Below Added Files Remainder
		driver.navigate().refresh();
		Thread.sleep(1000);	
		click("shared_with_me");
		Thread.sleep(1000);
		WebElement els1 =getPageObject("Share_with_me_folder");
		actions.doubleClick(els1).perform();
		Thread.sleep(1000);
		click("select_all_files");
		Thread.sleep(1000);
		
		WebElement right11=	driver.findElement(By.xpath("//*[@class='files-footer']"));
		actions.contextClick(right11).perform();
		Thread.sleep(1000);
		
		click("Add_Remainder");
		Thread.sleep(1000);

		DateFormat dateFormat1 = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date1 = new Date();

		// Now format the date
		String dateFormatted1= dateFormat1.format(date1);

		String reminder_name1= "Share Files Remainder "+dateFormatted1;

		log.info("Creating reminder name: "+reminder_name1);

		sendKeys("reminder_name",reminder_name1);

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

		WebDriverWait wait221 = new WebDriverWait(driver, 60);
		wait221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Reminder added successfully.')]")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(2000);
		
		
		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_Add_Remainder_Files_Folders",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Add_Remainder_Files_Folders_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Add_Remainder_Files_Folders failed","MyFiles_Share_with_me_Page_Add_Remainder_Files_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//---------------------MyFiles_Share_with_me_Page_Rename_File_Folder--------------------------

public static void MyFiles_Share_with_me_Page_Rename_File_Folder() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("shared_with_me");
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		Thread.sleep(1000);
		
		WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
		actions.contextClick(right1).perform();
		
		click("File_Rename");
		getPageObject("rename_file_textarea").clear();
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		sendKeys("Rename_input","File_Share"+dateFormatted);
		click("Save");
		Thread.sleep(1000);
		// Toast message cannot change (Due time time changes 
		WebDriverWait wait22 = new WebDriverWait(driver, 60);
		wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		
		// Below Folder Name is Changed
		driver.navigate().refresh();
		
		WebElement right11=	driver.findElement(By.xpath("(//div[@class='folder-name'])[1]"));
		actions.contextClick(right11).perform();
		
		click("File_Rename");
		getPageObject("rename_file_textarea").clear();
		DateFormat dateFormat1 = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date1 = new Date();

		// Now format the date
		String dateFormatted1= dateFormat1.format(date1);

		sendKeys("Rename_input","Folder_Share"+dateFormatted1);
		click("Save");
		Thread.sleep(1000);
		// Toast message cannot change (Due time time changes 
		WebDriverWait wait221 = new WebDriverWait(driver, 60);
		wait221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
		Thread.sleep(1000);
		click("toast_close");

		
		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_Rename_File_Folder",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Rename_File_Folder_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Rename_File_Folder failed","MyFiles_Share_with_me_Page_Rename_File_Folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//------------------------MyFiles_Share_with_me_Page_File_view_versions------------------------------

public static void MyFiles_Share_with_me_Page_File_view_versions() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("shared_with_me");
		
		WebElement els =getPageObject("Share_with_me_folder");
		Actions act = new Actions(driver);
		actions.doubleClick(els).perform();
		Thread.sleep(1000);
		
		List<WebElement> BeforemovedMulti_files =driver.findElements(By.xpath("(//div[@class='files-info'])"));
		int	AftermovedMulti_files1 = BeforemovedMulti_files.size();
		System.out.println("No of Files " + BeforemovedMulti_files);

		for(int i=1; i<=AftermovedMulti_files1; i++)
		{
			WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])["+i+"]"));
			actions.contextClick(right1).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@id='menuPopover']//span[contains(text(),'View Versions')])["+i+"]")).click();
			// click("View_Versions");
			driver.findElement(By.xpath("//b[contains(text(),'Current Version')]")).isDisplayed();
			Thread.sleep(2000);
			click("view_Version_close");
			Thread.sleep(2000);
		}

		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_File_view_versions",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_view_versions_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_File_view_versions failed","MyFiles_Share_with_me_Page_File_view_versions",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//------------------------MyFiles_Share_with_me_Page_Multiple_files_folders_Trash------------------------------

public static void MyFiles_Share_with_me_Page_Multiple_files_folders_Trash() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.other_user_in_same_tenant();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		getPageObject("MyFiles_share_user_admin_trash").click();
		WebElement right  =	getPageObject("MyFiles_share_user_admin_trash");
		actions.contextClick(right).perform();
		click("Share");
		Thread.sleep(2000);
		
		WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr.sendKeys("ce");
		
		
		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
			
		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		click("share_button");
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shared successfully.']")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		// AdminConsole login
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("shared_with_me");
		
		WebElement trs =getPageObject("MyFiles_share_user_admin_trash");
		actions.doubleClick(trs).perform();
		
		click("select_all_folders");
		click("select_all_files");
		
		WebElement right1  =	getPageObject("Second_File");
		actions.contextClick(right1).perform();
		
		click("Right_click_Trash");
		click("Trash_Button");

		WebDriverWait wait2221 = new WebDriverWait(driver, 60);
		wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved to trash.')]")));
		Thread.sleep(2000);
		click("toast_close");
		
		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_Multiple_files_folders_Trash",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_files_folders_Trash_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Multiple_files_folders_Trash failed","MyFiles_Share_with_me_Page_Multiple_files_folders_Trash",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//--------------------------MyFiles_Share_with_me_Page_User_Multiple_files_copy--------------------------

public static void MyFiles_Share_with_me_Page_User_Multiple_files_copy() 
{

	try
	{

		actions = new Actions(driver);
		
		Navigation.other_user_in_same_tenant();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		getPageObject("User_share_Copy_Folder").click();
		WebElement right  =	getPageObject("User_share_Copy_Folder");
		actions.contextClick(right).perform();
		click("Share");
		Thread.sleep(2000);
		
		WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr.sendKeys("ce");
		
		
		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
			
		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		click("share_button");
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shared successfully.']")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		// AdminConsole login
		Navigation.login();

		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		click("Plus-Buttom");
		Thread.sleep(1000);
		getPageObject("Plus_New_Folder").click();
		Thread.sleep(1000);
		sendKeys("ente_folder_name","Admin Share Copy");
		click("Ok");
		
		WebDriverWait wait2221 = new WebDriverWait(driver, 60);
		wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Folder is created successfully.')]")));
		Thread.sleep(2000);
		click("toast_close");
		
		Thread.sleep(1000);
		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_share_Copy_Folder");
		actions.doubleClick(trs).perform();	
//		click("select_all_folders");
		Thread.sleep(1000);
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		
		click("select_all_files");
		Thread.sleep(1000);
		WebElement right1  =	getPageObject("Second_File");
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		click("file_right_click_copy_move");
		
		WebElement trs1 =getPageObject("Right_click_MyFiles");
		actions.doubleClick(trs1).perform();
		Thread.sleep(1000);
		WebElement trs11 =getPageObject("Right_click_share_admin_folder");
		actions.doubleClick(trs11).perform();
		Thread.sleep(1000);
		getPageObject("Share_right_click_Folder_click").click();
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String collection_folder_name="Share MFiles copy "+dateFormatted;
		
		sendKeys("Create_Folder_name",collection_folder_name);
		
		Thread.sleep(1000);
		click("Create_button");
		Thread.sleep(1000);
		click("Recent_Copy");
		Thread.sleep(2000);
		click("Close_Pop");
		
		WebDriverWait wait22211 = new WebDriverWait(driver, 60);
		wait22211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied.')]")));
		Thread.sleep(2000);
		click("toast_close");
		
		WebDriverWait wait511 = new WebDriverWait(driver, 120);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		WebElement els =getPageObject("My_Files");
		actions.doubleClick(els).perform();
		
		WebElement els1 =getPageObject("Admin_share_copy");
		actions.doubleClick(els1).perform();
		
		WebElement els11 =getPageObject("Single_Folder_click");
		actions.doubleClick(els11).perform();
		
		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of files After " + Aftermovedfilestofolder);

		if(Aftermovedfilestofolder==nooffiles)
		{
			log.info("--------------------------No of  files is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_User_Multiple_files_copy_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_User_Multiple_files_copy successfully","MyFiles_Share_with_me_Page_User_Multiple_files_copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_User_Multiple_files_copy_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_User_Multiple_files_copy failed","MyFiles_Share_with_me_Page_User_Multiple_files_copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
	
		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_User_Multiple_files_copy",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_User_Multiple_files_copy_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_User_Multiple_files_copy failed","MyFiles_Share_with_me_Page_User_Multiple_files_copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//-------------------------MyFiles_Share_with_me_Page_User_Multiple_folders_copy-------------------------


public static void MyFiles_Share_with_me_Page_User_Multiple_folders_copy() 
{

	try
	{

		actions = new Actions(driver);
				
		Navigation.login();
		
		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_share_Copy_Folder");
		actions.doubleClick(trs).perform();	
		Thread.sleep(1000);
		
		List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int nooffolders = Beforemovedfolders.size();
		System.out.println("No of files Before " + nooffolders);
		
		click("select_all_folders");
		Thread.sleep(1000);
		WebElement right1  =getPageObject("second_folder_infolder");
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		
		click("file_right_click_copy_move");
		
		WebElement trs1 =getPageObject("Right_click_MyFiles");
		actions.doubleClick(trs1).perform();
		Thread.sleep(1000);
		
		WebElement trs11 =getPageObject("Right_click_share_admin_folder");
		actions.doubleClick(trs11).perform();
		Thread.sleep(2000);
		
		getPageObject("Share_right_click_Folder_click").click();
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String collection_folder_name="Share MFolder copy "+dateFormatted;
		
		sendKeys("Create_Folder_name",collection_folder_name);
		
		Thread.sleep(1000);
		click("Create_button");
		Thread.sleep(2000);
		click("Recent_Copy");
		Thread.sleep(2000);
		click("Close_Pop");
		Thread.sleep(2000);
		WebDriverWait wait22211 = new WebDriverWait(driver, 60);
		wait22211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied.')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);	
		
		WebElement els =getPageObject("My_Files");
		actions.doubleClick(els).perform();
		Thread.sleep(1000);	
		
		WebElement els1 =getPageObject("Admin_share_copy");
		actions.doubleClick(els1).perform();
		Thread.sleep(1000);		
		
		click("Sorting_order");
		WebElement els11 =getPageObject("Single_Folder_click");
		actions.doubleClick(els11).perform();
		
		List<WebElement> Aftermovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int Aftermovedfolderstofolder = Aftermovedfolders.size();
		System.out.println("No of folders After " + Aftermovedfolderstofolder);

		if(Aftermovedfolderstofolder==nooffolders)
		{
			log.info("--------------------------No of  Folders is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_User_Multiple_folders_copy_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_User_Multiple_folders_copy successfully","MyFiles_Share_with_me_Page_User_Multiple_folders_copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_User_Multiple_folders_copy_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_User_Multiple_folders_copy failed","MyFiles_Share_with_me_Page_User_Multiple_folders_copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
	
		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_User_Multiple_folders_copy",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_User_Multiple_folders_copy_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_User_Multiple_folders_copy failed","MyFiles_Share_with_me_Page_User_Multiple_folders_copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	
		
		//-----------------------MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy---------------------------


public static void MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy() 
{

	try
	{

		actions = new Actions(driver);
				
		Navigation.login();
		
		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_share_Copy_Folder");
		actions.doubleClick(trs).perform();	
		Thread.sleep(1000);
		
		List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int nooffolders = Beforemovedfolders.size();
		System.out.println("No of folders Before " + nooffolders);
		click("select_all_folders");
		Thread.sleep(1000);
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before  " + nooffiles);
		click("select_all_files");
		Thread.sleep(1000);

		WebElement right1  =getPageObject("second_folder_infolder");
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		
		click("file_right_click_copy_move");
		
		WebElement trs1 =getPageObject("Right_click_MyFiles");
		actions.doubleClick(trs1).perform();
		Thread.sleep(1000);
		
		WebElement trs11 =getPageObject("Right_click_share_admin_folder");
		actions.doubleClick(trs11).perform();
		Thread.sleep(2000);
		
		getPageObject("Share_right_click_Folder_click").click();
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String collection_folder_name="Share MFiles-Folder copy "+dateFormatted;
		
		sendKeys("Create_Folder_name",collection_folder_name);
		
		Thread.sleep(1000);
		click("Create_button");
		Thread.sleep(1000);
		click("Recent_Copy");
		Thread.sleep(4000);
		click("Close_Pop");
		Thread.sleep(2000);
		
		WebDriverWait wait22211 = new WebDriverWait(driver, 60);
		wait22211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied.')]")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(1000);	
		
		WebElement els =getPageObject("My_Files");
		actions.doubleClick(els).perform();
		Thread.sleep(1000);		
		WebElement els1 =getPageObject("Admin_share_copy");
		actions.doubleClick(els1).perform();
		Thread.sleep(1000);		
		click("Sorting_order");
		Thread.sleep(2000);
		WebElement els11 =getPageObject("Second_Folder_click");
		actions.doubleClick(els11).perform();
		
		List<WebElement> Aftermovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int Aftermovedfolderstofolder = Aftermovedfolders.size();
		System.out.println("No of folders After " + Aftermovedfolderstofolder);

		if(Aftermovedfolderstofolder==nooffolders)
		{
			log.info("--------------------------No of  files is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy successfully","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy failed","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
	
		
		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of files After " + Aftermovedfilestofolder);
		
		if(Aftermovedfilestofolder==nooffiles)
		{
			log.info("--------------------------No of files is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy successfully","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy failed","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy failed","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	
		

			//--------------------------MyFiles_Share_with_me_Page_Multiple_Files_Move----------------------------


public static void MyFiles_Share_with_me_Page_Multiple_Files_Move() 
{

	try
	{

		actions = new Actions(driver);
				
		Navigation.other_user_in_same_tenant();
		
		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

	//	getPageObject("User_share_Move_Folder").click();
		
		WebElement right  =	getPageObject("User_share_Move_Folder");
		actions.contextClick(right).perform();
		click("Share");
		Thread.sleep(2000);
		
		WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr.sendKeys("ce");
		
		
		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
			
		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		click("share_button");
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shared successfully.']")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		
		// AdminConsole login
				Navigation.login();

				WebDriverWait wait511 = new WebDriverWait(driver, 120);
				wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
				Thread.sleep(1000);
				click("Plus-Buttom");
				Thread.sleep(1000);
				getPageObject("Plus_New_Folder").click();
				Thread.sleep(1000);
				sendKeys("ente_folder_name","Admin Share Move");
				click("Ok");
				Thread.sleep(1000);
				WebDriverWait wait2221 = new WebDriverWait(driver, 60);
				wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Folder is created successfully.')]")));
				Thread.sleep(2000);
				click("toast_close");
				
				Thread.sleep(1000);
				click("shared_with_me");
				Thread.sleep(1000);
				WebElement trs =getPageObject("User_share_Move_Folder");
				actions.doubleClick(trs).perform();	
//				click("select_all_folders");
				Thread.sleep(1000);
				
				List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//div[@class='files-info']"));
				int nooffiles = Beforemovedfiles.size();
				System.out.println("No of files Before " + nooffiles);
				click("select_all_files");
				
				for(int i=2; i<=nooffiles-1; i++)
				{
					driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();

				}
		
				
				Thread.sleep(1000);
				WebElement right1  =	getPageObject("share_third_file");
				actions.contextClick(right1).perform();
				Thread.sleep(1000);
				
				click("file_right_click_copy_move");
				
				WebElement trs1 =getPageObject("Right_click_MyFiles");
				actions.doubleClick(trs1).perform();
				Thread.sleep(1000);
				
				WebElement trs11 =getPageObject("Right_click_Admin_share_Move");
				actions.doubleClick(trs11).perform();
				Thread.sleep(2000);
				
				getPageObject("Share_right_click_Folder_click").click();
				Thread.sleep(1000);
				DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

				//get current date time with Date()
				Date date = new Date();

				// Now format the date
				String dateFormatted= dateFormat.format(date);

				String collection_folder_name="Share MFiles move "+dateFormatted;
				
				sendKeys("Create_Folder_name",collection_folder_name);
				
				Thread.sleep(1000);
				click("Create_button");
				Thread.sleep(1000);
				click("move_button");
				Thread.sleep(2000);
				click("Close_Pop");
				
				WebDriverWait wait22211 = new WebDriverWait(driver, 60);
				wait22211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
				Thread.sleep(2000);
				click("toast_close");
				
				WebDriverWait wait5111 = new WebDriverWait(driver, 120);
				wait5111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
				
				WebElement els =getPageObject("My_Files");
				actions.doubleClick(els).perform();
				Thread.sleep(2000);
				WebElement els1 =getPageObject("Folder_Admin_share_Move");
				actions.doubleClick(els1).perform();
				Thread.sleep(2000);
				WebElement els11 =getPageObject("Single_Folder_click");
				actions.doubleClick(els11).perform();
				
				List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
				int Aftermovedfilestofolder = Aftermovedfiles.size();
				System.out.println("No of files After " + Aftermovedfilestofolder);

				if(Aftermovedfilestofolder==2)
				{
					log.info("--------------------------No of  files is equal to before------------------------------");

					captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Move_success.png");
					Thread.sleep(2000);
					ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Move successfully","MyFiles_Share_with_me_Page_Multiple_Files_Move",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				}
				else 
				{
					captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Move_failed.png");
					Thread.sleep(2000);
					ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Move failed","MyFiles_Share_with_me_Page_Multiple_Files_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					Thread.sleep(2000);
				}
			
				//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_Multiple_Files_Move",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Move_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Move failed","MyFiles_Share_with_me_Page_Multiple_Files_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

			//----------------------------MyFiles_Share_with_me_Page_Multiple_Folders_move--------------------------------------


public static void MyFiles_Share_with_me_Page_Multiple_Folders_move() 
{

	try
	{

		actions = new Actions(driver);
				
		Navigation.login();
		
		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_share_Move_Folder");
		actions.doubleClick(trs).perform();	
		Thread.sleep(1000);
		
		List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int nooffolders = Beforemovedfolders.size();
		System.out.println("No of folders Before " + nooffolders);
		
		click("select_all_folders");
		Thread.sleep(1000);
		
		for(int i=2; i<=nooffolders-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='folder']//*[@type='checkbox'])["+i+"]")).click();

		}
		
		WebElement right1  =getPageObject("third_folder_infolder");
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		
		click("file_right_click_copy_move");
		
		WebElement trs1 =getPageObject("Right_click_MyFiles");
		actions.doubleClick(trs1).perform();
		Thread.sleep(1000);
		
		WebElement trs11 =getPageObject("Right_click_Admin_share_Move");
		actions.doubleClick(trs11).perform();
		Thread.sleep(2000);
		
		getPageObject("Share_right_click_Folder_click").click();
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String collection_folder_name="Share MFolder Move "+dateFormatted;
		
		sendKeys("Create_Folder_name",collection_folder_name);
		
		Thread.sleep(1000);
		click("Create_button");
		Thread.sleep(2000);
		click("move_button");
		Thread.sleep(2000);
		click("Close_Pop");
		Thread.sleep(2000);
		WebDriverWait wait22211 = new WebDriverWait(driver, 60);
		wait22211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);	
		
		WebElement els =getPageObject("My_Files");
		actions.doubleClick(els).perform();
		Thread.sleep(1000);	
		
		WebElement els1 =getPageObject("Folder_Admin_share_Move");
		actions.doubleClick(els1).perform();
		Thread.sleep(1000);		
		
		click("Sorting_order");
		WebElement els11 =getPageObject("Single_Folder_click");
		actions.doubleClick(els11).perform();
		
		List<WebElement> Aftermovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int Aftermovedfolderstofolder = Aftermovedfolders.size();
		System.out.println("No of folders After " + Aftermovedfolderstofolder);

		if(Aftermovedfolderstofolder==2)
		{
			log.info("--------------------------No of  Folders is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Folders_move_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Folders_move successfully","MyFiles_Share_with_me_Page_Multiple_Folders_move",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Folders_move_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Folders_move failed","MyFiles_Share_with_me_Page_Multiple_Folders_move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
	
		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_Multiple_Folders_move",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Folders_move_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Folders_move failed","MyFiles_Share_with_me_Page_Multiple_Folders_move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	


		//-----------------------MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move-----------------------


public static void MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move() 
{

	try
	{

		actions = new Actions(driver);
				
		Navigation.login();
		
		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_share_Move_Folder");
		actions.doubleClick(trs).perform();	
		Thread.sleep(1000);
		
		List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int nooffolders = Beforemovedfolders.size();
		System.out.println("No of folders Before " + nooffolders);
		
		click("select_all_folders");
		
		Thread.sleep(1000);
		
		for(int i=2; i<=nooffolders-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='folder']//*[@type='checkbox'])["+i+"]")).click();

		}
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//div[@class='files-info']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);
		
		click("select_all_files");
		
		for(int i=2; i<=nooffiles-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();

		}
		
		WebElement right1  =getPageObject("Second_File");
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		
		click("file_right_click_copy_move");
		
		WebElement trs1 =getPageObject("Right_click_MyFiles");
		actions.doubleClick(trs1).perform();
		Thread.sleep(1000);
		
		WebElement trs11 =getPageObject("Right_click_Admin_share_Move");
		actions.doubleClick(trs11).perform();
		Thread.sleep(2000);
		
		getPageObject("Share_right_click_Folder_click").click();
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String collection_folder_name="Share M Files_Folders Move "+dateFormatted;
		
		sendKeys("Create_Folder_name",collection_folder_name);
		
		Thread.sleep(1000);
		click("Create_button");
		Thread.sleep(2000);
		click("move_button");
		Thread.sleep(2000);
		click("Close_Pop");
		Thread.sleep(2000);
		WebDriverWait wait22211 = new WebDriverWait(driver, 60);
		wait22211.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);	
		
		WebElement els =getPageObject("My_Files");
		actions.doubleClick(els).perform();
		Thread.sleep(1000);	
		
		WebElement els1 =getPageObject("Folder_Admin_share_Move");
		actions.doubleClick(els1).perform();
		Thread.sleep(1000);		
		
  //		click("Sorting_order");
		WebElement els11 =getPageObject("Single_Folder_click");
		actions.doubleClick(els11).perform();
		
		List<WebElement> Aftermovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int Aftermovedfolderstofolder = Aftermovedfolders.size();
		System.out.println("No of folders After " + Aftermovedfolderstofolder);

		if(Aftermovedfolderstofolder==2)
		{
			log.info("--------------------------No of  Folders is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move successfully","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move failed","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		
		List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfiles1 = Aftermovedfiles2.size();
		System.out.println("No of files Shared" + Aftermovedfiles1);
		
		if(Aftermovedfiles1==2)
		{


			log.info("--------------------------No of  files is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move successfully","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move failed","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
	
		//Profile LogOut
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
	log.error("Error in MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move failed","MyFiles_Share_with_me_Page_Multiple_Files_Folders_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}	

		//-------------------------MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move------------------------


public static void MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move() 
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);		
		Navigation.other_user_in_same_tenant();
		
		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		
		WebElement right  =	getPageObject("User_share_Drag_Drop_Folder");
		actions.contextClick(right).perform();
		click("Share");
		Thread.sleep(2000);
		
		WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr.sendKeys("ce");
		
		
		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
			
		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		click("share_button");
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shared successfully.']")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		// AdminConsole Login
		Navigation.login();
		
		Thread.sleep(1000);
		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_share_Drag_Drop_Folder");
		actions.doubleClick(trs).perform();	
	
		click("Plus-Buttom");
		Thread.sleep(1000);
		getPageObject("Plus_New_Folder").click();
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String multiple_file_folder_name="UserShare DreagDrop Move "+dateFormatted;
		sendKeys("Create-FolderName",multiple_file_folder_name);
		click("Ok");
		Thread.sleep(3000);

		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before-Moved" + nooffiles);

		WebElement close = driver.findElement(By.xpath("//div[contains(text(),'Folder is created successfully')]"));
		close.click();
		Thread.sleep(2000);
		click("select_all_files");
		
		for(int i=2; i<=nooffiles-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();
		}
		
		WebElement drag = driver.findElement(By.xpath("(//div[@class='fileName'])[5]"));
		WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'"+multiple_file_folder_name+"')]"));

		//Actions ac = new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();

		Thread.sleep(3000);
		click("Cancel");
		WebDriverWait wait2221 = new WebDriverWait(driver, 60);
		wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
		Thread.sleep(2000);

		click("toast_close");

		Thread.sleep(4000);
		act.doubleClick(drop).perform();
		Thread.sleep(4000);

		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of files Moved" + Aftermovedfilestofolder);

		if(Aftermovedfilestofolder==2)
		{
			log.info("--------------------------------------------No of moved files is not equal to before--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move successfully","MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move failed","MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		
		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		Thread.sleep(3000);

		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		
		
	}
	catch (Exception e)
	{
		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move_Error.png");
		ATUReports.add("MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move failed","MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	}	


		//--------------------------MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move------------------------------


public static void MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move() 
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);		
		Navigation.login();
		
		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		Thread.sleep(1000);
		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_share_Drag_Drop_Folder");
		actions.doubleClick(trs).perform();	
	
		click("Plus-Buttom");
		Thread.sleep(1000);
		getPageObject("Plus_New_Folder").click();
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String multiple_folder_name="UserShare DreagDrop folderMove "+dateFormatted;
		sendKeys("Create-FolderName",multiple_folder_name);
		click("Ok");
		Thread.sleep(3000);

		List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int noofFolders = Beforemovedfolders.size();
		System.out.println("No of Folders Before-Moved" + noofFolders);

		Thread.sleep(3000);
		WebElement close = driver.findElement(By.xpath("//div[contains(text(),'Folder is created successfully')]"));
		close.click();
		Thread.sleep(3000);
		
		List<WebElement> BeforemovedMulti_folders = driver.findElements(By.xpath("//article[@class='folder-article']"));
		int noofMulti_folders = BeforemovedMulti_folders.size();
		System.out.println("No of Multi_folders Before Moved" + noofMulti_folders);
		
		click("Sorting_order");
		click("select_all_folders");
		
		for(int i=2; i<=noofFolders-1; i++)
		{
			driver.findElement(By.xpath("(//div[@class='folder']//*[@type='checkbox'])["+i+"]")).click();
		}
		
		int j =noofMulti_folders-1; 
		WebElement drag = driver.findElement(By.xpath("(//div[@class='folder-name'])["+j+"]"));
		WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'"+multiple_folder_name+"')]"));

		Actions ac = new Actions(driver);
		ac.dragAndDrop(drag, drop).build().perform();

		Thread.sleep(2000);
		click("Cancel");
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
		Thread.sleep(2000);

		click("toast_close");

		Thread.sleep(2000);
		act.doubleClick(drop).perform();

		List<WebElement> Aftermovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int Aftermovedfolderstofolder = Aftermovedfolders.size();
		System.out.println("No of Folders Moved" + Aftermovedfolderstofolder);

		if(Aftermovedfolderstofolder==2)
		{
			log.info("--------------------------------------------No of moved multiple_folders is not equal to before--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move successfully","MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move failed","MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		Thread.sleep(3000);

		WebDriverWait wait35 = new WebDriverWait(driver, 60);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		
		
	}
	catch (Exception e)
	{
		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move_Error.png");
		ATUReports.add("MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move failed","MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	}	

			//---------------------------MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Folders--------------------------

public static void MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Files_Folders() 
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

		Thread.sleep(1000);
		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_share_Drag_Drop_Folder");
		actions.doubleClick(trs).perform();	

		click("Plus-Buttom");
		driver.findElement(By.xpath("(//span[contains(text(),'New Folder')])[2]")).click();

		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String multiple_data_folder_name="User Share Drag Drop Multi Data "+dateFormatted;
		sendKeys("Create-FolderName",multiple_data_folder_name);
		click("Ok");
		Thread.sleep(3000);


		List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//*[@class='folder-article']"));
		int nooffolders = Beforemovedfolders.size();
		System.out.println("No of folders Before-Moved" + nooffolders);

		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before-Moved" + nooffiles);

		WebElement close = driver.findElement(By.xpath("//div[contains(text(),'Folder is created successfully')]"));
		close.click();
		Thread.sleep(2000);
		click("select_all_folders");
		click("select_all_files");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='check-box checked'])[1]")).click();

		WebElement drag = driver.findElement(By.xpath("(//div[@class='folder-name'])[2]"));
		WebElement drop = driver.findElement(By.xpath("//div[contains(text(),'"+multiple_data_folder_name+"')]"));

		Actions ac = new Actions(driver);
		ac.dragAndDrop(drag, drop).build().perform();

		Thread.sleep(3000);
		click("Cancel");
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
		Thread.sleep(2000);

		click("toast_close");
		Thread.sleep(4000);
		act.doubleClick(drop).perform();
		Thread.sleep(4000);

		List<WebElement> Aftermovedfolders =driver.findElements(By.xpath("//*[@class='folder-article']"));
		int	Aftermovedfolderstofolder = Aftermovedfolders .size();
		System.out.println("No of folders Moved" + Aftermovedfolderstofolder);

		if(Aftermovedfolderstofolder==6)
		{
			log.info("--------------------------No of Folders Moved is  not equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath +"DragDropMove_multiple_Data_success.png");
			Thread.sleep(2000);
			ATUReports.add("DragDropMove_multiple_Data successfully","DragDropMove_multiple_Data",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			Thread.sleep(2000); 
		}
		else 
		{
			captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Data_failed.png");
			Thread.sleep(2000);
			ATUReports.add("DragDropMove_multiple_Data failed","DragDropMove_multiple_Data",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}


		List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfilestofolder = Aftermovedfiles.size();
		System.out.println("No of Files Moved" + Aftermovedfilestofolder);

		if(Aftermovedfilestofolder==4)
		{
			log.info("--------------------------------------------No of moved files is  equal to before--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Data_success.png");
			Thread.sleep(2000);
			ATUReports.add("DragDropMove_multiple_Data successfully","DragDropMove_multiple_Data",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		else
		{
			captureScreenShot(ScreenShotsFilePath + "DragDropMove_multiple_Data_failed.png");
			Thread.sleep(2000);
			ATUReports.add("DragDropMove_multiple_Data failed","DragDropMove_multiple_Data",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

	}
	catch (Exception e)
	{
		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move_Error.png");
		ATUReports.add("MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move failed","MyFiles_Share_with_me_Page_Drag_Drop_Multiple_Folders_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}	


		//------------------------MyFiles_Share_with_me_Page_File_Preview----------------------------


public static void MyFiles_Share_with_me_Page_File_Preview() 
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);		
		Navigation.other_user_in_same_tenant();
		
		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		
		WebElement right  =	getPageObject("User_Share_File_Preview_Folder");
		actions.contextClick(right).perform();
		click("Share");
		Thread.sleep(2000);
		
		WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr.sendKeys("ce");
		
		
		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));
			
		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		click("share_button");
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Shared successfully.']")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		// AdminConsole Login
		Navigation.login();
		
		Thread.sleep(1000);
		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs).perform();	
		
		String file1 =driver.findElement(By.xpath("//div[contains(text(),'New Text.txt')]")).getText();
		System.out.println(file1);


		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		click("click_preview");
		Thread.sleep(1000);
		
		String file2 =driver.findElement(By.xpath("//div[contains(text(),'New Text.txt')]")).getText();
		System.out.println(file2);
		
		if(file1.equals (file2))
		{
			log.info("--------------------------No of  file name is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview successfully","MyFiles_Share_with_me_Page_File_Preview",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview failed","MyFiles_Share_with_me_Page_File_Preview",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		Thread.sleep(3000);

		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


	}
	catch (Exception e)
	{
		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Share_with_me_Page_File_Preview",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Error.png");
		ATUReports.add("MyFiles_Share_with_me_Page_File_Preview failed","MyFiles_Share_with_me_Page_File_Preview",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}	

	
		//--------------------MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation---------------------


public static void MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs).perform();	

		String file1 =driver.findElement(By.xpath("//div[contains(text(),'New Text.txt')]")).getText();
		System.out.println(file1);


		WebElement right=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		click("click_preview");
		Thread.sleep(1000);

		String file2 =driver.findElement(By.xpath("//div[contains(text(),'New Text.txt')]")).getText();
		System.out.println(file2);

		if(file1.equals (file2))
		{


			log.info("--------------------------No of  file name is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation successfully","MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation failed","MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		Thread.sleep(1000);
		click("Arrow_Right");

		String file3 =driver.findElement(By.xpath("//span[@title='Sample 1.docx']")).getText();
		System.out.println(file3);

		if(file2 != file3)
		{


			log.info("--------------------------No of  file name is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation successfully","MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation failed","MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		Thread.sleep(1000);
		click("Arrow_Left");
		Thread.sleep(1000);
		click("Left_Back");
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


		{
			log.info("--------------------------No of Fle name------------------------------");

			captureScreenShot(ScreenShotsFilePath +"MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation successfully","MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		

	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation_failed_Error.png");
		ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation failed","MyFiles_Share_with_me_Page_File_Preview_Right_and_Left_Naviation",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

		//-----------------------MyFiles_Share_with_me_Page_File_Preview_Download-------------------------


public static void MyFiles_Share_with_me_Page_File_Preview_Download()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs).perform();	
		
		//Right click on First File
		WebElement right=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right).perform();

		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(2000);
		click("Download_Icon");
		Thread.sleep(2000);
		click("Download_Icon");
		click("File_Preview_Download");
		Thread.sleep(2000);
		click("File_preview_download_save");
		Thread.sleep(3000);
		click("Left_Back");

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
	log.error("Error in MyFiles_Share_with_me_Page_File_Preview_Download",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Download_failed_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Download failed","MyFiles_Share_with_me_Page_File_Preview_Download",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}
			
		//--------------------------MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User---------------------------------


public static void MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs).perform();	
		
		WebElement right=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Share_Icon");
		Thread.sleep(1000);

		WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr.sendKeys("ba");

		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		click("share_button");

		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared successfully.')]")));
		Thread.sleep(2000);
		click("toast_close");

		Thread.sleep(1000);
		click("Left_Back");
		Thread.sleep(3000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		Navigation.other_tenant();

		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

		Thread.sleep(2000);
		click("shared_with_me");

		List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfiles1 = Aftermovedfiles2.size();
		System.out.println("No of files Shared" + Aftermovedfiles1);

		if(Aftermovedfiles1==1)
		{


			log.info("--------------------------No of  files is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_File_Preview_Share_to_Internal_User_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_File_Preview_Share_to_Internal_User successfully","MyFiles_File_Preview_Share_to_Internal_User",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_File_Preview_Share_to_Internal_User_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_File_Preview_Share_to_Internal_User failed","MyFiles_File_Preview_Share_to_Internal_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		//Right click Options
		WebElement elementLocator9 = getPageObject("share_first_file");
		actions.contextClick(elementLocator9).perform();
		Thread.sleep(2000);
																					

		WebElement shared_file_right_click_options1 = driver.findElement(By.xpath("//div[@class='files']//div[@class='context-list'][1]/ul"));
		List<WebElement> each_file_li_tag1=shared_file_right_click_options1.findElements(By.tagName("li"));

		for(int i=0;i<each_file_li_tag1.size();i++)
		{

			WebElement li =each_file_li_tag1.get(i);
			String each_li = each_file_li_tag1.get(i).getText();
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
		{

			log.info("--------------------------------------------files shared with edit permission successfully--------------------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User_successfully.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User successfully","MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User successfully",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		Thread.sleep(5000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait351 = new WebDriverWait(driver, 120);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		Navigation.login();

		
		WebDriverWait wait511 = new WebDriverWait(driver, 120);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		
		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs1 =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs1).perform();	

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Share_Icon");
		Thread.sleep(1000);

		select("shared_user_popup_dropdown","visibletext","Remove");
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		

		WebDriverWait wait2221 = new WebDriverWait(driver, 60);
		wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared successfully.')]")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(1000);
		click("Left_Back");
		
		Thread.sleep(3000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait3511 = new WebDriverWait(driver, 120);
		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User_failed_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User failed","MyFiles_Share_with_me_Page_File_Preview_Share_to_Internal_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//------------------------------MyFiles_Share_with_me_Page_File_Preview_Share_to_Group----------------------------


public static void MyFiles_Share_with_me_Page_File_Preview_Share_to_Group()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs).perform();

		WebElement right=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Share_Icon");
		Thread.sleep(1000);

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
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared successfully.')]")));
		Thread.sleep(2000);
		click("toast_close");

		Thread.sleep(1000);
		click("Left_Back");
		Thread.sleep(5000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		Navigation.other_user_in_same_tenant();

		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

		Thread.sleep(2000);
		click("shared_with_me");

		List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Aftermovedfiles1 = Aftermovedfiles2.size();
		System.out.println("No of files Shared" + Aftermovedfiles1);

		if(Aftermovedfiles1==1)
		{


			log.info("--------------------------No of Shared files is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "File_Preview_Share_to_group_success.png");
			Thread.sleep(2000);
			ATUReports.add("File_Preview_Share_to_group successfully","File_Preview_Share_to_group",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "File_Preview_Share_to_group_failed.png");
			Thread.sleep(2000);
			ATUReports.add("File_Preview_Share_to_group failed","File_Preview_Share_to_group",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		Thread.sleep(3000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait351 = new WebDriverWait(driver, 120);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		Navigation.login();

		
		WebDriverWait wait511 = new WebDriverWait(driver, 120);
		wait511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

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
		getPageObject("File_Name").isDisplayed();
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("My_Files");
		Thread.sleep(1000);
		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs1 =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs1).perform();

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Share_Icon");
		Thread.sleep(1000);

		select("shared_user_popup_dropdown","visibletext","Remove");
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		

		WebDriverWait wait2221 = new WebDriverWait(driver, 60);
		wait2221.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared successfully.')]")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(1000);
		click("Left_Back");
		
		Thread.sleep(3000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait3511 = new WebDriverWait(driver, 120);
		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Share_with_me_Page_File_Preview_Share_to_Group",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Share_to_Group_failed_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Share_to_Group failed","MyFiles_Share_with_me_Page_File_Preview_Share_to_Group",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

			//-------------------------MyFiles_Share_with_me_Page_File_Preview_Share_with_link_to_Internal_User--------------------------



public static void MyFiles_Share_with_me_Page_File_Preview_Share_with_link_to_Internal_User()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs).perform();

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		
		click("click_preview");
		Thread.sleep(1000);
		click("Share_Icon");
		Thread.sleep(1000);
	
		Thread.sleep(1000);
		click("Copy");
		
		WebElement showLinkIn = driver.findElement(By.className("form-control"));
		String link_text = showLinkIn.getText();
		log.info("Copied link is : "+link_text);
		
		WebDriverWait wait53453 = new WebDriverWait(driver, 60);
		wait53453.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__toast-body']")));
		
		
		if(getPageObject("starred_toast").getText().contains("Copied successfully."));
		
		String copied_link_text = driver.findElement(By.xpath("//input[@class='form-control']")).getAttribute("value").toString();

		System.out.println("---------------------Copied link is : "+copied_link_text);
		click("File_share_close");
		
		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied successfully.')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		click("Left_Back");
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");

		WebDriverWait wait3511 = new WebDriverWait(driver, 120);
		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		

		Navigation.other_user_in_same_tenant();

		driver.get(Home_Page);
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));

		Thread.sleep(4000);
		driver.navigate().to(copied_link_text);
		Thread.sleep(3000);
		
//		WebDriverWait wait35 = new WebDriverWait(driver, 20);
//		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_Share_with_me_Page_File_Preview_Share_with_link_to_Internal_User",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Share_with_link_to_Internal_User_failed_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Share_with_link_to_Internal_User failed","MyFiles_Share_with_me_Page_File_Preview_Share_with_link_to_Internal_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//--------------------------MyFiles_Share_with_me_Page_File_Preview_Copy---------------------------------

public static void MyFiles_Share_with_me_Page_File_Preview_Copy()
{

	try
	{

		actions = new Actions(driver);
		Actions act= new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs).perform();	
		
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

//		WebElement el1 =driver.findElement(By.xpath("//span[text()='My Files_File Preview']"));
//		act.doubleClick(el1).perform();
		getPageObject("Folder_Create").click();
		Thread.sleep(1000);
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String collection_folder_name="Share Copy "+dateFormatted;
		sendKeys("Create_Folder_name",collection_folder_name);

		
	//	sendKeys("Create_Folder_name","Files Copy");
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

		WebElement el11 =driver.findElement(By.xpath("//div[contains(text(),'Share Copy')]"));
		act.doubleClick(el11).perform();

		List<WebElement> Aftercopyfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Afterfiles = Aftercopyfiles.size();
		System.out.println("No of files After Copy" + Afterfiles);


		if( Afterfiles== 1)
		{


			log.info("--------------------------No of  file name is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Copy_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Copy successfully","MyFiles_Share_with_me_Page_File_Preview_Copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Copy_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Copy failed","MyFiles_Share_with_me_Page_File_Preview_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
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
		log.error("Error in MyFiles_Share_with_me_Page_File_Preview_Copy",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Copy_failed_Error.png");
		ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Copy failed","MyFiles_Share_with_me_Page_File_Preview_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	}

			//--------------------------MyFiles_Share_with_me_Page_File_Preview_Move---------------------------


public static void MyFiles_Share_with_me_Page_File_Preview_Move()
{

	try
	{

		actions = new Actions(driver);
		Actions act= new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs).perform();	
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before Move" + nooffiles);


		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[3]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		click("Copy_Move");

		WebElement el =driver.findElement(By.xpath("//span[text()='My Drive']"));
		act.doubleClick(el).perform();

//		WebElement el1 =driver.findElement(By.xpath("//span[text()='My Files_File Preview']"));
//		act.doubleClick(el1).perform();
		Thread.sleep(2000);
		getPageObject("Folder_Create").click();
		Thread.sleep(1000);
				
		sendKeys("Create_Folder_name","Files Move");
		Thread.sleep(1000);
		click("Create_button");
		Thread.sleep(1000);
		getPageObject("move_button").click();
		click("Close_Pop");
		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved.')]")));
		Thread.sleep(1000);
		click("toast_close");
		click("Left_Back");
		
		WebElement el111 =driver.findElement(By.xpath("//img[@src='/static/img/context/my-files.svg']"));
		act.doubleClick(el111).perform();
		Thread.sleep(1000);

		
		WebElement el1111 =driver.findElement(By.xpath("//div[contains(text(),'Files Move')]"));
		act.doubleClick(el1111).perform();
		
		List<WebElement> Aftercopyfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Afterfiles = Aftercopyfiles.size();
		System.out.println("No of files After Move " + Afterfiles);


		if( Afterfiles== 1)
		{
			log.info("--------------------------No of  file  is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Move_success.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Move successfully","MyFiles_Share_with_me_Page_File_Preview_Move",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Move_failed.png");
			Thread.sleep(2000);
			ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Move failed","MyFiles_Share_with_me_Page_File_Preview_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}


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
	log.error("Error in MyFiles_Share_with_me_Page_File_Preview_Move",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Move_failed_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Move failed","MyFiles_Share_with_me_Page_File_Preview_Move",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}
		
			//---------------------------MyFiles_Share_with_me_Page_File_Preview_Cheak_Versions-----------------------------


public static void MyFiles_Share_with_me_Page_File_Preview_Cheak_Versions()
{

	try
	{

		actions = new Actions(driver);
		Actions act= new Actions(driver);
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		click("shared_with_me");
		Thread.sleep(1000);
		WebElement trs =getPageObject("User_Share_File_Preview_Folder");
		actions.doubleClick(trs).perform();	
		
		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[2]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("file_right_click_copy_move");
		
		WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
		act.doubleClick(el).perform();
		//Thread.sleep(3000);
		WebElement el1 =driver.findElement(By.xpath("//div[@class='cp-item-sec1']//img[@src='/static/img/Files/folder.png']"));
		act.doubleClick(el1).perform();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div//span[contains(text(),'versions')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ftr-cp-rt']//button[contains(text(),'Copy')]")).click();
		click("Update_Existing");
		Thread.sleep(2000);
		click("Close_Pop");
		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied')]")));
		Thread.sleep(1000);
		click("toast_close");
		
		WebElement el11 =driver.findElement(By.xpath("//div[contains(text(),'versions')]"));
		act.doubleClick(el11).perform();
//		click("Left_Back");

		List<WebElement> Aftercopyfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int Afterfiles = Aftercopyfiles.size();
		System.out.println("No of files After Copy" + Afterfiles);


		if( Afterfiles== 2)
		{

			log.info("--------------------------No of  file name is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "File_Preview_Copy_success.png");
			Thread.sleep(2000);
			ATUReports.add("File_Preview_Copy successfully","File_Preview_Copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "File_Preview_Copy_failed.png");
			Thread.sleep(2000);
			ATUReports.add("File_Preview_Copy failed","File_Preview_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		WebElement right11=	driver.findElement(By.xpath("(//*[@class='fileName'])[2]"));
		actions.contextClick(right11).perform();
		click("View_version");
		
		String name1 = driver.findElement(By.xpath("(//span[@class='elp-block'])[2]")).getText();
		System.out.println(name1);
		
		Thread.sleep(1000);
		click("toast_close");
		
		WebElement right111=	driver.findElement(By.xpath("(//*[@class='fileName'])[2]"));
		actions.contextClick(right111).perform();
		click("click_preview");
		Thread.sleep(1000);
		click("Details_circle");
		Thread.sleep(1000);
		click("Saved_versions");
		
		String name2 = driver.findElement(By.xpath("(//div[@class='info-bx-cnt'])[2]")).getText();
		System.out.println(name2);
		
		if( !name1.equals(name2))
		{

			log.info("--------------------------No of  file name is  equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath + "File_Preview_Copy_success.png");
			Thread.sleep(2000);
			ATUReports.add("File_Preview_Copy successfully","File_Preview_Copy",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}

		else 
		{
			captureScreenShot(ScreenShotsFilePath + "File_Preview_Copy_failed.png");
			Thread.sleep(2000);
			ATUReports.add("File_Preview_Copy failed","File_Preview_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
		}
		
		//Profile click and logout
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
	log.error("Error in MyFiles_Share_with_me_Page_File_Preview_Cheak_Versions",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Share_with_me_Page_File_Preview_Cheak_Versions_failed_Error.png");
	ATUReports.add("MyFiles_Share_with_me_Page_File_Preview_Cheak_Versions failed","MyFiles_Share_with_me_Page_File_Preview_Cheak_Versions",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}}
























