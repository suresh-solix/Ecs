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
import java.util.concurrent.TimeUnit;

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

public class MyFiles__PST__Extraction extends Navigation{
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles__PST__Extraction.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public static String Guest_Home_Page = "https://tebyy.solixecsdev.com";
	public MyFiles__PST__Extraction(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	//	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles__PST__Extraction");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles__PST__Extraction--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles__PST__Extraction.png");
	}
	private void setAuthorInfoForReports()
	{
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription()
	{
		ATUReports.indexPageDescription = "MyFiles__PST__Extraction";
	}


	
	//------------------------------MyFiles__PST__Extraction_Admin_Account--------------------------------

	public static void MyFiles__PST__Extraction_Admin_Account() 
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
			WebElement ele = getPageObject("Pst_Folder"); 
			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();
			
			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before " + nooffiles);

			WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right).perform();
			click("file_right_click_copy_move");
			
			WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
			act.doubleClick(el).perform();
			
			WebElement el1 =getPageObject("PST_fol");
			act.doubleClick(el1).perform();
			Thread.sleep(2000);
			
			getPageObject("Folder_Create").click();
			Thread.sleep(2000);
			
			DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String dateFormatted= dateFormat.format(date);

			String name= "PST Extraction"+dateFormatted;

			log.info("Creating  name: "+name);

			sendKeys("Create_Folder_name",name);
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
			
			getPageObject("Pst_extrate").click();
			Thread.sleep(4000);
			
			WebElement el11 =driver.findElement(By.xpath("(//div[@class='folder-name'])[1]"));
			act.doubleClick(el11).perform();
			Thread.sleep(9000);
			driver.navigate().refresh();
			
			WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right1).perform();
			Thread.sleep(1000);
			click("Right_click_Extract_PST");
			Thread.sleep(1000);
			
			WebDriverWait wait3511 = new WebDriverWait(driver, 60);
			wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Extraction has started, will take some time to complete')]")));
			Thread.sleep(1000);
			click("toast_close");  
			Thread.sleep(15000);
			
			WebDriverWait wait51 = new WebDriverWait(driver, 120);
			wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);
				
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
	log.error("Error in MyFiles__PST__Extraction_Admin_Account",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles__PST__Extraction_Admin_Account_failed_Error.png");
	ATUReports.add("MyFiles__PST__Extraction_Admin_Account failed","MyFiles__PST__Extraction_Admin_Account",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}

}


			//-----------------------------MyFiles__PST__Extraction_Admin_Account_Console-----------------------

	public static void MyFiles__PST__Extraction_Admin_Account_Console() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();
			Actions act = new Actions(driver);
			driver.get(Home_Page);
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Admin_Console");
			Thread.sleep(1000);
			click("Content");
	//		Thread.sleep(2000);
			click("Admin_Name");
			Thread.sleep(1000);
			WebElement el11 =driver.findElement(By.xpath("//div[contains(text(),'PST Extraction Admin')]"));
			act.doubleClick(el11).perform();
			Thread.sleep(2000);
			
			WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
			actions.contextClick(right1).perform();
			Thread.sleep(1000);
			click("Right_click_Extract_PST");
			
			
			WebDriverWait wait3511 = new WebDriverWait(driver, 60);
			wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Extraction has started, will take some time to complete')]")));
			Thread.sleep(1000);
			click("toast_close");  
			Thread.sleep(20000);
			
			driver.navigate().refresh();
	
			
