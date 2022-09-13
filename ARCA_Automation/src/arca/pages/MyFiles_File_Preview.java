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
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import arca.common.Navigation;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class MyFiles_File_Preview extends Navigation{
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_File_Preview.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_File_Preview(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_File_Preview");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_File_Preview--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_File_Preview.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "MyFiles_File_Preview";
	}



		//------------------------------------MyFiles_File_Preview---------------------------

	public static void MyFiles_File_Preview()
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			//Double click on element
			WebElement ele = getPageObject("Folder_File_Preview");
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			WebElement right=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
			actions.contextClick(right).perform();
			Thread.sleep(1000);
			click("click_preview");
			Thread.sleep(1000);
			click("Arrow_Right");
			Thread.sleep(1000);
			click("Arrow_Left");
			Thread.sleep(1000);
			
			{
				log.info("--------------------------No of MyFiles_Reminders_Files_Bell_Icon------------------------------");

				captureScreenShot(ScreenShotsFilePath +"MyFiles_File_Preview_success.png");
				Thread.sleep(2000);
				ATUReports.add("MyFiles_File_Preview successfully","MyFiles_File_Preview",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_File_Preview",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_File_Preview_failed_Error.png");
			ATUReports.add("MyFiles_File_Preview failed","MyFiles_File_Preview",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	
	//-------------------------------------MyFiles_File_Preview_Download---------------------------------


public static void MyFiles_File_Preview_Download()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

		WebElement right=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Download_Icon");
//		Thread.sleep(2000);
		
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		Thread.sleep(4000);
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		

	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_File_Preview_Download",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_File_Preview_Download_Error.png");
		ATUReports.add("MyFiles_File_Preview_Download failed","MyFiles_File_Preview_Download",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


	//-----------------------------------MyFiles_File_Preview_Share_to_Internal_User---------------------------------
public static void MyFiles_File_Preview_Share_to_Internal_User()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

		WebElement right=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Share_Icon");
		Thread.sleep(1000);
		
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
		
		Thread.sleep(5000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		
		WebDriverWait wait351 = new WebDriverWait(driver, 120);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_File_Preview_Share_to_Internal_User",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_File_Preview_Share_to_Internal_User_Error.png");
		ATUReports.add("MyFiles_File_Preview_Share_to_Internal_User failed","MyFiles_File_Preview_Share_to_Internal_User",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


		//-----------------------------------File_Preview_Share_to_group-----------------------------

public static void File_Preview_Share_to_group()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

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
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shared Successfully')]")));
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
		Thread.sleep(5000);
		click("Profile_Icon");
		Thread.sleep(2000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		
		WebDriverWait wait351 = new WebDriverWait(driver, 120);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		
		
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in File_Preview_Share_to_group",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "File_Preview_Share_to_group_Error.png");
		ATUReports.add("File_Preview_Share_to_group failed","File_Preview_Share_to_group",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


	
		//-----------------------------------File_Preview_Share_with_link_to_Internal_User-----------------------


public static void File_Preview_Share_with_link_to_Internal_User()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Share_Icon");
		Thread.sleep(1000);

		WebElement noUserOr1 = driver.findElement(By.xpath("//input[@placeholder='Search Users or Groups']"));
		noUserOr1.sendKeys("li");

		WebDriverWait wait311 = new WebDriverWait(driver, 60);
		wait311.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(1000);
		click("Copy");

		WebDriverWait wait351 = new WebDriverWait(driver, 60);
		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Copied Successfully')]")));
		Thread.sleep(1000);
		click("toast_close");
		Thread.sleep(1000);
		click("toast_close");
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

		Thread.sleep(2000);
		click("shared_with_me");
		Thread.sleep(2000);
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in File_Preview_Share_to_group",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "File_Preview_Share_to_group_Error.png");
		ATUReports.add("File_Preview_Share_to_group failed","File_Preview_Share_to_group",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}



	//-------------------------------------File_Preview_Copy--------------------------------------
	
public static void File_Preview_Copy()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		click("Copy_Move");
		
		WebElement el =driver.findElement(By.xpath("//span[text()='My Drive']"));
		act.doubleClick(el).perform();
		
		WebElement el1 =driver.findElement(By.xpath("//span[text()='My Files_File Preview']"));
		act.doubleClick(el1).perform();
		click("Copy");
		click("Update_Existing");
		click("Cancel");
		

	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in File_Preview_Copy",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "File_Preview_Copy_Error.png");
		ATUReports.add("File_Preview_Copy failed","File_Preview_Copy",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}



		//---------------------------File_Preview_Move---------------------------------

public static void File_Preview_Move()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		click("Copy_Move");
		
		WebElement el =driver.findElement(By.xpath("//span[text()='My Drive']"));
		act.doubleClick(el).perform();
		
		WebElement el1 =driver.findElement(By.xpath("//span[text()='My Files_File Preview']"));
		act.doubleClick(el1).perform();
		click("move_button");
		
		click("Update_Existing");
		click("Cancel");


}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in MyFiles_File_Preview",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_File_Preview_Error.png");
	ATUReports.add("MyFiles_File_Preview failed","MyFiles_File_Preview",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


	//--------------------------------------------File_Preview_Check_Versions----------------------------------------		


public static void File_Preview_Check_Versions()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(2000);
		click("click_preview");
		Thread.sleep(1000);
		click("Three_Dots");
		click("View_Version");
		Thread.sleep(4000);
		
		//Profile click and logout
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");
		Thread.sleep(4000);
		

}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in File_Preview_Check_Versions",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "File_Preview_Check_Versions_Error.png");
	ATUReports.add("File_Preview_Check_Versions failed","File_Preview_Check_Versions",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


	//-----------------------------------------File_Preview_Add_Comment---------------------------------------


public static void File_Preview_Add_Comment()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

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
		Thread.sleep(4000);
		


}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in File_Preview_Add_Comment",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "File_Preview_Add_Comment_Error.png");
	ATUReports.add("File_Preview_Add_Comment failed","File_Preview_Add_Comment",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


//-----------------------------------------File_Preview_Add_Tag---------------------------------------


public static void File_Preview_Add_Tag()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

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
		
		WebElement right11=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
		actions.contextClick(right11).perform();
		Thread.sleep(2000);
		click("click_preview");
		click("Three_Dots");
		click("Add_View_Tags");
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
		Thread.sleep(4000);

		
}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in File_Preview_Add_Tag",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "File_Preview_Add_Tag_Error.png");
	ATUReports.add("File_Preview_Add_Tag failed","File_Preview_Add_Tag",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

	//---------------------------------File_Preview_Rename------------------------------------


public static void File_Preview_Rename()
{

	try
	{

		actions = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_File_Preview");
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();

		WebElement right1=	driver.findElement(By.xpath("(//*[@class='fileName'])[1]"));
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
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='New Text Renamed to Test 1']")));
		Thread.sleep(1000);
		click("toast_close");
		click("Left_Back");
		//Profile click and logout
		Thread.sleep(1000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		click("Ok");
		Thread.sleep(4000);

}
catch (Exception e) {

	System.out.println("errror at: ");
	e.printStackTrace();
	log.error("Error in File_Preview_Rename",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "File_Preview_Rename_Error.png");
	ATUReports.add("File_Preview_Rename failed","File_Preview_Rename",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}
}