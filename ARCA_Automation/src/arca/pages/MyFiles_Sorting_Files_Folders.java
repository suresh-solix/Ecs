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

public class MyFiles_Sorting_Files_Folders extends Navigation{
	
	static WebDriver driver;
	static Actions actions;


	private static Logger log = Logger.getLogger(MyFiles_Sorting_Files_Folders.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public MyFiles_Sorting_Files_Folders(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("MyFiles_Sorting_Files_Folders");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------MyFiles_Sorting_Files_Folders--------------------");
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Sorting_Files_Folders.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "MyFiles_Sorting_Files_Folders";
	}

	
			//------------------------MyFiles_Sorting_Files_Folders_AZ_Grid_view--------------------------
	
	public static void MyFiles_Sorting_Files_Folders_AZ_Grid_view()
	{

		try
		{

			actions = new Actions(driver);
			Actions act = new Actions(driver);
			
			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			//Double click on element
			WebElement ele = getPageObject("Folder_sorting_Test");
			act.doubleClick(ele).perform();
			Thread.sleep(2000);
			click("name_recent_click");
			Thread.sleep(1000);
			click("sorting_Name");
			Thread.sleep(3000);
			click("sorting_view_details");
			
			// Folders  Cheaking
			List<WebElement> folders = driver.findElements(By.xpath("//article[@class='folder-article']"));
			int nooffolders = folders.size();
			System.out.println("No of folders " + nooffolders);
			
			for(int i=1; i<=nooffolders; i++)
			{
				driver.findElement(By.xpath("(//article[@class='folder-article'])["+i+"]")).click();
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			getPageObject("Details_Created").isDisplayed();
			
			//Files Cheaking
			List<WebElement> Files = driver.findElements(By.xpath("//div[@class='files-info']"));
			int nooffiles = Files.size();
			System.out.println("No of Files" + nooffiles);
			
			for(int i=1; i<=nooffiles; i++)
			{
				driver.findElement(By.xpath("(//div[@class='files-info'])["+i+"]")).click();
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			getPageObject("Details_Created").isDisplayed();
			
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(5000);

			WebDriverWait wait35 = new WebDriverWait(driver, 60);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Sorting_Files_Folders_AZ_Grid_view",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Sorting_Files_Folders_AZ_Grid_view_failed_Error.png");
			ATUReports.add("MyFiles_Sorting_Files_Folders_AZ_Grid_view failed","MyFiles_Sorting_Files_Folders_AZ_Grid_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	
				//------------------------------MyFiles_Sorting_Files_Folders_ZA_Grid_view---------------------------
	
	
	public static void MyFiles_Sorting_Files_Folders_ZA_Grid_view()
	{

		try
		{

			actions = new Actions(driver);
			Actions act = new Actions(driver);
			
			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			//Double click on element
			WebElement ele = getPageObject("Folder_sorting_Test");
			act.doubleClick(ele).perform();
			Thread.sleep(2000);
			click("name_recent_click");
			Thread.sleep(1000);
			click("sorting_Name");
			Thread.sleep(3000);
			click("Sorting_order");
			click("sorting_view_details");
			Thread.sleep(2000);
			
			
			// Folders  Cheaking
			List<WebElement> folders = driver.findElements(By.xpath("//article[@class='folder-article']"));
			int nooffolders = folders.size();
			System.out.println("No of folders " + nooffolders);
			
			for(int i=1; i<=nooffolders; i++)
			{
				driver.findElement(By.xpath("(//article[@class='folder-article'])["+i+"]")).click();
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			getPageObject("Details_Created").isDisplayed();
			
			//Files Cheaking
			List<WebElement> Files = driver.findElements(By.xpath("//div[@class='files-info']"));
			int nooffiles = Files.size();
			System.out.println("No of Files" + nooffiles);
			
			for(int i=1; i<=nooffiles; i++)
			{
				driver.findElement(By.xpath("(//div[@class='files-info'])["+i+"]")).click();
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			getPageObject("Details_Created").isDisplayed();
			
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(5000);

			WebDriverWait wait35 = new WebDriverWait(driver, 60);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Sorting_Files_Folders_ZA_Grid_view",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Sorting_Files_Folders_ZA_Grid_view_failed_Error.png");
			ATUReports.add("MyFiles_Sorting_Files_Folders_ZA_Grid_view failed","MyFiles_Sorting_Files_Folders_ZA_Grid_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	
	     //----------------------------MyFiles_Sorting_Files_Folders_AZ_List_view-------------------------
	
	public static void MyFiles_Sorting_Files_Folders_AZ_List_view()
	{

		try
		{

			actions = new Actions(driver);
			Actions act = new Actions(driver);
			
			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(1000);

			//Double click on element
			WebElement ele = getPageObject("Folder_sorting_Test");
			act.doubleClick(ele).perform();
			Thread.sleep(2000);
			click("name_recent_click");
			Thread.sleep(1000);
			click("sorting_Name");
			click("List_View");
			Thread.sleep(3000);
			click("sorting_view_details");
			
			// Folders  Cheaking
			List<WebElement> folders = driver.findElements(By.xpath("//div[@class='media folder-cl']"));
			int nooffolders = folders.size();
			System.out.println("No of folders " + nooffolders);
			
			for(int i=1; i<=nooffolders; i++)
			{
				driver.findElement(By.xpath("(//div[@class='media folder-cl'])["+i+"]")).click();
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			getPageObject("Details_Created").isDisplayed();
			
			//Files Cheaking
//			List<WebElement> Files = driver.findElements(By.xpath("//div[@class='files-info']"));
//			int nooffiles = Files.size();
//			System.out.println("No of Files" + nooffiles);
//			
//			for(int i=1; i<=nooffiles; i++)
//			{
//				driver.findElement(By.xpath("(//div[@class='media folder-cl']//img[@src='/static/img/Files/txt.svg'])["+i+"]")).click();
//				Thread.sleep(2000);
//			}
//			Thread.sleep(2000);
//			getPageObject("Details_Created").isDisplayed();
			
			click("Profile_Icon");
			Thread.sleep(1000);
			click("Sign_out");
			Thread.sleep(1000);
			click("Ok");
			Thread.sleep(5000);

			WebDriverWait wait35 = new WebDriverWait(driver, 60);
			wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in MyFiles_Sorting_Files_Folders_AZ_List_view",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "MyFiles_Sorting_Files_Folders_AZ_List_view_failed_Error.png");
			ATUReports.add("MyFiles_Sorting_Files_Folders_AZ_List_view failed","MyFiles_Sorting_Files_Folders_AZ_List_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

			//--------------------------MyFiles_Sorting_Files_Folders_ZA_List_view--------------------------------
	
public static void MyFiles_Sorting_Files_Folders_ZA_List_view()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);
		
		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_sorting_Test");
		act.doubleClick(ele).perform();
		Thread.sleep(2000);
		click("name_recent_click");
		Thread.sleep(1000);
		click("sorting_Name");
		click("List_View");
		Thread.sleep(3000);
		click("Sorting_order");
		click("sorting_view_details");
		Thread.sleep(2000);
		
		// Folders  Cheaking
		List<WebElement> folders = driver.findElements(By.xpath("//div[@class='media folder-cl']"));
		int nooffolders = folders.size();
		System.out.println("No of folders " + nooffolders);
		
		for(int i=1; i<=nooffolders; i++)
		{
			driver.findElement(By.xpath("(//div[@class='media folder-cl'])["+i+"]")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
		getPageObject("Details_Created").isDisplayed();
		
		//Files Cheaking
//		List<WebElement> Files = driver.findElements(By.xpath("//div[@class='media folder-cl']"));
//		int nooffiles = Files.size();
//		System.out.println("No of Files" + nooffiles);
//		
//		for(int i=1; i<=nooffiles; i++)
//		{
//			driver.findElement(By.xpath("(//div[@class='media folder-cl'])["+i+"]")).click();
//			Thread.sleep(2000);
//		}
//		Thread.sleep(2000);
//		getPageObject("Details_Created").isDisplayed();
		
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		Thread.sleep(5000);

		WebDriverWait wait35 = new WebDriverWait(driver, 60);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Sorting_Files_Folders_ZA_List_view",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Sorting_Files_Folders_ZA_List_view_failed_Error.png");
		ATUReports.add("MyFiles_Sorting_Files_Folders_ZA_List_view failed","MyFiles_Sorting_Files_Folders_ZA_List_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}

	
		//------------------------------MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view----------------------------------
	
	
public static void MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_sorting_Test");
		act.doubleClick(ele).perform();
		Thread.sleep(2000);

		click("name_recent_click");
		Thread.sleep(1000);
		click("Sorting_Recent");
		Thread.sleep(3000);
		click("Sorting_order");
		click("sorting_view_details");
		Thread.sleep(2000);

		// Folders  Cheaking
		List<WebElement> folders = driver.findElements(By.xpath("//article[@class='folder-article']"));
		int nooffolders = folders.size();
		System.out.println("No of folders " + nooffolders);

		for(int i=1; i<=nooffolders; i++)
		{
			driver.findElement(By.xpath("(//article[@class='folder-article'])["+i+"]")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
		getPageObject("Details_Created").isDisplayed();

		//Files Cheaking
		List<WebElement> Files = driver.findElements(By.xpath("//div[@class='files-info']"));
		int nooffiles = Files.size();
		System.out.println("No of Files" + nooffiles);

		for(int i=1; i<=nooffiles; i++)
		{
			driver.findElement(By.xpath("(//div[@class='files-info'])["+i+"]")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
		getPageObject("Details_Created").isDisplayed();

		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		Thread.sleep(5000);

		WebDriverWait wait35 = new WebDriverWait(driver, 60);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view_failed_Error.png");
		ATUReports.add("MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view failed","MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}


			//-----------------------------MyFiles_Sort_Files_Folders_Recent_Old_NewData_List_view--------------------------------
	
	
public static void MyFiles_Sort_Files_Folders_Recent_Old_NewData_List_view()
{

	try
	{

		actions = new Actions(driver);
		Actions act = new Actions(driver);

		Navigation.login();

		driver.get(Home_Page);
		WebDriverWait wait5 = new WebDriverWait(driver, 120);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
		Thread.sleep(1000);

		//Double click on element
		WebElement ele = getPageObject("Folder_sorting_Test");
		act.doubleClick(ele).perform();
		Thread.sleep(2000);

		click("name_recent_click");
		Thread.sleep(1000);
		click("Sorting_Recent");
		Thread.sleep(3000);
		click("Sorting_order");
		click("List_View");
		click("sorting_view_details");
		Thread.sleep(2000);

		// Folders  Cheaking
		List<WebElement> folders = driver.findElements(By.xpath("//div[@class='media folder-cl']"));
		int nooffolders = folders.size();
		System.out.println("No of folders " + nooffolders);

		for(int i=1; i<=nooffolders; i++)
		{
			driver.findElement(By.xpath("(//div[@class='media folder-cl'])["+i+"]")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
		getPageObject("Details_Created").isDisplayed();
		click("Profile_Icon");
		Thread.sleep(1000);
		click("Sign_out");
		Thread.sleep(1000);
		click("Ok");
		Thread.sleep(5000);

		WebDriverWait wait35 = new WebDriverWait(driver, 60);
		wait35.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));

	}
	catch (Exception e) {

		System.out.println("errror at: ");
		e.printStackTrace();
		log.error("Error in MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view",e);	
		//log.fatal(e.getMessage(),e);
		captureScreenShot(ScreenShotsFilePath + "MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view_failed_Error.png");
		ATUReports.add("MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view failed","MyFiles_Sort_Files_Folders_Recent_Old_NewData_Grid_view",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

