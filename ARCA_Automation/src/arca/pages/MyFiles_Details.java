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

public class MyFiles_Details extends Navigation {

	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(MyFiles_Details.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Details(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Details");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Details--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Details.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "MyFiles_Details";
	}

			//--------------------------MyFiles_Details_List_view_File----------------------------


public static void MyFiles_Details_List_view_File()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("List_View");
		
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		Thread.sleep(1000);
		click("Sorting_order");	
		Thread.sleep(2000);
		WebElement ele1 = getPageObject("List_Multiple_files");
		act.doubleClick(ele1).perform();
		
		click("sorting_view_details");
		Thread.sleep(2000);
		click("List_view_folder");
		
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
		log.error("Error in MyFiles_Details_List_view_File",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Details_List_view_File_failed_Error.png");
		ATUReports.add("MyFiles_Details_List_view_File failed","MyFiles_Details_List_view_File",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


		//-------------------------------MyFiles_Details_List_Grid_File-------------------------------------


public static void MyFiles_Details_List_Grid_File()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
	
		Thread.sleep(2000);
		WebElement ele1 = getPageObject("List_Multiple_files");
		act.doubleClick(ele1).perform();
		Thread.sleep(1000);
		click("View_Details");
		getPageObject("First_file").click();
		
		
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
	log.error("Error in MyFiles_Details_List_Grid_File",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Details_List_Grid_File_failed_Error.png");
	ATUReports.add("MyFiles_Details_List_Grid_File failed","MyFiles_Details_List_Grid_File",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}

		//----------------------------MyFiles_Details_List_view_Folder----------------------------------


public static void MyFiles_Details_List_view_Folder()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		click("List_View");
		
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
		Thread.sleep(1000);
		click("Sorting_order");	
		Thread.sleep(2000);
		WebElement ele1 = getPageObject("List_Multiple_folders");
		act.doubleClick(ele1).perform();
		click("Sorting_order");	
		
		click("sorting_view_details");
		Thread.sleep(1000);
		getPageObject("List_Fist_folder").click();
		
		
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
		log.error("Error in MyFiles_Details_List_view_Folder",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Details_List_view_Folder_failed_Error.png");
		ATUReports.add("MyFiles_Details_List_view_Folder failed","MyFiles_Details_List_view_Folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

		  //-----------------------------MyFiles_Details_List_Grid_Folder-------------------------
public static void MyFiles_Details_List_Grid_Folder()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		
		WebElement ele = getPageObject("Folder_List_view");
		act.doubleClick(ele).perform();
	
		Thread.sleep(2000);
		WebElement ele1 = getPageObject("List_Multiple_folders");
		act.doubleClick(ele1).perform();
		Thread.sleep(1000);
		click("View_Details");
		getPageObject("Grid_first_folder").click();
		
		
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
	log.error("Error in MyFiles_Details_List_Grid_Folder",e);	
	//log.fatal(e.getMessage(),e);
	captureScreenShot(ScreenShotsFilePath + "MyFiles_Details_List_Grid_File_failed_Error.png");
	ATUReports.add("MyFiles_Details_List_Grid_Folder failed","MyFiles_Details_List_Grid_Folder",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
}
}}