//			WebElement el111 =driver.findElement(By.xpath("//div[@title='destination']"));
//			act.doubleClick(el111).perform();
//			Thread.sleep(2000);
//						
//			WebElement el211 =driver.findElement(By.xpath("//div[@class='folder-name'][contains(text(),'My Messages')]"));
//			act.doubleClick(el211).perform();
//			Thread.sleep(2000);
//			
//			List<WebElement> Aftermovedfiles2 = driver.findElements(By.xpath("//*[@class='files-footer']"));
//			int Aftermovedfiles1 = Aftermovedfiles2.size();
//			System.out.println("No of Files " + Aftermovedfiles1);
//
//			if(Aftermovedfiles1!=0)
//			{
//				log.info("--------------------------No of  files ------------------------------");
//
//				captureScreenShot(ScreenShotsFilePath + "MyFiles__PST__Extraction_Admin_Account_Console_success.png");
//				Thread.sleep(2000);
//				ATUReports.add("MyFiles__PST__Extraction_Admin_Account_Console successfully","MyFiles__PST__Extraction_Admin_Account_Console",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
//				Thread.sleep(2000);
//			}
//
//			else 
//			{
//				captureScreenShot(ScreenShotsFilePath + "MyFiles__PST__Extraction_Admin_Account_Console_failed.png");
//				Thread.sleep(2000);
//				ATUReports.add("MyFiles__PST__Extraction_Admin_Account_Console failed","MyFiles__PST__Extraction_Admin_Account_Console",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
//				Thread.sleep(2000);
//			}
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
	log.error("Error in MyFiles__PST__Extraction_Admin_Account_Console",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles__PST__Extraction_Admin_Account_Console_failed_Error.png");
	ATUReports.add("MyFiles__PST__Extraction_Admin_Account_Console failed","MyFiles__PST__Extraction_Admin_Account_Console",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}

}


		//--------------------------MyFiles__PST__Extraction_User_Account-------------------------

public static void MyFiles__PST__Extraction_User_Account() 
{

	try
	{

		actions = new Actions(driver);

		Navigation.other_user_in_same_tenant();
		
		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		
		//Double click on element
		WebElement ele = getPageObject("User_PST_Folder"); 
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
		
		List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
		int nooffiles = Beforemovedfiles.size();
		System.out.println("No of files Before " + nooffiles);

		WebElement right=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
		actions.contextClick(right).perform();
		click("file_right_click_copy_move");
		
		WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
		act.doubleClick(el).perform();
		
		WebElement el1 =getPageObject("PST_fol");
		act.doubleClick(el1).perform();
		Thread.sleep(2000);
		
		getPageObject("Folder_Create").click();
		Thread.sleep(2000);
		
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);

		String name= "PST Extraction"+dateFormatted;

		log.info("Creating  name: "+name);

		sendKeys("Create_Folder_name",name);
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
		
		getPageObject("Pst_extrate").click();
		Thread.sleep(4000);
		
		WebElement el11 =driver.findElement(By.xpath("(//div[@class='folder-name'])[1]"));
		act.doubleClick(el11).perform();
		Thread.sleep(8000);
		
		driver.navigate().refresh();
		
		WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
		actions.contextClick(right1).perform();
		Thread.sleep(1000);
		click("Right_click_Extract_PST");
		Thread.sleep(1000);
		
		WebDriverWait wait3511 = new WebDriverWait(driver, 60);
		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Extraction has started, will take some time to complete')]")));
		Thread.sleep(1000);
		click("toast_close"); 
		
		Thread.sleep(12000);
		driver.navigate().refresh();
		
		WebDriverWait wait51 = new WebDriverWait(driver, 120);
		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
		
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
log.error("Error in MyFiles__PST__Extraction_User_Account",e);	
//log.fatal(e.getMessage(),e);
captureScreenShot(ScreenShotsFilePath + "MyFiles__PST__Extraction_User_Account_failed_Error.png");
ATUReports.add("MyFiles__PST__Extraction_User_Account failed","MyFiles__PST__Extraction_User_Account",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}


		//--------------------MyFiles__PST__Extraction_Guest_User_Account---------------------------

public static void MyFiles__PST__Extraction_Guest_User_Account() 
{

	try
	{
		
		actions = new Actions(driver);
		Actions act = new Actions(driver);
		
		Navigation.other_user_in_same_tenant();
		
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);
				
		WebElement right=	driver.findElement(By.xpath("//div[@title='Guest User PST Extraction']"));
		actions.contextClick(right).perform();
		Thread.sleep(1000);
		
		WebElement Addtocollections =	getPageObject("external_sharing");
		actions.moveToElement(Addtocollections).perform();
		Thread.sleep(2000);

		WebElement Create = driver.findElement(By.xpath("//*[contains(text(),'Guest Accounts')]"));
		Create.click();
		Thread.sleep(2000);
		
		WebElement noUserOr = driver.findElement(By.xpath("//input[@placeholder='Search Guest Users']"));
		noUserOr.sendKeys("ke");


		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='multiselect__content']/li[1]")));

		getPageObject("search_result_first_element").click(); 
		Thread.sleep(2000);
		click("share_button");
		Thread.sleep(2000);
		click("share_button");
		
		WebDriverWait wait222 = new WebDriverWait(driver, 60);
		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Shared successfully.')]")));
		Thread.sleep(2000);
		click("toast_close");
		Thread.sleep(2000);
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		
		WebDriverWait wait35 = new WebDriverWait(driver, 120);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));


		
		
