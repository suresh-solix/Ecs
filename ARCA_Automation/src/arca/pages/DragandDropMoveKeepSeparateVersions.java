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


public class DragandDropMoveKeepSeparateVersions extends Navigation{
	
	static WebDriver driver;
	static Actions actions;
  

	private static Logger log = Logger.getLogger(DragandDropMoveKeepSeparateVersions.class.getName());
	public static String Home_Page = "https://app.solixecsdev.com/login";
	public DragandDropMoveKeepSeparateVersions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS).pageLoadTimeout(60, TimeUnit.SECONDS);
		ATUReports.setWebDriver(driver);
		ATUReports.setTestCaseReqCoverage("DragandDropMoveKeepSeparateVersions");
		setIndexPageDescription();
		setAuthorInfoForReports();
		log.info("--------------------DragandDropMoveKeepSeparateVersions--------------------");
		captureScreenShot(ScreenShotsFilePath + "DragandDropMoveKeepSeparateVersions.png");
	}
	private void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Mahesh", Utils.getCurrentTime(),"2.0");
	}

	private void setIndexPageDescription() {
		ATUReports.indexPageDescription = "DragandDropMoveKeepSeparateVersions";
	}


	//--------------------------DragandDropMoveKeepSeparateVersions_multiple_Files---------------------------

	public static void DragandDropMoveKeepSeparateVersions_multiple_Files() 
	{

		try
		{

			actions = new Actions(driver);

			Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(3000);
			//Double click on element
			WebElement ele = getPageObject("Move_KSV_Test");

			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before Moved" + nooffiles);
			click("select_all_files");

			for(int i=2; i<=nooffiles-1; i++)
			{
				driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();
			}

			int j =nooffiles-1;
			WebElement drag = driver.findElement(By.xpath("(//div[@class='fileName'])["+j+"]"));
			WebElement drop = driver.findElement(By.xpath("//div[contains(text(),' Move Keep Separate Test ')]"));

			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).build().perform();
			Thread.sleep(5000);
			click("Keep_Separate");
			Thread.sleep(3000);
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]")));
			Thread.sleep(2000);


			click("toast_close");

			Thread.sleep(4000);
			act.doubleClick(drop).perform();
			Thread.sleep(4000);
			List<WebElement> Aftermovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int Aftermovedfilestofolder = Aftermovedfiles.size();
			System.out.println("No of files Moved" + Aftermovedfilestofolder);
			if(Aftermovedfilestofolder!=8)
			{


				log.info("--------------------------No of moved files is not equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveKeepSeparateVersions_multiple_Files_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Files successfully","DragandDropMoveKeepSeparateVersions_multiple_Files",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			else
			{
				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveKeepSeparateVersions_multiple_Files_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Files failed","DragandDropMoveKeepSeparateVersions_multiple_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
		}

			catch (Exception e)
		{

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragandDropMoveKeepSeparateVersions_multiple_Files",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragandDropMoveKeepSeparateVersions_multiple_Files_failed_Error.png");
			ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Files_files failed","DragandDropMoveKeepSeparateVersions_multiple_Files",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}





//----------------------------------------DragandDropMoveKeepSeparateVersions_multiple_Folders------------------------


	public static void DragandDropMoveKeepSeparateVersions_multiple_Folders()
	{

		try
		{

			actions = new Actions(driver);

	//		Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(3000);
			//Double click on element
			WebElement ele = getPageObject("Move_KSV_Test");

			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//article[@class='folder-article']"));
			int nooffolders = Beforemovedfolders.size();
			System.out.println("No of folders Before Moved" + nooffolders);
			driver.findElement(By.xpath("//a[@title='Sort Order']")).click();
			click("select_all_folders");

			for(int i=2; i<=nooffolders-1; i++)
			{
				driver.findElement(By.xpath("(//div[@class='folder']//*[@type='checkbox'])["+i+"]")).click();
			}

			Thread.sleep(5000);

			int j =nooffolders-1; 
			WebElement drag =driver.findElement(By.xpath("(//div[@class='folder-name'])["+j+"]"));
			WebElement drop =driver.findElement(By.xpath("//div[contains(text(),' Move Keep Separate Test ')]"));

			Actions ac = new Actions(driver); ac.dragAndDrop(drag,drop).build().perform();
			Thread.sleep(3000); 
			click("Keep_Separate");
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

			if(Aftermovedfolderstofolder!=2)
			{


				log.info("--------------------------No of moved folders is not equal to before------------------------------");

				captureScreenShot(ScreenShotsFilePath +"DragandDropMoveKeepSeparateVersions_multiple_Folders_success.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Folders successfully","DragandDropMoveKeepSeparateVersions_multiple_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				Thread.sleep(2000); 
			}
			else 
			{
				captureScreenShot(ScreenShotsFilePath + "DragandDropMoveKeepSeparateVersions_multiple_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Folders failed","DragandDropMoveKeepSeparateVersions_multiple_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
		}
			
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragandDropMoveKeepSeparateVersions_multiple_Folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragandDropMoveKeepSeparateVersions_multiple_Folders_failed_Error.png");
			ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Folders_files failed","DragandDropMoveKeepSeparateVersions_multiple_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	}




     //---------------------------------------DragandDropMoveKeepSeparateVersions_multiple_Files_Folders--------------------


	public static void DragandDropMoveKeepSeparateVersions_multiple_Files_Folders()
	{

		try
		{

			actions = new Actions(driver);

	//		Navigation.login();

			driver.get(Home_Page);
			WebDriverWait wait5 = new WebDriverWait(driver, 120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Files')]")));
			Thread.sleep(3000);
			//Double click on element
			WebElement ele = getPageObject("Move_KSV_Test");

			Actions act = new Actions(driver);
			act.doubleClick(ele).perform();

			List<WebElement> Beforemovedfolders = driver.findElements(By.xpath("//article[@class='folder-article']"));
			int nooffolders = Beforemovedfolders.size();
			System.out.println("No of folders Before Moved" + nooffolders);
			driver.findElement(By.xpath("//a[@title='Sort Order']")).click();
			click("select_all_folders");
			
			for(int i=2; i<=nooffolders-1; i++)
			{
				driver.findElement(By.xpath("(//div[@class='folder']//*[@type='checkbox'])["+i+"]")).click();
			}

			List<WebElement> Beforemovedfiles = driver.findElements(By.xpath("//*[@class='files-footer']"));
			int nooffiles = Beforemovedfiles.size();
			System.out.println("No of files Before Moved" + nooffiles);
			click("select_all_files");

			for(int i=2; i<=nooffiles-1; i++)
			{
				driver.findElement(By.xpath("(//div[@class='files']//*[@type='checkbox'])["+i+"]")).click();
			}
			Thread.sleep(5000);

			int j =nooffolders-1; 
			WebElement drag =driver.findElement(By.xpath("(//div[@class='folder-name'])["+j+"]"));
			WebElement drop =driver.findElement(By.xpath("//div[contains(text(),'Move Keep Separate Test')]"));

			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag,drop).build().perform();
			Thread.sleep(3000); 
			
			click("Keep_Separate");
			Thread.sleep(3000); 
			click("Cancel");
			WebDriverWait wait222 = new WebDriverWait(driver, 60);
			wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully moved')]"))); 
			Thread.sleep(2000);
			click("toast_close");
			
			Thread.sleep(4000); 
			act.doubleClick(drop).perform();
			Thread.sleep(4000); 
			
			List<WebElement> AftermovedMulti_folders =driver.findElements(By.xpath("//*[@class='folder-article']"));
			int	AftermovedMulti_folderstofolder = AftermovedMulti_folders.size();
			System.out.println("No of Multi_folders Moved" + AftermovedMulti_folderstofolder);

			if(AftermovedMulti_folderstofolder!=8) 
			{


			log.info("--------------------------No of moved Multi_files_folders is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath +"DragandDropMoveKeepSeparateVersions_multiple_Files_Folders_success.png");
			Thread.sleep(2000);
			ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Files_Folders successfully","DragandDropMoveKeepSeparateVersions_multiple_Files_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			}
			else
			{
				captureScreenShot(ScreenShotsFilePath +"DragandDropMoveKeepSeparateVersions_multiple_Files_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Files_Folders failed","DragandDropMoveKeepSeparateVersions_multiple_Files_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}
			List<WebElement> AftermovedMulti_files =driver.findElements(By.xpath("//*[@class='files-footer']"));
			int	AftermovedMulti_filestofolder = AftermovedMulti_files.size();
			System.out.println("No of Multi_files Moved" + AftermovedMulti_filestofolder);

			if(nooffolders==AftermovedMulti_filestofolder) 
			{


			log.info("--------------------------No of moved Multi_files is equal to before------------------------------");

			captureScreenShot(ScreenShotsFilePath +"DragandDropMoveKeepSeparateVersions_multiple_Files_Folders_success.png");
			Thread.sleep(2000);
			ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Files_Folders successfully","DragandDropMoveKeepSeparateVersions_multiple_Files_Folders",LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			}
			else
			{
				captureScreenShot(ScreenShotsFilePath +"DragandDropMoveKeepSeparateVersions_multiple_Files_Folders_failed.png");
				Thread.sleep(2000);
				ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Files_Folders failed","DragandDropMoveKeepSeparateVersions_multiple_Files_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Thread.sleep(2000);
			}


		}
		catch (Exception e) {

			System.out.println("errror at: ");
			e.printStackTrace();
			log.error("Error in DragandDropMoveKeepSeparateVersions_multiple_Folders",e);	
			//log.fatal(e.getMessage(),e);
			captureScreenShot(ScreenShotsFilePath + "DragandDropMoveKeepSeparateVersions_multiple_Folders_failed_Error.png");
			ATUReports.add("DragandDropMoveKeepSeparateVersions_multiple_Folders_files failed","DragandDropMoveKeepSeparateVersions_multiple_Folders",LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
}
