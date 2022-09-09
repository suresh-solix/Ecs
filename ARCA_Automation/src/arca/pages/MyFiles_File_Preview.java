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
		Thread.sleep(2000);

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
}