//		driver.get(Guest_Home_Page);
//		Navigation.external_guest_user();
//		
//		WebDriverWait wait51 = new WebDriverWait(driver, 120);
//		wait51.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
//		Thread.sleep(1000);
//		
//		//Double click on element
//		WebElement ele1 = getPageObject("Guest_Pst_Folder"); 
//		Actions act1 = new Actions(driver);
//		act1.doubleClick(ele1).perform();
//		
//		WebElement right1=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
//		actions.contextClick(right1).perform();
//		click("file_right_click_copy_move");
//		
////		WebElement el =driver.findElement(By.xpath("//*[@class='cp-list-item']//span[contains(text(),'My Files')]"));
////		act1.doubleClick(el).perform();
//		
//		WebElement el1 =getPageObject("Right_click_Guest");
//		act1.doubleClick(el1).perform();
//		Thread.sleep(2000);
//		
//		getPageObject("Folder_Create").click();
//		Thread.sleep(2000);
//		
//		DateFormat dateFormat = new SimpleDateFormat("MMM-dd HH-mm");
//
//		//get current date time with Date()
//		Date date = new Date();
//
//		// Now format the date
//		String dateFormatted= dateFormat.format(date);
//
//		String name= "PST Extraction"+dateFormatted;
//
//		log.info("Creating  name: "+name);
//
//		sendKeys("Create_Folder_name",name);
//		Thread.sleep(2000);
//		click("Create_button");
//		Thread.sleep(2000);
//		getPageObject("Recent_Copy").click();
//		Thread.sleep(2000);
//		click("Close_Pop");
//		WebDriverWait wait351 = new WebDriverWait(driver, 60);
//		wait351.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully copied.')]")));
//		Thread.sleep(1000);
//		click("toast_close");  
//		
//		getPageObject("Pst_extrate").click();
//		Thread.sleep(4000);
//		
//		WebElement el11 =driver.findElement(By.xpath("(//div[@class='folder-name'])[1]"));
//		act1.doubleClick(el11).perform();
//		Thread.sleep(7000);
//		
//		driver.navigate().refresh();
//		
//		WebElement right11=	driver.findElement(By.xpath("(//div[@class='files-info'])[1]"));
//		actions.contextClick(right11).perform();
//		Thread.sleep(1000);
//		
//		
//		
//		WebDriverWait wait3511 = new WebDriverWait(driver, 60);
//		wait3511.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Extraction has started, will take some time to complete')]")));
//		Thread.sleep(1000);
//		click("toast_close");  
//		Thread.sleep(15000);
//		driver.navigate().refresh();
////		Thread.sleep(1000);
//		
//		Thread.sleep(1000);
//		click("Profile_Icon");
//		Thread.sleep(2000);
//		click("Sign_out");
//		Thread.sleep(1000);
//		click("Ok");
//
//		WebDriverWait wait35111 = new WebDriverWait(driver, 120);
//		wait35111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

}
catch (Exception e)
{

System.out.println("errror at: ");
e.printStackTrace();
log.error("Error in MyFiles__PST__Extraction_Guest_User_Account",e);	
//log.fatal(e.getMessage(),e);
captureScreenShot(ScreenShotsFilePath + "MyFiles__PST__Extraction_Guest_User_Account_failed_Error.png");
ATUReports.add("MyFiles__PST__Extraction_Guest_User_Account failed","MyFiles__PST__Extraction_Guest_User_Account",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}
}